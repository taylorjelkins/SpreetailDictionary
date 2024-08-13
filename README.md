# Back End Work Sample – Multi Value Dictionary

A work example for Spreetail for Taylor Elkins.

## Documentation
The Multi-Value Dictionary app is a command line application that stores a multivalue dictionary in memory. All keys and members are strings.
It should support the following commands:
> KEYS, MEMBERS, ADD, REMOVE, REMOVEALL, CLEAR, KEYEXISTS, MEMBEREXISTS, ALLMEMBERS, ITEMS

Added commands outside requirements include:
> HELP, EXIT, ITEMCOUNT

## Requirements
This application was built using Java, Gradle, and JUnit4
> Java Version:   22.0.2
> Gradle Version: 8.9
> JUnit4 Version: 4.13

## Building and Running
To build the application, in the top directory use the following command:
> gradlew clean build

This will also run through all the unit tests as part of the build process. (As of testing locally this build was functional with the above versions).
After the build is finished (it should only take a second or two) you can start the jar with the following command:
> java -jar build/libs/SpreetailDictionary.jar

If you see "Welcome to the Multi Value Dictionary, please enter a command (Enter HELP for a list of commands):" then the application is up and running.
