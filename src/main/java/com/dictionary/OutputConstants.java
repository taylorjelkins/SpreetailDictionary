package com.dictionary;

public final class OutputConstants {
	//Text that displays on application startup
	public static final String INTRO_TEXT = "Welcome to the Multi Value Dictionary, please enter a command (Enter HELP for a list of commands):";
	
	//
	public static final String KEYS_HELP 		 = "KEYS                        - Returns all the keys in the dictionary.";
	public static final String MEMBERS_HELP 	 = "MEMBERS      [key] [member] - Returns the collection of strings for the given key.";
	public static final String ADD_HELP 		 = "ADD          [key] [member] - Adds a member to a collection for a given key.";
	public static final String REMOVE_HELP 		 = "REMOVE 	     [key] [member] - Removes a member from a key.";
	public static final String REMOVEALL_HELP 	 = "REMOVEALL    [key]          - Removes all members for a key and removes the key from the dictionary.";
	public static final String CLEAR_HELP 		 = "CLEAR                       - Removes all keys and all members from the dictionary.";
	public static final String KEYEXISTS_HELP 	 = "KEYEXISTS    [key]          - Returns true or false whether a key exists or not.";
	public static final String MEMBEREXISTS_HELP = "MEMBEREXISTS [key] [member] - Returns whether a member exists within a key. Returns false if the key does not exist.";
	public static final String ALLMEMBERS_HELP 	 = "ALLMEMBERS                  - Returns all the members in the dictionary.";
	public static final String ITEMS_HELP 		 = "ITEMS                       - Returns all keys in the dictionary and all of their members.";
	
	//Error messages
	public static final String GENERIC_ERROR = "Error: not a valid command.";
	public static final String MISSING_KEY_ERROR = "Error: Given key does not exist.";
	public static final String ADD_MEMBER_ERROR = "Error: Given member already exists for given key.";
	public static final String REMOVE_MEMBER_ERROR = "Error: Given member does not exist for given key.";
	public static final String REMOVE_KEY_ERROR = "Error: Given key does not exist.";
	public static final String INCORRECT_ARGUMENTS_ERROR = "Error: Incorrect number of arguments given for this command.";
	
	//Success Messages
	public static final String CLEAR_MSG = "All dictionary entries have been cleared.";
	public static final String REMOVEALL_MSG = "Removed key and all associated members.";
	public static final String REMOVEMEMBER_KEY_MSG = "Removed member and purged the empty key.";
	public static final String REMOVEMEMBER_MEMBER_MSG = "Removed member from key.";
	public static final String ADD_MSG = "Added member to key.";
	public static final String EMPTY_KEYS_MSG = "No keys to display, the dictionary is empty.";
	public static final String EMPTY_MEMBERS_MSG = "No members to display, the dictionary is empty.";
}
