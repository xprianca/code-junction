package com.tiwari.priyanka.codejunction;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class CodeJunctionApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("test");

	}

	@Test
	void threadPoolTest(){
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		executorService.execute(() -> System.out.printf("Thread name %s executing!!!!%n", Thread.currentThread().getName()));
	}

}
