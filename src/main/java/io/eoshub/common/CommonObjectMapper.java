package io.eoshub.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CommonObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = -7527276797368937522L;

	public CommonObjectMapper() {
        // json response의 value 값이 null 이면 내려보내지 않게 설정
        setSerializationInclusion(JsonInclude.Include.NON_NULL);

        //
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // df.setTimeZone(TimeZone.getTimeZone("KST"));
        setDateFormat(df);
    }

}
