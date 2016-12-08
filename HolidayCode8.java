import java.io.*;
import java.util.*;

public class HolidayCode8 {

  public static void main(String[] args){	  

    
    try{
        File file = new File("TinyScreen.txt");
  	   FileReader fileReader = new FileReader(file);
  	   BufferedReader input = new BufferedReader(fileReader);
        
        
        String line;        
        int[][] screen = new int[6][50];
        for(int i = 0; i < 6; i++){
        	for(int j = 0; j < 50; j++){
        		screen[i][j] = 0;
        	}
        }
       
        while((line = input.readLine()) != null){
        	
        	String[] parts = line.split(" ");
        	for(int i = 0; i < parts.length; i++){
        		System.out.println(parts[i]);
        	}
        	if(parts[0].equals("rect")){
        		String[] specs = parts[1].split("x");
        		int width = Integer.parseInt(specs[0]);
        		int height = Integer.parseInt(specs[1]);
        		
        		//Turn everything on
        		for(int i = 0; i < height; i++){
        			for(int j = 0; j < width; j++){
        				screen[i][j] = 1;
        			}
        		}
        	} else {
        		//Rotate
        		if(parts[1].equals("row")){
        			//Shift right by b pixels
        			String[] specs = parts[2].split("=");
        			int rowIndex = Integer.parseInt(specs[1]);
        			int shift = Integer.parseInt(parts[4]);
        			shift = shift % 50;
        			
        			int[] newRow = new int[50];
        			for(int i = 0; i < 50; i++){
        				if(i + shift > 49){
        					int index = (i + shift) - 50;
        					newRow[index] = screen[rowIndex][i];
        				} else {
        					newRow[i + shift] = screen[rowIndex][i];
        				}
        			}
        			
        			for(int i = 0; i < 50; i++){
        				screen[rowIndex][i] = newRow[i];
        			}
        			
        		} else {
        			//Column
        			//Shift down by b pixels
        			String[] specs = parts[2].split("=");
        			int columnIndex = Integer.parseInt(specs[1]);
        			int shift = Integer.parseInt(parts[4]);
        			shift = shift % 6;
        			
        			int[] newColumn = new int[6];
        			for(int i = 0; i < 6; i++){
        				if(i + shift > 5){
        					int index = (i + shift) - 6;
        					newColumn[index] = screen[i][columnIndex];
        				} else {
        					newColumn[i + shift] = screen[i][columnIndex];
        				}
        			}
        			
        			for(int i = 0; i < 6; i++){
        				screen[i][columnIndex] = newColumn[i];
        			}
        			
        		}
        	}
        	
        }
        
        //int total = 0;
        for(int i = 0; i < 6; i++){
        	for(int j = 0; j < 50; j++){
        		System.out.print(screen[i][j]);
        	}
        	System.out.println();
        }
        //System.out.println(total);
        
     } catch (IOException error) { //Need this for using buffered readers
  			error.printStackTrace();
  	 }

    
  }
  
}
