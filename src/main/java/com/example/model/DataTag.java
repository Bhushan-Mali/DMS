package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DataTag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer datatag_id;
	private String datatag_name;
	private String description;
	
	public DataTag() {}
	
	public DataTag(Integer datatag_id, String datatag_name, String description) {
		super();
		this.datatag_id = datatag_id;
		this.datatag_name = datatag_name;
		this.description = description;
	}

	public Integer getDatatag_id() {
		return datatag_id;
	}

	public void setDatatag_id(Integer datatag_id) {
		this.datatag_id = datatag_id;
	}

	public String getDatatag_name() {
		return datatag_name;
	}

	public void setDatatag_name(String datatag_name) {
		this.datatag_name = datatag_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
