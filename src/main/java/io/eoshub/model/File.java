package io.eoshub.model;

import org.springframework.web.multipart.MultipartFile;

import io.eoshub.type.FileCategoryType;

public class File {

	private Integer id;
	private String name;
	private String contentType;
	private Long size;
	private FileCategoryType categoryType;
	private String downloadUrl;

	private MultipartFile uploadFile;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public FileCategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(FileCategoryType categoryType) {
		this.categoryType = categoryType;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

}
