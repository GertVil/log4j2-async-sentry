package com.sentry.logging.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		initLogging();
		SpringApplication.run(TestApplication.class, args);
	}

	private static void initLogging() {
		//https://logging.apache.org/log4j/2.x/log4j-jul/index.html
		System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");
		//https://logging.apache.org/log4j/2.x/manual/async.html
		System.setProperty("log4j2.contextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
	}
}
