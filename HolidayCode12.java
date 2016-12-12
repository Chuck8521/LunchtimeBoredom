import java.io.*;
import java.util.*;

public class HolidayCode12 {

  public static void main(String[] args){	  

    
    try{
        File file = new File("assembunny.txt");
  	   FileReader fileReader = new FileReader(file);
  	   BufferedReader input = new BufferedReader(fileReader);
       
       ArrayList<String> instructions = new ArrayList<String>();
       
        while((line = input.readLine()) != null){
        	
          instructions.add(line);
        
        }
        
        //Now execute
      
        
     } catch (IOException error) { //Need this for using buffered readers
  			error.printStackTrace();
  	 }

    
  }
  
}
