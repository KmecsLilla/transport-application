package hu.webuni.transport.lilla.mapper;

import javax.validation.Valid;

import org.mapstruct.Mapper;

import hu.webuni.transport.lilla.dto.AddressDto;
import hu.webuni.transport.lilla.model.Address;

@Mapper(componentModel="spring")
public interface AddressMapper {

	Address dtoToAddress(@Valid AddressDto addressDto);

	AddressDto addressToDto(Address address);

}
