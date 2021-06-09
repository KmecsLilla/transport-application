package hu.webuni.transport.lilla.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.webuni.transport.lilla.dto.DelayDto;
import hu.webuni.transport.lilla.service.DelayService;

@RestController
@RequestMapping("/api/tranportPlans")
public class TransportPlanController {
	@Autowired
	DelayService delayService;

	@PostMapping("/{id}/delay")
	public void registerDelay(@PathVariable int id, @RequestBody DelayDto delay) {
		delayService.registerDelay(id, delay.getMilestoneId(), delay.getDelay());
	}

}
