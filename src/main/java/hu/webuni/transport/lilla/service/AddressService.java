package hu.webuni.transport.lilla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import hu.webuni.transport.lilla.dto.AddressFilterDto;
import hu.webuni.transport.lilla.model.Address;
import hu.webuni.transport.lilla.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	@Transactional
	public Address save(Address address) {
		return addressRepository.save(address);
	}

	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	public Optional<Address> findAddressById(long id) {
		return addressRepository.findById(id);
	}

	@Transactional
	public void delete(long id) {
		addressRepository.deleteById(id);
	}
	@Transactional
	public Address update(Address address) {
		return addressRepository.save(address);
	}

//	public List<Address> findAddressByExample(Address exemple) {
//		String isoCode = exemple.getIsoCode();
//		String postalCode = exemple.getPostalCode();
//		String city = exemple.getCity();
//		String street = exemple.getStreet();
//
//		Specification<Address> spec = Specification.where(null);
//
//		if (StringUtils.hasText(isoCode)) {
//			spec = spec.and(AddressSpecification.hasIsoCode(isoCode));
//		}
//
//		if (StringUtils.hasText(postalCode)) {
//			spec = spec.and(AddressSpecification.hasPostalCode(postalCode));
//		}
//
//		if (StringUtils.hasText(city)) {
//			spec = spec.and(AddressSpecification.hasCity(city));
//		}
//
//		if (StringUtils.hasText(street)) {
//			spec = spec.and(AddressSpecification.hasStreet(street));
//		}
//
//		List<Address> foundHits = addressRepository.findAll(spec, Sort.by("id"));
//		if (foundHits.isEmpty()) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//		}
//		return foundHits;

//		return addressRepository.findAll(spec, Sort.by("id"));
//	}

	public Page<Address> findAddressByExample(AddressFilterDto example, Pageable pageable) {
		String isoCode = example.getIsoCode();
		String postalCode = example.getPostalCode();
		String city = example.getCity();
		String street = example.getStreet();

		Specification<Address> spec = Specification.where(null);

		if (StringUtils.hasText(isoCode)) {
			spec = spec.and(AddressSpecification.hasIsoCode(isoCode));
		}

		if (StringUtils.hasText(postalCode)) {
			spec = spec.and(AddressSpecification.hasPostalCode(postalCode));
		}

		if (StringUtils.hasText(city)) {
			spec = spec.and(AddressSpecification.hasCity(city));
		}

		if (StringUtils.hasText(street)) {
			spec = spec.and(AddressSpecification.hasStreet(street));
		}

		Page<Address> foundHits = addressRepository.findAll(spec, pageable);
		if (foundHits.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		return foundHits;
	}
}
