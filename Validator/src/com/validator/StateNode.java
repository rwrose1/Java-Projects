package com.validator;

import java.util.ArrayList;

public class StateNode {

	private ArrayList<Character> changeChar;
	private ArrayList<Integer> stateChange;
	
	public StateNode() {
		
		changeChar = new ArrayList<Character>();
		stateChange = new ArrayList<Integer>();
		
	}
	
	public void addStateChange(int state, char character) {
		
		//System.out.println(state + " " + character);
		
		stateChange.add(state);
		changeChar.add(character);
		
	}
	
	public int checkForChangeChar(char c) {
		
		char test;
		
		for (int i = 0; i < changeChar.size(); i++) {
			
			test = changeChar.get(i);
			
			if (c == test) {
				
				//System.out.print(i);
				
				return stateChange.get(i);
			
			}
			
		}
	
		return -1;
		
	}
	
	public void printAll(int specificState) {
		
		System.out.println();
		
		int a = 0;
		for (int i = 0; i < changeChar.size(); i++) {
			
			System.out.println("STATE " + specificState + " - Change " + a + ": " + changeChar.get(i) + " goes to " + stateChange.get(i));
			a++;
		}
		
	}
	
}
