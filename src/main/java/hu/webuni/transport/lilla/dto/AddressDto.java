package hu.webuni.transport.lilla.dto;

import javax.validation.constraints.NotEmpty;

public class AddressDto {

	private long id;
	@NotEmpty
	private String isoCode;
	@NotEmpty
	private String postalCode;
	@NotEmpty
	private String city;
	@NotEmpty
	private String street;
	@NotEmpty
	private int streetNumber;
	@NotEmpty
	private double longitude;
	private double latitude;

	public AddressDto(long id, String isoCode, String postalCode, String city, String street, int streetNumber,
			double longitude, double latitude) {
		super();
		this.id = id;
		this.isoCode = isoCode;
		this.postalCode = postalCode;
		this.city = city;
		this.street = street;
		this.streetNumber = streetNumber;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public AddressDto() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

}
