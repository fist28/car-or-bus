package pl.pja.tpc.service;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import pl.pja.tpc.entity.Trace;
import pl.pja.tpc.repository.TraceRepository;

@Service
@Transactional
public class TraceService {
	@Autowired
	private TraceRepository traceRepository;

	/**
	 * Metoda pobiera wszystkie trasy z bazy danych
	 * @return Lista wszystkich tras
	 */
	public List<Trace> findAll() {
		return traceRepository.findAll();
	}

	/**
	 * Metoda pobiera z bazy danych trase o podanym id
	 * @param id szukanej trasy
	 * @return Obiekt trasy
	 */
	public Trace findOne(int id) {
		return traceRepository.findOne(id);
	}

	/**
	 * Metoda na poodstawie obiektu Trace pobiera czas przejazdu z Google Maps Api z punktu startowego do punktu docelowego.
	 * Następnie wybierana jest szybsza trasa o zapisywane w bazie danych informacje o niej 
	 * Dokumentacjia API - https://developers.google.com/maps/documentation/directions/
	 * 
	 * @param obiekt trace posiadający wypełnione dane dotyczące punktu startowego i docelowego trasy
	 * @return id zapisanego w bazie danych obiektu trace
	 */
	public int save(Trace trace) {
		String transit = mapApiQuery(trace, "transit");
		String driving = mapApiQuery(trace, "driving");

		int durationTransit = Integer.parseInt(parseNestedJson(transit, "duration", "value", 1));
		int durationDriving = Integer.parseInt(parseNestedJson(driving, "duration", "value", 1));
		String data = "";
		if(durationTransit < durationDriving){
			data = transit;
			trace.setCarOrBus("transit");
		}else{
			data = driving;
			trace.setCarOrBus("driving");
		}
				
		trace.setStartAddress(parseSimpleJson(data, "start_address"));
		trace.setEndAddress(parseSimpleJson(data, "end_address"));
		trace.setDistance(parseNestedJson(data, "distance", "text", 1));
		trace.setDuration(parseNestedJson(data, "duration", "text", 1));
		trace.setDate(new Date());
		traceRepository.save(trace);
		
		return trace.getId();
	}

	/**
	 * Metoda parsująca Jsona bez zagnieżdżenia. 
	 * Metoda korzysta z wyrażeń regularnych do pobrania wartości.
	 * @param input - String z jsonem
	 * @param key - String z kluczem którego szukamy
	 * @return String ze znalezioną pierwszą wartością dla klucza. W przypadku nie znalezienia szukanego klucza zwróci null
	 */
	private String parseSimpleJson(String input, String key) {
		String pattern = "\""+ key + "\" : \"([^\"]*)\"";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(input);
		if (m.find()) {
			return m.group(1);
		} else {
			return null;
		}
	}
	
	/**
	 * Metoda parsująca Jsona z zagnieżdżeniem pierwszego stopnia.
	 * Metoda korzysta z wyrażeń regularnych do pobrania wartości.
	 * @param input - String z jsonem
	 * @param key - String z kluczem którego szukamy
	 * @param subKey - String z nazwą klucza 'rodzica'
	 * @param match - int z numerem dopasowania którego szukamy
	 * @return String ze znalezioną (dopasowanie zgodne z parametrem match) wartością dla klucza. W przypadku nie znalezienia szukanego klucza zwróci null
	 */
	private String parseNestedJson(String input, String key, String subKey, int match) {
		String pattern = "\""+ key +"\" : \\{[^\\}]* \""+ subKey +"\" : ((\\d+)|\"?([\\w. ]+)\"?)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(input);
		if (m.find()) {
			return m.group(match).replace("\"", "");
		} else {
			return null;
		}
	}

	/**
	 * Metoda wykonuje request do API Maps Google oraz otrzymuje odpowiedź w formie jsona
	 * @param trace - obiekt Trace zawierający parametry dotyczące punku startowego oraz końcowego
	 * @param mode - Rodzaj sprawdzanego środka transportu, możliwe parametry znajdują się w dokumentacji API - https://developers.google.com/maps/documentation/directions/#TravelModes
	 * @return Stringa zawierajacego JSON z odpoweidzią z API
	 */
	private String mapApiQuery(Trace trace, String mode) {
		URL obj;
		StringBuffer response = new StringBuffer();
		try {
			String query = "https://maps.googleapis.com/maps/api/directions/json?";
			String params = "origin="
					+ URLEncoder.encode(trace.getSourceCity(), "UTF-8")
					+ "%20"
					+ URLEncoder.encode(trace.getSourceStreet(), "UTF-8")
					+ "%20"
					+ URLEncoder.encode(trace.getSourceStreetNumber(), "UTF-8")
					+ "&"
					+ "destination="
					+ URLEncoder.encode(trace.getDestinationCity(), "UTF-8")
					+ "%20"
					+ URLEncoder.encode(trace.getDestinationStreet(), "UTF-8")
					+ "%20"
					+ URLEncoder.encode(trace.getDestinationStreetNumber(),
							"UTF-8") + "&" + "mode=" + mode + "&"
					+ "key=AIzaSyCPFbpY3mLqwrOaamzM2mQN0gw3zHboNVE";

			URI uri = new URI(query + params);
			obj = uri.toURL();

			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");

			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return response.toString();
	}

	/** 	
	 * Metoda wyszukuje ostatnie 10 wyszukiwanych tras
	 * @return Lista 10 ostatnich tras
	 */
	public List<Trace> findLast() {
		return traceRepository.findAll(new PageRequest(0, 10, Direction.DESC,
				"date")).getContent();
	}
}
