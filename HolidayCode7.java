import java.io.*;

public class HolidayCode7 {

  public static void main(String[] args){	  

    
    try{
        File file = new File("IPList.txt");
  	   FileReader fileReader = new FileReader(file);
  	   BufferedReader input = new BufferedReader(fileReader);
        
        
        String line;
        int total = 0;
        
       
        while((line = input.readLine()) != null){
          boolean validOut = false;
          //Assuming all have [] sequences
          boolean validIn = true;
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
            if(charString.length() > 4){
            	charString = charString.substring(1);
            }
            
            if (charString.length() < 4){
            	continue; //Can do nothing
            } else {
            	String first = charString.substring(0, 2);
            	String second = charString.substring(2);
            	String reverseSecond = Character.toString(second.charAt(1));
            	reverseSecond += Character.toString(second.charAt(0));
            	if(second.charAt(0) == second.charAt(1)){
            		//Same character. Continue
            		continue;
            	}
            	if(first.equals(reverseSecond)){
            		if(inside){
            			validIn = false;
            			break;
            		} else {
            			validOut = true;
            		}
            	}
            }
            
            
          }
          
          if(validIn && validOut){
        	  total++;
          }
        
        }
        
        System.out.println(total);
        
     } catch (IOException error) { //Need this for using buffered readers
  			error.printStackTrace();
  	 }

    
  }
  
}
