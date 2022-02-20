package com.iress.toyrobot.command;

public class CommandFactoryImpl implements CommandFactory {

	/**
	 * Get an instance of the Command for the input ID and params
	 */
	public Command getInstance(String commandId, String commandParams) throws InvalidCommandException {
		if (commandId == null) {
			return null;
		}
		
		switch (commandId) {
		case "PLACE":
			return new PlaceCommand(commandParams);
		case "MOVE":
			return new MoveCommand();
		case "LEFT":
			return new LeftCommand();
		case "RIGHT":
			return new RightCommand();
		case "REPORT":
			return new ReportCommand();
		case "EXIT":
			return new ExitCommand();
		default:
			return null;
		}
	}
}
