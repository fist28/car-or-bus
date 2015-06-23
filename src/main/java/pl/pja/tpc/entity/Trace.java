package pl.pja.tpc.entity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Trace {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "source_city")
	private String sourceCity;

	@Column(name = "source_street")
	private String sourceStreet;

	@Column(name = "source_street_number")
	private String sourceStreetNumber;

	@Column(name = "destination_city")
	private String destinationCity;

	@Column(name = "destination_street")
	private String destinationStreet;

	@Column(name = "destination_street_number")
	private String destinationStreetNumber;

	@Column(name = "date")
	private Date date;

	@Column(name = "car_or_bus")
	private String carOrBus;

	private String distance;

	private String duration;

	@Column(name = "start_address")
	private String startAddress;

	@Column(name = "end_address")
	private String endAddress;

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getStartAddress() {
		return startAddress;
	}

	/**
	 * Konwertowanie adresu punktu początkowego do postaci zgodnej ze standardami adresu URL
	 * @return Przekonwertowany adres początkowy
	 */
	public String getEncodeStartAddress() {
		try {
			return URLEncoder.encode(startAddress, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	public void setStartAddress(String startAddress) {
		this.startAddress = startAddress;
	}

	public String getEndAddress() {
		return endAddress;
	}

	/**
	 * Konwertowanie adresu punktu końcowego do postaci zgodnej ze standardami adresu URL
	 * @return Przekonwertowany adres końcowy
	 */
	public String getEncodeEndAddress() {
		try {
			return URLEncoder.encode(endAddress, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	public void setEndAddress(String endAddress) {
		this.endAddress = endAddress;
	}

	/**
	 * 
	 * @param format - format daty w postaci Stringa zgodny z dokumnetacją dla java.text.SimpleDateFormat.SimpleDateFormat(String pattern)
	 * @return String z datą zgodną z podanym formatem, jeżel format jest null wtedy data zostanie wyświetlona w domyślnym formacie
	 */
	public String getDate(String format) {
		if (format == null) {
			return date.toString();
		} else {
			DateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.format(date);
		}
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * Klasa z Bootsrapa przedstawiająca środek komunikacji.
	 * @return String - klase css dla danego środka transportu 
	 */
	public String getCarOrBusClass() {
		if(carOrBus.contains("transit")){
			return "fa-bus";
		} else {
			return "fa fa-car";
		}
	}
	
	public String getCarOrBus() {
		return carOrBus;
	}

	public void setCarOrBus(String carOrBus) {
		this.carOrBus = carOrBus;
	}

	public String getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public String getSourceStreet() {
		return sourceStreet;
	}

	public void setSourceStreet(String sourceStreet) {
		this.sourceStreet = sourceStreet;
	}

	public String getSourceStreetNumber() {
		return sourceStreetNumber;
	}

	public void setSourceStreetNumber(String sourceStreetNumber) {
		this.sourceStreetNumber = sourceStreetNumber;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public String getDestinationStreet() {
		return destinationStreet;
	}

	public void setDestinationStreet(String destinationStreet) {
		this.destinationStreet = destinationStreet;
	}

	public String getDestinationStreetNumber() {
		return destinationStreetNumber;
	}

	public void setDestinationStreetNumber(String destinationStreetNumber) {
		this.destinationStreetNumber = destinationStreetNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
