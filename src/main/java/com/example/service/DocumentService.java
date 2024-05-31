package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Document;
import com.example.repository.DocumentRepository;

@Service
public class DocumentService {

	@Autowired
	DocumentRepository documentRepository;
	
	public Document addDocument(Document document) {
		documentRepository.save(document);		
		return document;
	}
}
