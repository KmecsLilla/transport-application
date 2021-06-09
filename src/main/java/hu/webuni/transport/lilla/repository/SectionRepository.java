package hu.webuni.transport.lilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import hu.webuni.transport.lilla.model.Section;

public interface SectionRepository extends JpaRepository<Section, Long> , JpaSpecificationExecutor<Section> {

}
