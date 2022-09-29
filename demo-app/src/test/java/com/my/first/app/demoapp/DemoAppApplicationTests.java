package com.my.first.app.demoapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.my.first.app.demoapp.services.BookRoomAppServices;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DemoAppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testGenerateIdLogic() {
		BookRoomAppServices services = new BookRoomAppServices();
		String id = services.generateId("#123456", 32);
		assertEquals(id, "12345632");
		String id2 = services.generateId("Er45678", 32);
		assertEquals(id2, "Er4567832");
	}

}
