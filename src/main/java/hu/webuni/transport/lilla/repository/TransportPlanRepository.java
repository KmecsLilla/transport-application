package hu.webuni.transport.lilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import hu.webuni.transport.lilla.model.TransportPlan;

public interface TransportPlanRepository extends JpaRepository<TransportPlan, Long> , JpaSpecificationExecutor<TransportPlan> {

}
