package hu.webuni.transport.lilla.mapper;

import java.util.List;

import javax.validation.Valid;

import org.mapstruct.Mapper;

import hu.webuni.transport.lilla.dto.AddressDto;
import hu.webuni.transport.lilla.dto.AddressFilterDto;
import hu.webuni.transport.lilla.model.Address;

@Mapper(componentModel="spring")
public interface AddressMapper {

	Address dtoToAddress(@Valid AddressDto addressDto);
	Address dtoToAddress(@Valid AddressFilterDto addressDto);

	AddressDto addressToDto(Address address);

	List<AddressDto> adressesToDtos(List<Address> addresses);



}
