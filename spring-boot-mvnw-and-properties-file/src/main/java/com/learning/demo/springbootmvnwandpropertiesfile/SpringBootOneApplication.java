package com.learning.demo.springbootmvnwandpropertiesfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(
//		scanBasePackages={"com.learning.demo.springbootone"} // can have more than one package
//)
@SpringBootApplication
public class SpringBootOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOneApplication.class, args);
	}

}
