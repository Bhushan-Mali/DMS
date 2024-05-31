package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CommonResponseVO;
import com.example.model.DataTag;
import com.example.repository.DataTagRepository;

@Service
public class DataTagService {

	@Autowired
	DataTagRepository datatagrepository;
	
	public CommonResponseVO addDatatag(DataTag datatag) {
		datatagrepository.save(datatag);	
		CommonResponseVO response = new CommonResponseVO();
        response.setMessage("DataTag added successfully");
        return response;
	}

	public List<DataTag> getAllDatatags() {
		return datatagrepository.findAll();
	}

}
