package hu.webuni.transport.lilla.web;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

	@PostMapping
	public AddressDto createAddress(@RequestBody @Valid AddressDto addressDto) {
		try {
			if(addressDto.getId() > 0) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
			Address address = addressMapper.dtoToAddress(addressDto);
				return addressMapper.addressToDto(addressService.save(address));
			} catch (NoSuchElementException e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
	}

	@GetMapping
	public List<AddressDto> getAllAddresses() {
		List<Address> addresses = null;
		addresses = addressService.findAll();
		return addressMapper.adressesToDtos(addresses);
	}

	@GetMapping("/{id}")
	public AddressDto getAddressById(@PathVariable long id) {
		AddressDto addressDto = addressMapper.addressToDto(addressService.findAddressById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
			return addressDto;
	}

	@DeleteMapping("/{id}")
	public void deleteAddress(@PathVariable long id) {
		addressService.delete(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AddressDto> modifyAddress(@PathVariable long id, @RequestBody @Valid AddressDto addressDto) {
		if (addressDto.getId() > 0 && addressDto.getId() != id) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		if (addressService.findAddressById(id).isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		addressDto.setId(id);
		Address address = addressMapper.dtoToAddress(addressDto);
		address = addressService.update(address);
		if (address != null) {
			addressDto = addressMapper.addressToDto(address);
			return ResponseEntity.ok(addressDto) ;
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
