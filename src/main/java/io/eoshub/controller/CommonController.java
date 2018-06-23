package io.eoshub.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.eoshub.common.CommonResponseModel;
import io.eoshub.type.ResultCodeType;

public abstract class CommonController {

	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

	/**
	 * 공통 response 모델 생성 함수
	 *
	 * @param resultCodeType
	 *            결과 코드
	 * @param data
	 *            결과 데이터
	 * @return 생성된 response 모델
	 */
	protected <T> CommonResponseModel<T> response(ResultCodeType resultCodeType, T data) {
		CommonResponseModel<T> response = new CommonResponseModel<T>();
		List<T> rows = new ArrayList<T>();
		if (data != null) {
			rows.add(data);
			response.setRows(rows);
			response.setTotalCount(1);
			response.setResultCode(resultCodeType.getCode());
			response.setMessage(resultCodeType.getMessage());
		} else if (ResultCodeType.SUCCESS == resultCodeType) {
			resultCodeType = ResultCodeType.COMMON_NO_DATA_MATCHED;
			response.setRows(rows);
			response.setTotalCount(0);
			response.setResultCode(resultCodeType.getCode());
			response.setMessage(resultCodeType.getMessage());
		} else {
			response.setRows(rows);
			response.setTotalCount(0);
			response.setResultCode(resultCodeType.getCode());
			response.setMessage(resultCodeType.getMessage());
		}

		return response;
	}

	/**
	 * 공통 응답 response 모델 생성 함수
	 *
	 * @param resultCodeType
	 *            결과 코드
	 * @param rows
	 *            결과 데이터 목록
	 * @param totalCount
	 *            data 전체 count (페이징을 위한 DB의 전체 수)
	 * @return 생성된 response 모델
	 */
	protected <T> CommonResponseModel<T> response(ResultCodeType resultCodeType, List<T> rows, long totalCount) {
		CommonResponseModel<T> response = new CommonResponseModel<T>();
		response.setRows(rows);
		response.setTotalCount(totalCount);
		response.setResultCode(resultCodeType.getCode());
		response.setMessage(resultCodeType.getMessage());
		return response;
	}

	/**
	 * Exception 핸들러
	 *
	 * @param exception
	 *            서버에서 핸들링하지 않은 Exception
	 * @return Exception 에 대한 response 모델
	 */
	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody CommonResponseModel<Object> handleException(Exception exception) {
		return makeResponseException(exception, ResultCodeType.COMMON_UNKNOWN);
	}

	/**
	 * IllegalArgumentException 핸들러
	 *
	 * @param exception
	 *            IllegalArgumentException
	 * @return Exception 에 대한 response 모델
	 */
	@ExceptionHandler(value = { IllegalArgumentException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody CommonResponseModel<Object> handleException(IllegalArgumentException exception) {
		return makeResponseException(exception, ResultCodeType.COMMON_INVALID_PARAM);
	}

	/**
	 * NotImplementedException 핸들러
	 *
	 * @param exception
	 *            NotImplementedException
	 * @return Exception 에 대한 response 모델
	 */
	@ExceptionHandler(value = { NotImplementedException.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody CommonResponseModel<Object> handleException(NotImplementedException exception) {
		return makeResponseException(exception, ResultCodeType.NOT_IMPLEMENTED_EXCEPTION);
	}

	/**
	 * RuntimeException 핸들러
	 *
	 * @param exception
	 *            RuntimeException
	 * @return Exception 에 대한 response 모델
	 */
	@ExceptionHandler(value = { RuntimeException.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody CommonResponseModel<Object> handleException(RuntimeException exception) {
		return makeResponseException(exception, ResultCodeType.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Exception 결과 모델 생성 함수
	 *
	 * @param exception
	 * @param resultCodeType
	 *            결과 코드
	 * @return Exception 에 대한 response 모델
	 */
	private @ResponseBody CommonResponseModel<Object> makeResponseException(Exception exception,
			ResultCodeType resultCodeType) {
		logger.error(exception.getMessage());

		CommonResponseModel<Object> response = new CommonResponseModel<Object>();
		response.setResultCode(resultCodeType.getCode());
		response.setMessage(exception.getMessage());
		return response;
	}

}
