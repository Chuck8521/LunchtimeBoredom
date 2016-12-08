import java.io.*;
import java.util.*;

public class HolidayCode7 {

  public static void main(String[] args){	  

    
    try{
        File file = new File("IPList.txt");
  	   FileReader fileReader = new FileReader(file);
  	   BufferedReader input = new BufferedReader(fileReader);
        
        
        String line;
        int total = 0;
        
       
        while((line = input.readLine()) != null){
          //Assuming all have [] sequences
        	ArrayList<String> lookForIn = new ArrayList<String>();
        	ArrayList<String> lookForOut = new ArrayList<String>();
          boolean valid = false;
          boolean inside = false;
          String charString = "";
          for(int i = 0; i < line.length(); i++){
            char current = line.charAt(i);
            if(current == '['){
              inside = true;
              charString = "";
              continue;
            } else if (current == ']'){
              inside = false;
              charString = "";
              continue;
            }
            
            //We know it's not an open or close. Do stuff
            charString += Character.toString(current);
            if(charString.length() > 3){
            	charString = charString.substring(1);
            }
            
            if (charString.length() < 3){
            	continue; //Can do nothing
            } else {
            	String first = charString.substring(0, 2);
            	String second = charString.substring(1);
            	String reverseSecond = Character.toString(second.charAt(1));
            	reverseSecond += Character.toString(second.charAt(0));
            	if(first.charAt(0) == first.charAt(1)){
            		//Same character. Continue
            		continue;
            	}
            	
            	if(reverseSecond.equals(first)){
            		//We have an ABA string.
            		String inverse = second;
            		inverse += Character.toString(inverse.charAt(0));
            		//System.out.println(charString);
            		//System.out.println(inverse);
            		if(inside){
            			if(lookForIn.contains(charString)){
            				valid = true;
            				continue;
            			} else {
            				lookForOut.add(inverse);
            			}
            		} else {
            			if(lookForOut.contains(charString)){
            				valid = true;
            				continue;
            			} else {
            				lookForIn.add(inverse);
            			}
            		}
            	}
            	
            }
            
            
          }
          
          if(valid){
        	  total++;
          }
        
        }
        
        System.out.println(total);
        
     } catch (IOException error) { //Need this for using buffered readers
  			error.printStackTrace();
  	 }

    
  }
  
}
