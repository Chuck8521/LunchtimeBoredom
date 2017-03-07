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
        String trueWord = words.get(index);
        
        //Now for the Lingo Logic
        Scanner in = new Scanner(System.in);
        String hint = Character.toString(trueWord.getChar(0));
        hint += "....";
      
        while(true){
          
          System.out.println(hint);
          String guess = in.nextLine();
          
          if(guess.equals(trueWord)){
            System.out.println("You win!");
            break;
          }
          
          for(int i = 0; i < guess.length(); i++){//Assumes length 5 of guess
            
            if(guess.charAt(i) == trueWord.charAt(i)){
              hint.charAt(i) == trueWord.charAt(i).toUpperCase();
            } else if(trueWord.contains(guess.charAt(i))){
              hint.charAt(i) == guess.charAt(i).toLowerCase();
            }
            
          }
          
          
        }        
        
     } catch (IOException error) { //Need this for using buffered readers
  			error.printStackTrace();
  	 }

    
  }
  
}
