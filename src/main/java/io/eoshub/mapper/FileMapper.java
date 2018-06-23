package io.eoshub.mapper;

import org.springframework.stereotype.Repository;

import io.eoshub.model.File;

@Repository
public interface FileMapper {

	int insertFile(File file);

}
