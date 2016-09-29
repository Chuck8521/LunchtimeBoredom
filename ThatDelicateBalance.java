//2005 - #4

import java.util.*;

public class ThatDelicateBalance {

  public static double thatFunction(double num){
    //The function?
      double sum = 0.0;
        for(double x = 0.0; x <= num; x++){
          sum += Math.pow(3.0, x);
        }
        return sum;
  }

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    int times = input.nextInt();

    for(int i = 0; i < times; i++){
      
      int initialWeight = input.nextInt();
      
      int leftW = initialWeight;
      int rightW = 0;
      
      ArrayList<Integer> jValues = new ArrayList<Integer>();
      for(int x = 0; x < 20; x++){
        jValues.add(x);
      }
      
      ArrayList<Integer> basketR = new ArrayList<Integer>();
      ArrayList<Integer> basketL = new ArrayList<Integer>();
      
      while(true){
        
      int w = leftW - rightW;
      
      if(w == 0){
        //solved
        //TODO output
        System.out.print(initialWeight + " ");
        Collections.sort(basketR);
        Collections.sort(basketL);
        //TODOTODOTODOTODOTODOTODO
        for(int x = 0; x < basketR.size(); x++){
         System.out.print(basketR.get(x) + " "); 
        }
        for(int x = 0; x < basketL.size(); x++){
         System.out.print(basketL.get(x) + " "); 
        }
        System.out.println();
        
      }
      for(int j = 0; j < jValues.size() - 1; j++){
        if((thatfunction(jValues.get(j)) < Math.abs(w)) && thatfunction(jValues.get(j) + 1) > Math.abs(w)){//Fiddle with this
          //We have the j we're looking for
          //Place the weight 3^j into lighter basket
          if(w > 0){
            //right is lighter basket
            rightW += Math.pow(3, j);
            basketR.add(-1 * Math.pow(3, j));
            jValues.remove(jValues.indexOf(j));
          } else {
            //left is lighter basket
            leftW += Math.pow(3, j);
            basketL.add(Math.pow(3, j));
            jValues.remove(jValues.indexOf(j));
          }
        }
      }
        
      }//End while
      
    }
    
  }
   
}
