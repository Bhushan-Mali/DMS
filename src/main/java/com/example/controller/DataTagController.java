package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CommonResponseVO;
import com.example.model.DataTag;
import com.example.service.DataTagService;

@RestController
public class DataTagController {

	@Autowired
	DataTagService datatagservice;
	
	
	@PostMapping("/addDataTag")
	public ResponseEntity<CommonResponseVO> addDataTag(@RequestBody DataTag datatag) {
		CommonResponseVO response = datatagservice.addDatatag(datatag);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllDatatags")
	public List<DataTag> getAllDatatags() {
		return datatagservice.getAllDatatags();
	}
}
