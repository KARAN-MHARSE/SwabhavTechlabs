package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Computer;
import com.example.demo.entity.HardDisk;

@Configuration
public class AppConfig {
	@Bean
	HardDisk hardDisk() {
		return new HardDisk();
	}
	@Bean
	Computer computer() {
		return new Computer();
	}

}
