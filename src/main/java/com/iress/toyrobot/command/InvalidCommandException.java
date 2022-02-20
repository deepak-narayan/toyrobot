package com.iress.toyrobot.command;

/**
 * Exception thrown when an invalid command is detected
 */
public class InvalidCommandException extends Exception {

	private static final long serialVersionUID = -3782676488611897451L;
	
	public InvalidCommandException(String msg) {
		super(msg);
	}
}
