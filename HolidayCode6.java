import java.util.*;
import java.io.*;

public class HolidayCode6 {
    
    public static char MostFrequent (HashMap<Character, Integer> charMap){//For Part 2, Least Frequent
        
        //int max = 0;
    	int min = 999999;
        char mostFreq = ' ';
        for(char current : charMap.keySet()){
            if(charMap.get(current) < min){
                mostFreq = current;
                min = charMap.get(current);
            }
        }
        
        return mostFreq;
        
    }

  public static void main(String[] args){	  

    
    try{
        File file = new File("message.txt");
  	   FileReader fileReader = new FileReader(file);
  	   BufferedReader input = new BufferedReader(fileReader);
        
        
        String line;
       
       HashMap<Character, Integer> char1 = new HashMap<Character, Integer>();
       HashMap<Character, Integer> char2 = new HashMap<Character, Integer>();
       HashMap<Character, Integer> char3 = new HashMap<Character, Integer>();
       HashMap<Character, Integer> char4 = new HashMap<Character, Integer>();
       HashMap<Character, Integer> char5 = new HashMap<Character, Integer>();
       HashMap<Character, Integer> char6 = new HashMap<Character, Integer>();
       HashMap<Character, Integer> char7 = new HashMap<Character, Integer>();
       HashMap<Character, Integer> char8 = new HashMap<Character, Integer>();
       
        while((line = input.readLine()) != null){
        
            char current = line.charAt(0);
            if(char1.get(current) != null){
                int value = char1.get(current);
                value++;
                char1.put(current, value);
            } else {
                char1.put(current, 1);
            }
            
            current = line.charAt(1);
            if(char2.get(current) != null){
                int value = char2.get(current);
                value++;
                char2.put(current, value);
            } else {
                char2.put(current, 1);
            }
            
            current = line.charAt(2);
            if(char3.get(current) != null){
                int value = char3.get(current);
                value++;
                char3.put(current, value);
            } else {
                char3.put(current, 1);
            }
            
            current = line.charAt(3);
            if(char4.get(current) != null){
                int value = char4.get(current);
                value++;
                char4.put(current, value);
            } else {
                char4.put(current, 1);
            }
            
            current = line.charAt(4);
            if(char5.get(current) != null){
                int value = char5.get(current);
                value++;
                char5.put(current, value);
            } else {
                char5.put(current, 1);
            }
            
            current = line.charAt(5);
            if(char6.get(current) != null){
                int value = char6.get(current);
                value++;
                char6.put(current, value);
            } else {
                char6.put(current, 1);
            }
            
            current = line.charAt(6);
            if(char7.get(current) != null){
                int value = char7.get(current);
                value++;
                char7.put(current, value);
            } else {
                char7.put(current, 1);
            }
           
           current = line.charAt(7);
           if(char8.get(current) != null){
                int value = char8.get(current);
                value++;
                char8.put(current, value);
            } else {
                char8.put(current, 1);
            }
        	
        }
       
        
        System.out.print(MostFrequent(char1));
        System.out.print(MostFrequent(char2));
        System.out.print(MostFrequent(char3));
        System.out.print(MostFrequent(char4));
        System.out.print(MostFrequent(char5));
        System.out.print(MostFrequent(char6));
        System.out.print(MostFrequent(char7));
        System.out.println(MostFrequent(char8));
     
     } catch (IOException error) { //Need this for using buffered readers
  			error.printStackTrace();
  	 }

    
  }
  
}
