package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.Document;
import com.example.service.DocumentService;

@RestController
public class DocumentController {

	
	@Autowired
	DocumentService documentService;
	
	@PostMapping("/addDocument")
	public ResponseEntity<?> addDocument(@RequestPart Document document, @RequestPart MultipartFile file) {
		
		if(file.isEmpty()) {
			return new ResponseEntity<String>("Please select file", HttpStatus.BAD_REQUEST);
		}
		
		document.setFileName(file.getOriginalFilename());
		document.setDocumentName(document.getDocumentName());
		document.setFileSize(file.getSize());		
		document.setFileName(file.getOriginalFilename());
		document.setDocType(file.getContentType());
		document.setFileSize(file.getSize());		
		document.setCreatedBy(document.getCreatedBy());
		document.setCreatedDate(document.getCreatedDate());
		document.setLastModified(document.getLastModified());
		document.setLastModifiedby(document.getLastModifiedby());
		document.setVersion(document.getVersion());
		documentService.addDocument(document);
		
//		file.getOriginalFilename();
//		file.getName();
//		file.getSize();
		
//		System.out.println("Original filename is "+file.getOriginalFilename());
		
		return new ResponseEntity<String>("File uploaded successfully", HttpStatus.OK);
	}
}
