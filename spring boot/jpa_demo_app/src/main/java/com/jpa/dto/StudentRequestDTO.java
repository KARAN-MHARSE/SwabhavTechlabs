package com.jpa.dto;

import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@RequiredArgsConstructor

public class StudentRequestDTO {
	private int rollNumber;
	private String name;
	private String email;
	private int age;
	private String password;
}
