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
    public static String UPLOAD_FILE_PATH;
    
    @Value("#{resourceProperties['upload.file.path']}")
    public void setUPLOAD_FILE_PATH(String param) {
    	UPLOAD_FILE_PATH = param;
    }

}
