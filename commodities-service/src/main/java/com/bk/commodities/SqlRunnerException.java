package com.bk.commodities;

public class SqlRunnerException extends RuntimeException {
	private static final long serialVersionUID = 4937867109159339407L;

	public SqlRunnerException() {
		super();
	}

	public SqlRunnerException(String message, Throwable cause) {
		super(message, cause);
	}

	public SqlRunnerException(String message) {
		super(message);
	}

	public SqlRunnerException(Throwable cause) {
		super(cause);
	}

}
