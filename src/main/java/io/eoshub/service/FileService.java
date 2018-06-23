package io.eoshub.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import io.eoshub.common.Constants;
import io.eoshub.mapper.FileMapper;
import io.eoshub.model.File;
import io.eoshub.type.FileCategoryType;

@Transactional
@Service
public class FileService {

	@Autowired
	private FileMapper fileMapper;

	public File insertFile(MultipartFile file, FileCategoryType type) {
		if (file == null) {
			return null;
		}

		File f = new File();
		f.setSize(file.getSize());
		f.setName(file.getOriginalFilename());
		f.setContentType(file.getContentType());
		f.setCategoryType(type);
		fileMapper.insertFile(f);

		try {
			file.transferTo(new java.io.File(getFilePath(type, f.getId())));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException("file save fail.");
		}

		return f;
	}

	public String getFilePath(FileCategoryType type, Integer fileId) {
		String path = null;
		switch (type) {
		case AD_AIRDROP:
			path = Constants.UPLOAD_FILE_PATH_ADAIRDROP + java.io.File.separator + fileId;
		case AD_ICO:
			path = Constants.UPLOAD_FILE_PATH_ADICO + java.io.File.separator + fileId;
			break;
		}
		return path;
	}

}
