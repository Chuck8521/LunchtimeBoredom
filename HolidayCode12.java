import java.io.*;
import java.util.*;

public class HolidayCode12 {
	
    public static boolean isParsable(String input){
	    boolean parsable = true;
	    try{
	        Integer.parseInt(input);
	    }catch(NumberFormatException e){
	        parsable = false;
	    }
	    return parsable;
	}

  public static void main(String[] args){	  

    
    try{
        File file = new File("assembunny.txt");
  	   FileReader fileReader = new FileReader(file);
  	   BufferedReader input = new BufferedReader(fileReader);
       
       ArrayList<String> instructions = new ArrayList<String>();
       
       String line;
       
        while((line = input.readLine()) != null){
        	
          instructions.add(line);
        
        }
        
        //Now execute
      
        int a = 0;
        int b = 0;
        int c = 1;
        int d = 0;
        
        for(int i = 0; i < instructions.size(); i++){
        	
        	String current = instructions.get(i);
        	String[] parts = current.split(" ");
        	
        	//System.out.println(parts.toString());
        	
        	if(parts[0].equals("cpy")){
        		
        		String name = parts[2];

        		if(isParsable(parts[1])){
        			
        			if(name.equals("a")){
        				a = Integer.parseInt(parts[1]);
        			} else if(name.equals("b")){
        				b = Integer.parseInt(parts[1]);
        			} else if(name.equals("c")){
        				c = Integer.parseInt(parts[1]);
        			} else {
        				d = Integer.parseInt(parts[1]);
        			}
        			
        		} else {
        			String copyFrom = parts[1];
        			int value = 0;
        			
        			if(copyFrom.equals("a")){
        				value = a;
        			} else if(copyFrom.equals("b")){
        				value = b;
        			} else if(copyFrom.equals("c")){
        				value = c;
        			} else {
        				value = d;
        			}
        			
        			if(name.equals("a")){
        				a = value;
        			} else if(name.equals("b")){
        				b = value;
        			} else if(name.equals("c")){
        				c = value;
        			} else {
        				d = value;
        			}
        			
        		}
        		
        	} else if(parts[0].equals("inc")){
        		
        		String name = parts[1];
        		
        		if(name.equals("a")){
    				a++;
    			} else if(name.equals("b")){
    				b++;
    			} else if(name.equals("c")){
    				c++;
    			} else {
    				d++;
    			}
        		
        	} else if(parts[0].equals("dec")){
        		
        		String name = parts[1];
        		
        		if(name.equals("a")){
    				a--;
    			} else if(name.equals("b")){
    				b--;
    			} else if(name.equals("c")){
    				c--;
    			} else {
    				d--;
    			}
        		
        	} else {
        		
        		//Jump
        		String name = parts[1]; 
        		boolean notZero = true;
        		
        		if(name.equals("a")){
    				if(a == 0){
    					notZero = false;
    				}
    			} else if(name.equals("b")){
    				if(b == 0){
    					notZero = false;
    				}
    			} else if(name.equals("c")){
    				if(c == 0){
    					notZero = false;
    				}
    			} else {
    				if(d == 0){
    					notZero = false;
    				}
    			}
        		
        		if(notZero){
        			
        			int jumpDistance = Integer.parseInt(parts[2]);
        			jumpDistance -= 1;
        			i += jumpDistance;
        			
        		}
        		
        	}
        	
        }
        
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        
     } catch (IOException error) { //Need this for using buffered readers
  			error.printStackTrace();
  	 }

    
  }
  
}
