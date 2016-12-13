import java.util.ArrayList;
import java.io.*;

public class HolidayCode10 {

  public static void main(String[] args){	  

    
    try{
        File file = new File("bots.txt");
  	   FileReader fileReader = new FileReader(file);
  	   BufferedReader input = new BufferedReader(fileReader);
        
        
        String line;
        ArrayList<Integer> values = new ArrayList<Integer>();
        for(int i = 0; i < 300; i++){
        	values.add(0);
        }
        
        
       
        while((line = input.readLine()) != null){
        
        	String[] parts = line.split(" ");
        	
        	if(parts[0].equals("value")){
        		
        		int value = Integer.parseInt(parts[1]);
        		int bot = Integer.parseInt(parts[5]);
        		
        		values.set(value, bot);
        		
        	} else {
        		//high-low bot thing
        		int bot = Integer.parseInt(parts[1]);
        		if(values.contains(bot)){
        			//Valid command. 5 and 10 can be output or bot
        			int lowIndex = values.indexOf(bot);
        			int highIndex = values.lastIndexOf(bot);
        			if(parts[5].equals("output")){
        				
        				//Discard low value - goes back to 0 in value array
        				values.set(lowIndex, 0);
        				
        			} else {
        				
        				int recipient = Integer.parseInt(parts[6]);
        				values.set(lowIndex, recipient);
        				
        			}
        			
        			if(parts[10].equals("output")){
        				
        				//Discard high value - goes back to 0 in value array
        				values.set(highIndex, 0);
        				
        			} else {
        				
        				int recipient = Integer.parseInt(parts[11]);
        				values.set(highIndex, recipient);
        				
        			}
        			
        		}        		
        	}
        	
        	if(values.get(61) == values.get(17) && values.get(17) != 0){
        		System.out.println(values.get(61));
        		//break;
        	}
        	
        }
        
    } catch  (IOException error) { //Need this for using buffered readers
			error.printStackTrace();
    }
    
  }
  
}
