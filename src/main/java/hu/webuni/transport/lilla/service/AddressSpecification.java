package hu.webuni.transport.lilla.service;

import org.springframework.data.jpa.domain.Specification;

import hu.webuni.transport.lilla.model.Address;
import hu.webuni.transport.lilla.model.Address_;

public class AddressSpecification {

	public static Specification<Address> hasIsoCode(String isoCode) {
		return (root, cq, cb) -> cb.equal(root.get(Address_.isoCode), isoCode);
	}

	public static Specification<Address> hasPostalCode(String postalCode) {
		return (root, cq, cb) -> cb.equal(root.get(Address_.postalCode), postalCode);
	}

	public static Specification<Address> hasCity(String city) {
		return (root, cq, cb) -> cb.like(cb.lower(root.get(Address_.city)), (city + "%").toLowerCase());
	}

	public static Specification<Address> hasStreet(String street) {
		return (root, cq, cb) -> cb.like(cb.lower(root.get(Address_.street)), (street + "%").toLowerCase());
	}
}
