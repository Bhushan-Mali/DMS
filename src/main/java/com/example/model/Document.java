package com.example.model;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dms_document")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long docId;
	private String documentName;
	private String fileName;
	private String createdDate;
	private String createdBy;
	private String docType;			//jpg, jpeg, pdf	(MIME Type | you can get type by using getContentType() method of File Class)
	private String version;
	private String lastModified;
	private String lastModifiedby;
	private Long fileSize;
	private File file;
	
	
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public Long getDocId() {
		return docId;
	}
	public void setDocId(Long docId) {
		this.docId = docId;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	
	public String getLastModifiedby() {
		return lastModifiedby;
	}
	public void setLastModifiedby(String lastModifiedby) {
		this.lastModifiedby = lastModifiedby;
	}
	
	public Document(Long docId, String documentName, String fileName, String createdDate, String createdBy,
			String docType, String version, String lastModified, String lastModifiedby, Long fileSize,
			File file) {
		super();
		this.docId = docId;
		this.documentName = documentName;
		this.fileName = fileName;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.docType = docType;
		this.version = version;
		this.lastModified = lastModified;
		this.lastModifiedby = lastModifiedby;
		this.fileSize = fileSize;
		this.file = file;
	}
	
	public Document() {}
	
}
