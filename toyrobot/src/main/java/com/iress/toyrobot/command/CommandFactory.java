package com.iress.toyrobot.command;

/**
 * Interface for a factory supplying command instances
 */
public interface CommandFactory {

	/**
	 * Get an instance of the Command for the input ID and params
	 */
	public Command getInstance(String commandId, String commandParams) throws InvalidCommandException;
}
