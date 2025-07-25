package com.aurionpro.filehandling;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//import javax.swing.plaf.basic.BasicToolTipUI;

public class LearnCharacterStram {

	public static void main(String[] args) throws IOException {
		FileReader reader = new FileReader("Welcome");
		FileWriter writer = new FileWriter("Output");

		fileTextDetails(reader,writer);
		test(reader);
	}
	
	private static void test(FileReader reader) {
//		while(reader)
		
	}

	public static void fileTextDetails(FileReader reader, FileWriter writer) throws IOException {
		int character;
		int charactersCount = 0;
		int spaceCount = 0;
		int lineCount = 1;
		int wordCount = 0;
		
		if( reader.read() == -1) {
			lineCount =0;
		}
		
		int lastCharacter = 0;
		while((character = reader.read())!=-1) {
//			writer.write(character);
			charactersCount++;
			if((char) character == ' ' && character != lastCharacter) {
				wordCount++;
			}
			if((char) character == ' ') {
				spaceCount++;
				continue;
			}
			if((char) character == '\n') {
				wordCount++;
				lineCount++;
			}
		}
		
//		wordCount += spaceCount+1;
		wordCount++;
		
		System.out.println("Total lines: "+ lineCount);
		System.out.println("Total Spaces: "+ spaceCount);
		System.out.println("Total words: "+ wordCount);
		System.out.println("Total Characters: "+ charactersCount);
		
		reader.close();
		writer.close();
	}

}
