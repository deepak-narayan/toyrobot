package com.iress.toyrobot.command;

/**
 * An implementation of the CommandParser interface for console I/O
 */
public class ConsoleCommandParser implements CommandParser {

	private CommandFactory commandFactory;
	
	public ConsoleCommandParser() {
		this(null);
	}
	
	public ConsoleCommandParser(CommandFactory commandFactory) {
		if (commandFactory == null) {
			this.commandFactory = new CommandFactoryImpl(); //default
		} else {
			this.commandFactory = commandFactory;
		}
	}
	
	@Override
	public Command parseCommand(String commandStrParam) {

		Command result = null;

		// Assume example command PLACE 2,3,NORTH
		if (commandStrParam != null) {
			String commandStr = commandStrParam.trim();

			if (commandStr.length() > 0) {
				// Need the Command identifier, PLACE.
				int firstSpace = commandStr.indexOf(' ');
				
				String commandId = null;
				String commandParams = null;
				
				if (firstSpace > -1) {
					commandId = commandStr.substring(0, firstSpace);
					commandParams = commandStr.substring(firstSpace + 1, commandStr.length());
				} else {
					// No parameters
					commandId = commandStr;
				}
				
				try {
					result = commandFactory.getInstance(commandId, commandParams);
				} catch (InvalidCommandException e) {
					// Invalid command, probably because the parameters were not valid.
					result = null;
				}
			}
		}

		return result;
	}
}
