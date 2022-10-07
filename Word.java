//*******************************************************************I M P O R T********************************************************************************//
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//***************************************************************************************************************************************************************//
/*
* Name: Liwen Cui
* Lab Instructor: Zhujun Li
* Lab Section: 212-11A
* 
*****************************************************************************************************************************************************************/
public class Word implements Comparable<Word>{
	private String Words;
	
	public Word(String W) throws IllegalWordException {
		if (isValidWord(W)) {
			if(W.contains(".")) {
				Words = W.replace(".", "");
			}
			else if(W.contains(",")) {
				Words = W.replace(",", "");  
			}
			else {
				Words = W;
			}
			          
		} else {
			throw new IllegalWordException("Invalid Word Found: " + "\n" + W);
		}
	}// constructor
	
	
	public boolean isValidWord(String W) {
		Pattern valid_Word = Pattern.compile("[a-zA-Z]*|[a-zA-Z]*,|[a-zA-Z]*.[^/d]");
		Matcher check = valid_Word.matcher(W);
		return check.matches();
	}
	
	public void setWords(String W) {
		Words = W;
	}// set method
	
	public String getWords() {
		return Words;
	}// get method
	
	public boolean equals(Object next) {
		return (next != null && getClass() == next.getClass()
				&& Words.equals(((Word) next).Words));
	}// return true if the next word exist and it's the same class as the word previously stored and they are equal character by character
	
	public int compareTo(Word next) {
		return Words.compareTo(next.toString());
	}// return a negative integer if the next word lexicographically bigger than the previous word, return a positive integer if the next word is lexicographically smaller
	// than the previous word, return 0 if they are lexicographically equal to each other.
	
	public String toString() {
		return Words;
	} 
	
}

