package hu.webuni.transport.lilla.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.webuni.transport.lilla.dto.AddressDto;
import hu.webuni.transport.lilla.mapper.AddressMapper;
import hu.webuni.transport.lilla.model.Address;
import hu.webuni.transport.lilla.service.AddressService;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

	@Autowired
	AddressService addressService;

	@Autowired
	AddressMapper addressMapper;

	public AddressDto createAddress(@RequestBody @Valid AddressDto addressDto) {
		Address address = addressMapper.dtoToAddress(addressDto);
		return addressMapper.addressToDto(addressService.save(address));
	}

}
