package com.dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dictionary {
	
	//Putting members in a Set since they do not allow duplicates and are not ordered
	private Map<String, Set<String>> dictionaryMap;
	
	public Dictionary() {
		setDictionaryMap(new HashMap<String, Set<String>>());
	}

	//Getter method for the Dictionary
	public Map<String, Set<String>> getDictionaryMap() {
		return dictionaryMap;
	}

	//Setter method for the Dictionary
	public void setDictionaryMap(Map<String, Set<String>> dictionaryMap) {
		this.dictionaryMap = dictionaryMap;
	}
	
	//Getter for keys in the Dictionary
	public Set<String> getAllKeys(){
		return dictionaryMap.keySet();
	}
	
	//Getter for members under a given key in the Dictionary
	public Set<String> getMembersForKey(String key){
		Set<String> resultSet = new HashSet<String>();
		resultSet = dictionaryMap.get(key);
		return resultSet;
	}
	
	public boolean checkIfKeyExists(String key) {
		return dictionaryMap.containsKey(key);
	}
	
	public boolean checkIfMemberExists(String key, String member) {
		boolean checkValue = false;
		if (dictionaryMap.containsKey(key)) {
			Set<String> entryForKey = dictionaryMap.get(key);
			if (entryForKey.contains(member)) {
				checkValue = true;
			}
		}
		return checkValue;
	}
	
	//Checks if the key exists, if it does then adds the member to the dictionary under the key,
	//if not then create the key and add the member to it.
	public void addDictionaryEntry(String key, String member) {
		if (checkIfKeyExists(key)) {
			addMemberToEntry(key, member);
		}
		else {
			Set<String> memberSet = new HashSet<>();
			memberSet.add(member);
			dictionaryMap.put(key, memberSet);
			System.out.println(OutputConstants.ADD_MSG);
		}
	}
	
	//Adds a member value to an existing key.
	//Throws an error if the member already exists for that key.
	//In theory this isn't needed due to using a Set but the error is a requirement.
	private void addMemberToEntry(String key, String member) {
		if (!checkIfMemberExists(key, member)) {
			Set<String> existingEntries = dictionaryMap.get(key);
			existingEntries.add(member);
			dictionaryMap.replace(key, existingEntries);
			System.out.println(OutputConstants.ADD_MSG);
		} 
		else {
			System.out.println(OutputConstants.ADD_MEMBER_ERROR);
		}
	}
	
	public void removeMember(String key, String member) {
		if(checkIfKeyExists(key)) {
			if(checkIfMemberExists(key, member)) {
				Set<String> existingEntries = dictionaryMap.get(key);
				if (existingEntries.size() == 1) {
					dictionaryMap.remove(key);
					System.out.println(OutputConstants.REMOVEMEMBER_KEY_MSG);
				}
				else {
					existingEntries.remove(member);
					dictionaryMap.replace(key, existingEntries);
					System.out.println(OutputConstants.REMOVEMEMBER_MEMBER_MSG);
				}
			}
			else {
				System.out.println(OutputConstants.REMOVE_MEMBER_ERROR);
			}
		}
		else {
			System.out.println(OutputConstants.REMOVE_KEY_ERROR);
		}
	}
	
	public void removeKey(String key) {
		if(checkIfKeyExists(key)) {
			dictionaryMap.remove(key);
			System.out.println(OutputConstants.REMOVEALL_MSG);
		}
		else {
			System.out.println(OutputConstants.REMOVE_KEY_ERROR);
		}
	}
	
	public void clear() {
		dictionaryMap.clear();
		System.out.println(OutputConstants.CLEAR_MSG);
	}

}
