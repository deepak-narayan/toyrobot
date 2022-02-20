Welcome to the console-based Toy Robot App!

Prerequisites
-------------
Java 8 or higher - Ensure JAVA_HOME is set up correctly.
Maven for building the project - ensure the maven bin directory is on your PATH.

Building
--------
After pulling the project, navigate to the root of the codebase and run the following command to build it:
> mvn clean install
  
This will compile the code, run tests and build an executable jar  target/toyrobot-0.0.1-SNAPSHOT.jar.
The tests include an integration test ConsoleToyRobotAppIntegrationTest

Running
-------
Run the following command to use the App:
> java -jar target/toyrobot-0.0.1-SNAPSHOT.jar

This creates a 5x5 Universe and the Robot. At this point the console is ready for user input.

Usage
-----
The following commands are valid (case-insensitive):

PLACE x,y,direction  eg. PLACE 2,3,NORTH. Direction may be NORTH, WEST, EAST, SOUTH.
MOVE - moves the robot one step
LEFT - turns the robot left
RIGHT - turns the robot right
REPORT - prints the current position and direction of the robot
EXIT - destroys the robot and the universe (end the app)

Invalid commands are ignored and the robot will stay where it is in the same direction.