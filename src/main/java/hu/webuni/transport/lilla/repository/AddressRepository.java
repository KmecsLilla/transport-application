package hu.webuni.transport.lilla.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import hu.webuni.transport.lilla.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>, JpaSpecificationExecutor<Address> {

	@Override
	List<Address> findAll(Specification<Address> spec, Sort by);
	@Override
	Page<Address> findAll(Specification<Address> spec, Pageable pageable);

}
