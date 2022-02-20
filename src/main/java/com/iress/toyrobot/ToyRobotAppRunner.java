package com.iress.toyrobot;

import java.io.IOException;

/**
 * Toy Robot application entry point
 */
public class ToyRobotAppRunner {

	public static void main(String[] args) throws IOException {
		// Instantiate the console version of the Toy Robot App and run it.
		try(ConsoleToyRobotApp app = new ConsoleToyRobotApp(System.in, System.out, new ConsoleToyRobotAppDependencies())) {
			app.runApp();
		}
	}
}
