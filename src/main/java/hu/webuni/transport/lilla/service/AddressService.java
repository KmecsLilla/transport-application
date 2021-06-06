package hu.webuni.transport.lilla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
