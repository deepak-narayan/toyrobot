package com.iress.toyrobot.environment;

/**
 * Exception thown if there is a placement error
 */
public class PlacementException extends Exception {

	private static final long serialVersionUID = 5103638433761995264L;
	
	public PlacementException(String msg) {
		super(msg);
	}

}
