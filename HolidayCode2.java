import java.util.*;

public class HolidayCode2 {

  public static void main(String[] args){	  

    Scanner input = new Scanner(System.in);
    
    int lastOutput = 5;
    
    for(int i = 0; i < 5; i++){
    	
      String rawIn = input.nextLine();  
      
      String[] orders = rawIn.split("");
      int output = lastOutput;
      for(int j = 0; j < orders.length; j++){
    	  
    	  String letter = orders[j];
    	  if(letter.equals("U")){
    		  if(output > 2 && (output != 4 && (output != 5 && output != 9))){
    			  //Subtract what is needed
    			  if(output == 3 || output == 13){
    				  output -= 2;
    			  } else {
    				  output -= 4;
    			  }
    		  }
    	  } else if (letter.equals("D")){
    		  if(output < 12 && (output != 10 && (output != 5 && output != 9))){
    			  //Add what is needed
    			  if(output == 1 || output == 11){
    				  output += 2;
    			  } else {
    				  output += 4;
    			  }
    		  }
    	  } else if (letter.equals("L")){
    		  if(output > 2 && (output != 5 && (output != 10 && output != 13))){
    			  //Subtract what is needed
    			  output -= 1;
    		  }
    	  } else {
    		  if(output < 12 && (output != 9 && (output != 4 && output != 1))){
    			  //Subtract what is needed
    			  output += 1;
    		  }
    	  }
    	  
      }
      
      System.out.println(output);
      lastOutput = output;
      
      
    }
  
    
  }
   
}
