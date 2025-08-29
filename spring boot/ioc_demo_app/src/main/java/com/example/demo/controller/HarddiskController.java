
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.example.demo.entity.HardDisk;

@RestController
@RequestMapping("/computerapp")
public class HarddiskController {
	@Autowired
	private HardDisk hardDisk;
	
	@GetMapping("/harddisks")
	public HardDisk hardDisk() {
		return hardDisk;
	}

}
