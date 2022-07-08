package com.org.brm.data;

import java.util.Date;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class APIResponse {
	private Date timestamp;
	private String details;
	private Integer status;
	private Map<String, Object> response;
	private String error;
	private String info;

	/**
	 * @param timestamp
	 * @param details
	 * @param status
	 * @param response
	 */
	public APIResponse(Date timestamp, String details, Integer status, Map<String, Object> response) {
		super();
		this.timestamp = timestamp;
		this.details = details;
		this.status = status;
		this.response = response;
	}

	public APIResponse(Date timestamp, String details, Integer status, String error,String info) {
		super();
		this.timestamp = timestamp;
		this.details = details;
		this.status = status;
		this.error = error;
		this.info = info;
	}

	/**
	 * @param timestamp
	 * @param details
	 * @param status
	 * @param error
	 */
	public APIResponse(Date timestamp, String details, Integer status, String error) {
		super();
		this.timestamp = timestamp;
		this.details = details;
		this.status = status;
		this.error = error;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Map<String, Object> getResponse() {
		return response;
	}

	public void setResponse(Map<String, Object> response) {
		this.response = response;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
}
