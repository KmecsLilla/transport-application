package hu.webuni.transport.lilla.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import hu.webuni.transport.lilla.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findAll(Specification<Address> spec, Sort by);

}
