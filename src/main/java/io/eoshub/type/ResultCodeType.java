package io.eoshub.type;

public enum ResultCodeType {
    SUCCESS(0, "성공했습니다."),

    COMMON_UNKNOWN(1000, "알 수 없는 에러가 발생했습니다."),

    COMMON_NO_DATA_MATCHED(1001, "요청하신 데이터를 찾을 수 없습니다."),

    COMMON_INVALID_PARAM(1002, "잘못된 요청입니다. 함께 요청한 파라미터를 확인하세요."),

    INTERNAL_SERVER_ERROR(1003, "서버 에러 입니다."),

    NOT_IMPLEMENTED_EXCEPTION(1004, "구현 하지 않았습니다."),

    AUTHENTICATION_UNKNOWN(2000, "인증 관련 알 수 없는 에러가 발생했습니다."),

    AUTHENTICATION_ID_INCORRECT(2001, "아이디가 잘못되었습니다."),

    AUTHENTICATION_INVALID_TOKEN(2002, "토큰값이 유효하지 않습니다."),

    AUTHENTICATION_TOKEN_EXPIRED(2003, "토큰이 만료되었습니다."),

    AUTHENTICATION_INVALID_PERMISSION(2004, "사용 권한이 없습니다."),

    AUTHENTICATION_ETC(2005, "인증 관련 기타 에러가 발생했습니다."),

    AUTHENTICATION_PWD_INCORRECT(2006, "패스워드가 잘못되었습니다."),

    AUTHENTICATION_INVALID_ACCESS_STATUS(2007, "로그인을 할 수 없는 상태 입니다.");

    private int code;
    private String message;

    private ResultCodeType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

}
