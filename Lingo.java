import java.io.*;
import java.util.*;

public class Lingo {

  public static void main(String[] args){	  

    
    try{
        File file = new File("5LetterWords.txt");
  	    FileReader fileReader = new FileReader(file);
  	    BufferedReader input = new BufferedReader(fileReader);

        ArrayList<String> words = new ArrayList<String>();

        String line;
        while ((line = input.readLine()) != null) {
          words.add(line);
        }
        
        Random rn = new Random();
        index = rn.nextInt(words.size());        
        trueWord = words.get(index);
        
        //Now for the Lingo Logic
        Scanner in = new Scanner(System.in);
        unsolved = true;
        
        while(unsolved){
          
          guess = in.nextLine();
          
        }        
        
     } catch (IOException error) { //Need this for using buffered readers
  			error.printStackTrace();
  	 }

    
  }
  
}
