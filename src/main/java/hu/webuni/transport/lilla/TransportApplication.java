package hu.webuni.transport.lilla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.webuni.transport.lilla.service.AddressService;

@SpringBootApplication
public class TransportApplication {

	@Autowired
	AddressService addressService;

	public static void main(String[] args) {
		SpringApplication.run(TransportApplication.class, args);
	}

}
