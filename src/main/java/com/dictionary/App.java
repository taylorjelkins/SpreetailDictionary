package com.dictionary;

import java.util.Scanner;
import java.util.Set;

public class App {
	
	private static final String SPLIT_VALUE_FOR_COMMANDS = " ";
	private static int RESET_COUNT = 1;
	private static int NO_ARGUMENTS = 0;
	private static int ONE_ARGUMENT = 1;
	private static int TWO_ARGUMENTS = 2;
	
	public static void main(String[] args) {
		
		System.out.println(OutputConstants.INTRO_TEXT);
		checkInputValue();
		
	}
	
	private static boolean checkCorrectNumberOfArguments(String[] input, int expectedAmount) {
		//Compare against the expectedAmount plus 1 because the initial command needs to be accounted for
		if (input.length == (expectedAmount+1)) {
			return true;
		}
		else {
			System.out.println(OutputConstants.INCORRECT_ARGUMENTS_ERROR);
			return false;
		}
	}
	
	private static void checkInputValue() {
		Dictionary dictionary = new Dictionary();
		
		Scanner inputScanner = new Scanner(System.in);
		
		while(true) {
			String[] input = inputScanner.nextLine().split(SPLIT_VALUE_FOR_COMMANDS);
			Commands command = Commands.DEFAULT;
			
			//Incase something other than an expected command is given.
			try {
				command = Commands.valueOf(input[0].toUpperCase());
			} catch (IllegalArgumentException e) {}
			
			int count = RESET_COUNT;
			
				switch(command) {
					case KEYS:  //test
						if (checkCorrectNumberOfArguments(input, NO_ARGUMENTS)) {
							Set<String> keys = dictionary.getAllKeys();
							if (keys.isEmpty()) {
								System.out.println(OutputConstants.EMPTY_KEYS_MSG);
							}
							else {
								for (String key : keys) {
									System.out.println(count + ") " + key);
									count++;
								}
							}
						}
						break;
					case MEMBERS:  //complete
						if (checkCorrectNumberOfArguments(input, ONE_ARGUMENT)) {
							if(dictionary.checkIfKeyExists(input[1])) {
								Set<String> members = dictionary.getMembersForKey(input[1]);
								for (String member : members) {
									System.out.println(count + ") " + member);
									count++;
								}
							}
							else {
								System.out.println(OutputConstants.MISSING_KEY_ERROR);
							}
						}
						break;
					case ADD:  //test
						if (checkCorrectNumberOfArguments(input, TWO_ARGUMENTS)) {
							dictionary.addDictionaryEntry(input[1], input[2]);
						}
						break;
					case REMOVE:  //test
						if (checkCorrectNumberOfArguments(input, TWO_ARGUMENTS)) {
							dictionary.removeMember(input[1], input[2]);
						}
						break;
					case REMOVEALL: //test
						if (checkCorrectNumberOfArguments(input, ONE_ARGUMENT)) {
							dictionary.removeKey(input[1]);
						}
						break;
					case CLEAR:  //complete
						if (checkCorrectNumberOfArguments(input, NO_ARGUMENTS)) {
							dictionary.clear();
						}
						break;
					case KEYEXISTS:  //complete
						if (checkCorrectNumberOfArguments(input, ONE_ARGUMENT)) {
							System.out.println(dictionary.checkIfKeyExists(input[1]));
						}
						break;
					case MEMBEREXISTS: //test
						if (checkCorrectNumberOfArguments(input, TWO_ARGUMENTS)) {
							System.out.println(dictionary.checkIfMemberExists(input[1], input[2]));
						}
						break;
					case ALLMEMBERS: //test
						if (checkCorrectNumberOfArguments(input, NO_ARGUMENTS)) {
							Set<String> keys = dictionary.getAllKeys();
							if (keys.isEmpty()) {
								System.out.println(OutputConstants.EMPTY_MEMBERS_MSG);
							}
							else {
								for (String key : keys) {
									for (String member : dictionary.getMembersForKey(key)) {
										System.out.println(count + ") " + member);
										count++;
									}
								}
							}
						}
						break;
					case ITEMS: //test
						if (checkCorrectNumberOfArguments(input, NO_ARGUMENTS)) {
							if (checkCorrectNumberOfArguments(input, NO_ARGUMENTS)) {
								Set<String> keys = dictionary.getAllKeys();
								if (keys.isEmpty()) {
									System.out.println(OutputConstants.EMPTY_KEYS_MSG);
								}
								else {
									for (String key : keys) {
										for (String member : dictionary.getMembersForKey(key)) {
											System.out.println(count + ") " + key + ": " + member);
											count++;
										}
									}
								}
							}
						}
						break;
					case HELP: //test
						System.out.println(OutputConstants.KEYS_HELP);
						System.out.println(OutputConstants.MEMBERS_HELP);
						System.out.println(OutputConstants.ADD_HELP);
						System.out.println(OutputConstants.REMOVE_HELP);
						System.out.println(OutputConstants.REMOVEALL_HELP);
						System.out.println(OutputConstants.CLEAR_HELP);
						System.out.println(OutputConstants.KEYEXISTS_HELP);
						System.out.println(OutputConstants.MEMBEREXISTS_HELP);
						System.out.println(OutputConstants.ALLMEMBERS_HELP);
						System.out.println(OutputConstants.ITEMS_HELP);
						break;
					case EXIT: //test
						//Need to close the input scanner and the exit the application.
						if (checkCorrectNumberOfArguments(input, NO_ARGUMENTS)) {
							inputScanner.close();
							System.exit(NO_ARGUMENTS);
						}
						break;
					default:
						System.out.println(OutputConstants.GENERIC_ERROR);
				}
		}
		
	}
	
}
