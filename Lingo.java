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
        int index = rn.nextInt(words.size());        
        String trueWord = words.get(index).toUpperCase();
        
        //Now for the Lingo Logic
        Scanner in = new Scanner(System.in);
        String[] hint = trueWord.split("");
        String firstLetter = hint[0].toUpperCase();
        hint[0] = firstLetter;
        for(int i = 1; i < hint.length; i++){
        	hint[i] = ".";
        }
      
        while(true){
          
        	
        	for(int i = 0; i < hint.length; i++){
        		System.out.print(hint[i]);
            }
        	
        	//Reset hint now - looks better
        	for(int i = 1; i < hint.length; i++){
            	hint[i] = ".";
            }
      
        	
          System.out.println();
          String guess = in.nextLine().toUpperCase();
          
          if(guess.equals(trueWord)){
            System.out.println("You win!");
            break;
          }
          
          for(int i = 0; i < guess.length(); i++){//Assumes length 5 of guess
            
            if(guess.charAt(i) == trueWord.charAt(i)){
              char letter = trueWord.charAt(i);
              hint[i] =  Character.toString(letter).toUpperCase();
            } else if(trueWord.contains(Character.toString(guess.charAt(i)).toUpperCase())){
            	char letter = guess.charAt(i);
                hint[i] =  Character.toString(letter).toLowerCase();
            }
            
          }
          
          
        }        
        
     } catch (IOException error) { //Need this for using buffered readers
  			error.printStackTrace();
  	 }

    
  }
  
}
