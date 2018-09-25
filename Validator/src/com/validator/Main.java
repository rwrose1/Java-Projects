package com.validator;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main (String args[]) throws IOException {
		
		//Initializing BufferedReader to read file lines to text
		BufferedReader br;
		
		//Initializing general purpose tools for parsing
		StringTokenizer st;
		String line;
		
		int initialState;
		char character;
		int stateChange;
		
		char[] testChars;
		
		//Data structure used to store states using StateNode. The State Machine
		ArrayList<StateNode> states = new ArrayList<StateNode>();
		
		//Preparing to parse the InputFile (file name = args[0]
		br = new BufferedReader(new FileReader(args[0]));
		
		
		//While the input given to line is not null, split the information on the line, 
		//parse into integers and characters, then follow the conditions.
		while ((line = br.readLine()) != null) {
			
			st = new StringTokenizer(line);
					
			initialState = Integer.parseInt(st.nextToken());
			character = (st.nextToken()).charAt(0);
			stateChange = Integer.parseInt(st.nextToken());
			
			//If the initialState isn't in the state machine (ArrayList states), create new
			//stateNode with the state transition and add it to the state machine
			if (initialState >= states.size()) {
				
				StateNode newNode = new StateNode();
				newNode.addStateChange(stateChange, character);
				states.add(newNode);
				
			//If the initialState is in the state machine, then add the state change information
			//to that state.
			} else {
				
				states.get(initialState).addStateChange(stateChange, character);
				
			}
			
		}
		
		//Close FileReader and BufferedReader, and assign new input file with the test cases
		br.close();
		br = new BufferedReader(new FileReader(args[1]));
		
		//While the line isn't null, break the line string into a character array, and process
		//the characters with the state machine.
		while ((line = br.readLine()) != null) {
			
			//Initialize tools for processing.
			testChars = line.toCharArray();
			
			StateNode currentNode = states.get(0);
			Boolean done = false;
			int potentialChange = -2;
		
			//For every character in the character array, call checkForChangeChar on currentNode, then follow
			//the conditionals.
			for(int i = 0; i < testChars.length; i++) {
				
				potentialChange = currentNode.checkForChangeChar(testChars[i]);
				
				//If potentialChange is -1, print the failure message when the incorrect character is found, then set
				//done to true. Then break the loop.
				if (potentialChange == -1) {
					
					System.out.println("Failure at position " + i + ", found character " + testChars[i]);
					done = true;
					break;
					
				} else 
		
				//If potentialChange is 999, print Success and set done to true. Then break the loop.
				if (potentialChange == 999 ){
					
					System.out.println("Success");
					done = true;
					break;
		
				//Failing both of those conditions, continue processing the char array.
				} else {
					
					currentNode = states.get(potentialChange);
					
				}
				
			}
			
			//If the character array terminates before finding the end state, done will be false. Therefore, print
			//the requisite failure text.
			if (!done) {
				System.out.println("Input string ended before success transition.");
			}
			
		}
		
	}  
	
}
