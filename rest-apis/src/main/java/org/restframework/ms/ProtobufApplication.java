package org.restframework.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.restframework.ms")
public class ProtobufApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProtobufApplication.class, args);
	}
}
