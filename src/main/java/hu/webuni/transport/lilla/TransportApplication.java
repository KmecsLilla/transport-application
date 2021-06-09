package hu.webuni.transport.lilla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.webuni.transport.lilla.service.InitDbService;

@SpringBootApplication
public class TransportApplication implements CommandLineRunner {

	@Autowired
	InitDbService initDbService;

	public static void main(String[] args) {
		SpringApplication.run(TransportApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initDbService.initDb();
	}

}
