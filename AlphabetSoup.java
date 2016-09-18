//2006 - #2

import java.util.*;

public class AlphabetSoup {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    int times = input.nextInt();

    for(int i = 0; i < times; i++){
       String in = inputString.nextLine();
             
       int messages = input.nextInt();
       for(int x = 0; x < messages; x++){
         ArrayList<String> letters = new ArrayList<String>();
         for(int c = 0; c < in.length(); c++){
           letters.add(in.substring(c,c + 1).toLowerCase());
         }
         boolean valid = true;
         String test = inputString.nextLine();
         for(int j = 0; j < test.length(); j++){
           if(!letters.contains(test.substring(j,j + 1).toLowerCase()) && Character.isLetter(test.charAt(j))){
             valid = false;
           } else if (Character.isLetter(test.charAt(j))) {
             letters.remove(letters.indexOf(test.substring(j,j + 1).toLowerCase()));
           }
         }
         
         if(valid){
           System.out.println(test + " : YES");
         } else {
           System.out.println(test + " : NO");
         }
         
       }
       
       System.out.println();//As per requirments
       inputString.nextLine();
    }
    
}

}
