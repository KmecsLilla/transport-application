package hu.webuni.transport.lilla.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransportConfig {
	@Value("${transport.delayCost30}")
	private int delayCost30;

	@Value("${transport.delayCost60}")
	private int delayCost60;

	@Value("${transport.delayCost120}")
	private int delayCost120;

	public int getDelayCost30() {
		return delayCost30;
	}

	public int getDelayCost60() {
		return delayCost60;
	}

	public int getDelayCost120() {
		return delayCost120;
	}
}
