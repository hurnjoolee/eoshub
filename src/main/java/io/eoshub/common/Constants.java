package io.eoshub.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constants {

	// api version
	public static final String API = "/api";

	// search criteria
	public static final int DEF_PAGE_NUMBER = 1;
	public static final int DEF_PAGE_ROW_LIMIT = 20;

	// resource constants
	public static String SERVER_URL;
	public static String UPLOAD_FILE_PATH;
	public static String UPLOAD_FILE_PATH_ADAIRDROP;
	public static String UPLOAD_FILE_PATH_ADICO;

	@Value("#{resourceProperties['server.url']}")
	public void setSERVER_URL(String param) {
		SERVER_URL = param;
	}

	@Value("#{resourceProperties['upload.file.path']}")
	public void setUPLOAD_FILE_PATH(String param) {
		UPLOAD_FILE_PATH = param;
	}

	@Value("#{resourceProperties['upload.file.path.adairdrop']}")
	public void setUPLOAD_FILE_PATH_ADAIRDROP(String param) {
		UPLOAD_FILE_PATH_ADAIRDROP = param;
	}

	@Value("#{resourceProperties['upload.file.path.adico']}")
	public void setUPLOAD_FILE_PATH_ADICO(String param) {
		UPLOAD_FILE_PATH_ADICO = param;
	}

}
