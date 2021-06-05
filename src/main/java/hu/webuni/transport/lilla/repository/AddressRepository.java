package hu.webuni.transport.lilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.webuni.transport.lilla.model.Address;


public interface AddressRepository extends JpaRepository<Address, Long> {

}
