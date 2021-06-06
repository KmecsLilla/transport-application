package hu.webuni.transport.lilla.service;

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
}
