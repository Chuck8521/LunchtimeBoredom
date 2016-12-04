import java.util.ArrayList;
import java.io.*;

public class HolidayCode4 {

  public static void main(String[] args){	  

    
    try{
        File file = new File("rooms.txt");
  	   FileReader fileReader = new FileReader(file);
  	   BufferedReader input = new BufferedReader(fileReader);
        
        
        String line;
        int total = 0;
        
        //97 to 122
       
        while((line = input.readLine()) != null){
        
        	String[] parts = line.split("-");
        	String spec = parts[parts.length - 1];
        	String[] numCheck = spec.split("\\[");
        	String sectorNum = numCheck[0];
        	String check = numCheck[1];
        	String newCheck = check.substring(0, check.length() - 1);
        	//System.out.println(newCheck);
        	
        	
        	
        	int shift = Integer.parseInt(sectorNum);
        	shift = shift % 26;
        	String north = "north";
        	String newNorth = "";
        	for(int i = 0; i < north.length(); i++){
        		int num = (int) north.charAt(i);
        		//num += shift;
        		num -= shift;
        		if(num < 97){
        			int temp = 96 - num;
        			//num -= 122;
        			num = 122 - temp;
        		}
        		char toAdd = (char) num;
        		//System.out.println(toAdd);
        		newNorth += toAdd;
        	}
        	
        	//System.out.println(newNorth);
        	
        	String whole = "";
        	for(int i = 0; i < parts.length - 1; i++){
        		whole += parts[i];
        	}
        	
        	if(whole.contains(newNorth)){
        		System.out.println("HERE: " + sectorNum);
        	}
        	
        	
        	
        	
        	//Get five most used letters. If tied, order

        	
        	ArrayList<Character> letters = new ArrayList<Character>();
        	ArrayList<Integer> freq = new ArrayList<Integer>();
        	
        	for(int i = 0; i < whole.length(); i++){
        		if(!letters.contains(whole.charAt(i))){
        			letters.add(whole.charAt(i));
        			freq.add(1);        			
        		} else {
        			int temp = freq.get(letters.indexOf(whole.charAt(i))); 
        			temp++;
        			freq.set(letters.indexOf(whole.charAt(i)), temp);
        		}
        	}
        	
        	//System.out.println(letters.toString());
        	//System.out.println(freq.toString());
        	
        	boolean valid = true;
        	
        	for(int i = 0; i < 5; i++){
        		char test = newCheck.charAt(i);
        		if(letters.contains(test)){
        			int times = freq.get(letters.indexOf(test));
        			//char inCase = letters.get(letters.indexOf(test));
        			freq.remove(letters.indexOf(test));
        			letters.remove(letters.indexOf(test));
        			for(int j = 0; j < freq.size(); j++){
        				if(freq.get(j) < times){
        					//Nothing
        				} else if(freq.get(j) == times){
        					//Alphabetical
        					int test1 = (int) test;
        					int test2 = (int) letters.get(j);
        					if(test1 >= test2){
        						valid = false;
        					}
        				} else {
        					//Invalid.
        					valid = false;
        				}
        			} 
        		} else {
        			//System.out.print(test);
        			valid = false;
        		}
        	}
        	
        	if(valid){
        		total += Integer.parseInt(sectorNum);
        	}
        	
        	
             
        }
        
        System.out.println(total);
     
     } catch (IOException error) { //Need this for using buffered readers
  			error.printStackTrace();
  	 }

    
  }
  
}
