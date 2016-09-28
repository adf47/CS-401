//Antonino Febbraro
//Lab 3 Logs
//September 23, 2015

import java.util.Scanner;

/**
 *
 * @author AntoninoFebbraro
 */
public class Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int b=0;
        int X=0;
        int ans=0;
        int count=1;
        int z=0;//for loop
       
        
        System.out.println("Enter in a base that is greater than 1. Or -1 to quit");
        Scanner input = new Scanner(System.in);
        
        
        
          while(z==0){  
            b = input.nextInt();//the base varible
            
            if(b>1){
                System.out.println("Enter in an integer. Or enter 0 or negative number to quit.");
            }
            else{
                System.exit(0);
            }
           
                X=input.nextInt();
                
                   
               
                   
                   if(X>=1){
                       
                       while((X/b)>=b){
                           
                           X=X/b;
                           ++count;
                           ans =count;
                           
                       }
                   }
                   else{
                       System.exit(0);
                   }
                   
                   System.out.println("The answer is "+ans);
                   count=1;
                   System.out.println("Enter in a base that is greater than 1. Or -1 to quit");
              }   
                        
                  
           
             
          
           
       
        
    }
    
}
