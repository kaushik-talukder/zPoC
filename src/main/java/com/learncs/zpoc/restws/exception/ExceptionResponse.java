package com.learncs.zpoc.restws.exception;

import java.util.Date;

import lombok.Data;

@Data
public class ExceptionResponse {
	private Date timeStamp;
	private String message;
	private String description;
	
	public ExceptionResponse(Date timeStamp, String message, String description) {
		this.timeStamp = timeStamp;
		this.message = message;
		this.description = description;
	}
	
}
