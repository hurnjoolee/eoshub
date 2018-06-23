package io.eoshub.common;

import java.io.Serializable;
import java.util.List;

public class CommonResponseModel<T> implements Serializable {

	private static final long serialVersionUID = -923503520188291833L;

	/**
     * 결과 코드
     */
    private int resultCode;

    /**
     * 결과 메시지
     */
    private String message;

    /**
     * 데이터의 전체 갯수 (페이징을 위한 전체 갯수)
     */
    private long totalCount;

    /**
     * 데이터
     */
    private List<T> rows;

    /**
     * @return the resultCode
     */
    public int getResultCode() {
        return resultCode;
    }

    /**
     * @param resultCode the resultCode to set
     */
    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the totalCount
     */
    public long getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount the totalCount to set
     */
    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * @return the rows
     */
    public List<T> getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(List<T> rows) {
        this.rows = rows;
    }

}
