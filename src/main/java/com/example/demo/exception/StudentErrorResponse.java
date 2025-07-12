package com.example.demo.exception;

public class StudentErrorResponse {
	
	private int Status;
	private String message;
	private long timestamp;
	
	public StudentErrorResponse() {}
	
	public StudentErrorResponse(int Status, String message, long timestamp) {
		super();
		this.Status = Status;
		this.message = message;
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
