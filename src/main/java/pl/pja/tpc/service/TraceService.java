package pl.pja.tpc.service;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;



//
//import org.json.JSONArray;
//import org.json.JSONObject;
import org.omg.DynamicAny.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import pl.pja.tpc.entity.Trace;
import pl.pja.tpc.repository.TraceRepository;

@Service
@Transactional
public class TraceService {
	@Autowired
	private TraceRepository traceRepository;

	public List<Trace> findAll() {
		return traceRepository.findAll();
	}

	public Object findOne(int id) {
		return traceRepository.findOne(id);
	}

	public int save(Trace trace) {
//		https://developers.google.com/maps/documentation/directions/
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
		
		System.out.println(data);
		
		trace.setStartAddress(parseSimpleJson(data, "start_address"));
		trace.setEndAddress(parseSimpleJson(data, "end_address"));
		trace.setDistance(parseNestedJson(data, "distance", "text", 1));
		trace.setDuration(parseNestedJson(data, "duration", "text", 1));
		trace.setDate(new Date());
		traceRepository.save(trace);
		
		return trace.getId();
	}

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
	
	private String parseNestedJson(String input, String key, String subKey, int match) {
		String pattern = "\""+ key +"\" : \\{[^\\}]* \""+ subKey +"\" : ((\\d+)|\"?([\\w. ]+)\"?)";
		System.out.println(pattern);
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(input);
		if (m.find()) {
			return m.group(match).replace("\"", "");
		} else {
			return null;
		}
	}

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
			System.out.println(uri);
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

	public Object findLast() {
		return traceRepository.findAll(new PageRequest(0, 10, Direction.DESC,
				"date"));
	}
}
