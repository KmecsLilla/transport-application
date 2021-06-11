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
@RequestMapping("/api/transportplans")
public class TransportPlanController {
	@Autowired
	DelayService delayService;

	@PostMapping("/{id}/delay")
	public int registerDelay(@PathVariable long id, @RequestBody DelayDto delayDto) {
		return delayService.registerDelay(id, delayDto.getMilestoneId(), delayDto.getDelay());
	}

}
