package com.akos.library;

import com.akos.library.server.DatabaseConfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@EnableAutoConfiguration
//@Import(DatabaseConfiguration.class)
@ComponentScan("com.akos.library")
public class ServerApplication {

	private final static Logger log = LoggerFactory.getLogger(ServerApplication.class);

	@Autowired
	Environment env;

	/**
	 * entry point
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}
