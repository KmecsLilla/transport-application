package hu.webuni.transport.lilla;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import hu.webuni.transport.lilla.dto.DelayDto;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class TransportApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Test
	void testDelay() {
		webTestClient
			.post()
			.uri("/api/transportplans/1/delay")
			.bodyValue(new DelayDto(8, 70))
			.exchange()
			.expectStatus()
			.isOk()
			.expectBody(Integer.class)
			.isEqualTo(35);
	}

}
