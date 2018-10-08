package com.ssmelnikov.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class LogopedApplication extends SpringBootServletInitializer {
	private static final Logger logger = LoggerFactory.getLogger(LogopedApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        try {
            return application.sources(LogopedApplication.class);
        } catch (Exception e) {
            logger.error("", e);
        }
        return null;
    }

	public static void main(String[] args) {
        try {
            SpringApplication.run(LogopedApplication.class, args);
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
