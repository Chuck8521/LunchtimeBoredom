import java.util.*;

public class Tutorial {
  
 public static void main(String[] args){
   
   Scanner input = new Scanner(System.in);
   
   String line = input.nextLine();
   
   String[] parts = line.split(" ");
   
   int number1 = Integer.parseInt(parts[0]);
   int number2 = Integer.parseInt(parts[2]);
   
   if(parts[1] == "*"){
     System.out.println(number1 * number2);
   } else if (parts[1] == "+"){
     System.out.println(number1 + number2);
   } else if (parts[1] == "-"){
     System.out.println(number1 - number2);
   } else {
     System.out.println(number1 / number2);
   }
   
 }  
  
}
