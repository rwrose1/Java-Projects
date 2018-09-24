package com.validator;

import java.util.ArrayList;

public class StateNode {

	//ArrayLists to store the state transitions.
	private ArrayList<Character> changeChar;
	private ArrayList<Integer> stateChange;
	
	//Constructor that initializes ArrayLists.
	public StateNode() {
		
		changeChar = new ArrayList<Character>();
		stateChange = new ArrayList<Integer>();
		
	}
	
	//Method to add state transition.
	public void addStateChange(int state, char character) {
		
		stateChange.add(state);
		changeChar.add(character);
		
	}
	
	//Method to check to see if the state has the transition character c. If the transition character
	//exists, it returns the state that character transitions to. If not, the method returns -1.
	public int checkForChangeChar(char c) {
		
		char test;
		
		for (int i = 0; i < changeChar.size(); i++) {
			
			test = changeChar.get(i);
			
			if (c == test) {
				
				return stateChange.get(i);
			
			}
			
		}
	
		return -1;
		
	}

/*	Unnecessary test code.
	public void printAll(int specificState) {
		
		System.out.println();
		
		int a = 0;
		for (int i = 0; i < changeChar.size(); i++) {
			
			System.out.println("STATE " + specificState + " - Change " + a + ": " + changeChar.get(i) + " goes to " + stateChange.get(i));
			a++;
		}
		
	} 
*/
	
}
