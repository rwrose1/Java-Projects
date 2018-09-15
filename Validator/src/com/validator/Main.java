package com.validator;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	@SuppressWarnings("resource")
	public static void main (String args[]) throws IOException {
		
		//Initializing BufferedReader to read file lines to text
		BufferedReader br;
		
		//Initializing general purpose tools for parsing
		StringTokenizer st;
		String line;
		
		int initialState;
		String character;
		int stateChange;
		
		char[] testChars;
		
		//Preparing to parse the InputFile (file name = args[0]
		br = new BufferedReader(new FileReader(args[0]));
		
		//While the input given to line is not null
		int a = 1;
		while ((line = br.readLine()) != null) {
			
			st = new StringTokenizer(line);
					
			initialState = Integer.parseInt(st.nextToken());
			character = st.nextToken();
			stateChange = Integer.parseInt(st.nextToken());
			
			System.out.println("Line " + a + " - " + initialState + " " + character + " " + stateChange);
			a++;
			
		}
		
	
		br = new BufferedReader(new FileReader(args[1]));
		
		a = 1;
		while ((line = br.readLine()) != null) {
			
			testChars = line.toCharArray();
			System.out.print("\nline " + a + " - ");
			
			for(int i = 0; i < testChars.length; i++) {
				System.out.print(testChars[i]);
			}
			
			a++;
		}
		
	}
	
}
