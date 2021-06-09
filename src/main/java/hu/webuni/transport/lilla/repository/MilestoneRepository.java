package hu.webuni.transport.lilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import hu.webuni.transport.lilla.model.Milestone;

public interface MilestoneRepository extends JpaRepository<Milestone, Long> , JpaSpecificationExecutor<Milestone> {

}
