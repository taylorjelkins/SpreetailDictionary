package com.dictionary;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class DictionaryTest {
	
	private Dictionary dictionary = new Dictionary();
	
	@Before
	public void setUp() {
		dictionary = new Dictionary();
		dictionary.setDictionaryMap(createMockDictionary());
	}
	
	@Test
	public void testHasKeys() {
		assertFalse(dictionary.getAllKeys().isEmpty());
	}
	
	@Test 
	public void testClear() {
		dictionary.clear();
		assertTrue(dictionary.getAllKeys().isEmpty());
	}
	
	@Test 
	public void testGetMembersWithKey() {
		Set<String> memberCheck = new HashSet<String>();
		memberCheck.add("bar");
		memberCheck.add("baz");
		
		assertTrue(!dictionary.getMembersForKey("foo").isEmpty());
		assertTrue(dictionary.getMembersForKey("foo").equals(memberCheck));
	}
	
	@Test 
	public void testAdd() {
		Set<String> memberCheck = new HashSet<String>();
		memberCheck.add("lorem");
		
		dictionary.addDictionaryEntry("ipsum", "lorem");
		assertTrue(dictionary.getAllKeys().contains("ipsum"));
		assertTrue(dictionary.getMembersForKey("ipsum").equals(memberCheck));
		int numOfKeys = dictionary.getMembersForKey("ipsum").size();
		
		//Should not add duplicates so the number of members should remain the same after an attempt to.
		dictionary.addDictionaryEntry("ipsum", "lorem");
		assertFalse(dictionary.getMembersForKey("ipsum").size() > numOfKeys);
		assertTrue(dictionary.getMembersForKey("ipsum").size() == 1);
		
		//no changes to other entries
		assertTrue(dictionary.getAllKeys().contains("foo"));
		assertTrue(dictionary.getAllKeys().contains("bang"));
		assertTrue(dictionary.getMembersForKey("foo").contains("bar"));
		assertTrue(dictionary.getMembersForKey("bang").contains("bar"));
	}
	
	@Test 
	public void testRemoveMember() {				
		dictionary.removeMember("bang", "bar");
		assertFalse(dictionary.getMembersForKey("bang").contains("bar"));
		assertTrue(dictionary.getMembersForKey("bang").contains("baz"));
		
		//no changes to other entries
		assertTrue(dictionary.checkIfKeyExists("foo"));
		assertTrue(dictionary.checkIfKeyExists("bang"));
		assertTrue(dictionary.checkIfMemberExists("foo", "bar"));
		assertTrue(dictionary.checkIfMemberExists("foo", "baz"));
		
		//key should be deleted after the last member is removed
		dictionary.removeMember("bang", "baz");
		assertFalse(dictionary.getAllKeys().contains("bang"));
	}
	
	@Test 
	public void testCheckIfKeyExists() {		
		assertTrue(dictionary.checkIfKeyExists("foo"));
		assertFalse(dictionary.checkIfKeyExists("ipsum"));
	}
	
	@Test 
	public void testCheckIfMemberExists() {		
		assertTrue(dictionary.checkIfMemberExists("foo", "bar"));
		assertFalse(dictionary.checkIfMemberExists("foo", "lorem"));
		assertFalse(dictionary.checkIfMemberExists("ipsum", "bar"));
	}
	
	@Test 
	public void testRemoveAll() {		
		dictionary.removeKey("bang");
		assertFalse(dictionary.getAllKeys().contains("bang"));
		
		//no changes to other entries
		assertTrue(dictionary.getAllKeys().contains("foo"));
		assertTrue(dictionary.getMembersForKey("foo").contains("bar"));
		assertTrue(dictionary.getMembersForKey("foo").contains("baz"));
	}
	
	private Map<String, Set<String>> createMockDictionary(){
		Map<String, Set<String>> mockDictionary = new HashMap<String, Set<String>>();
		Set<String> mockMemberOne = new HashSet<String>();
		Set<String> mockMemberTwo = new HashSet<String>();
		
		mockMemberOne.add("bar");
		mockMemberOne.add("baz");
		mockMemberTwo.add("bar");
		mockMemberTwo.add("baz");
		
		mockDictionary.put("foo", mockMemberOne);
		mockDictionary.put("bang" , mockMemberTwo);
		
		return mockDictionary;
	}

}