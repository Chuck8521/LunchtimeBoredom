//English to PigLatin Converter v0.01
//Code by Ethan MacDonald 11/28/16
//No GUI yet, this project just struck me as fun so I threw it together 

import java.util.*;
public class englishToPiglatin { 
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String infoString = "Type English below, press enter, and get Pig Latin back! ";
		String inputStringRaw = "default";
		String inputString = "default";
		String outputString = "efaultday";
		String outputPrefix = "Igpay Atinlay: \n";
		
		System.out.println(infoString);
		System.out.print("English: \n");
		inputStringRaw = input.nextLine();
		inputString = inputStringRaw.toLowerCase();
		
		String[] inputArray = index(inputString);
		String[] piglatinArray = encode(inputArray);
		String output = concatenate(piglatinArray);
		outputString = outputPrefix + output;
		System.out.println(outputString);
	}
	public static String[] index(String inputString){
		String[] a = inputString.split(" ");
		return a;
	}
	public static String translate(String english){
		String first = english.substring(0,1);
		String rest = english.substring(1);
		String piglatin = rest + first + "ay";
		return piglatin;
	}
	public static String[] encode(String[] inputArray){
		String[] piglatinArray = new String[inputArray.length];
		for(int i =0; i<inputArray.length; i++){
			String english = inputArray[i];
			String piglatin = translate(english);
			piglatinArray[i] = piglatin;
		}
		return piglatinArray;
	}
	public static String concatenate(String[] piglatinArray){
		String output = "";
		for(int j=0; j<piglatinArray.length; j++){
			output += piglatinArray[j] + " ";
		}
		return output;
	}
}
