package com.iress.toyrobot.command;

/**
 * An interface for parsing Strings into {@link Command}s
 */
public interface CommandParser {

	/**
	 * Convert the input String into a Command.
	 * @param commandStr - String containing the command identifier and optional comma separated parameters
	 * @return The parsed command or null if it could not be resolved.
	 */
	public Command parseCommand(String commandStr); 
	
}
