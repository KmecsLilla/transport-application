package hu.webuni.transport.lilla.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddressFilterDto {

	@NotEmpty
	private String isoCode;
	@NotEmpty
	@NotNull
	private String postalCode;
	@NotEmpty
	@NotNull
	private String city;
	@NotEmpty
	@NotNull
	private String street;

	public AddressFilterDto() {
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

}
