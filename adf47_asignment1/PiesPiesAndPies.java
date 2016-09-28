//Antonino Febbraro
//CS 401 1:00-2:15
//September 28, 2015
//Lab one Pies Pies an π's


import java.text.*;
import java.util.*;

/**
 *
 * @author AntoninoFebbraro
 */
public class PiesPiesAndPies {

        
    
    public static void main(String[] args) {
        
       int x =0; //for having the program run constantly over and over again
       
       while(x==0){
           
           System.out.println("Is there a customer in line? Yes or no?");//first question
           //setting up scanner class
           Scanner input = new Scanner(System.in);
           String in = input.nextLine();
           
               //to go to question 2
               if(in.equalsIgnoreCase("yes")){
                   QuestionTwo();
            }
               //to end the program
               if(in.equalsIgnoreCase("no")){
                   x=1;
               }
               else{
                   //blank else statement to reset the code
               }
           
           
       }
        
    }
    
    //question two method for printing the menus
    public static void QuestionTwo(){
        
        int x=0;
        while(x==0){
            System.out.println("Do you have a Pie Card? Yes or no?");//Second question

            //setting up scanner class
             Scanner input = new Scanner(System.in);
             String in = input.nextLine();  

                  if(in.equalsIgnoreCase("yes")){
                          
                           QuestionThreeDiscount();
                           x=1;
                       }

                   if(in.equalsIgnoreCase("no")){
                          
                           QuestionThree();
                           x=1;
                   }
                   else{
                       //done to repeat the loop 
                   }
            }
    }
    
    //Question Three Method
    public static void QuestionThree(){
        
        //Setting up scanner
        Scanner input = new Scanner(System.in);
        
        int x=0;
        int sliceNumber=0;
        int sliceNumberCount=0;//to count number of plain pizzas
        int pepSliceCount=0;//to count the number of pepperoni pizza slices
        int slices=0;
        int sliceCount=0;//to count the number of pie slices
        int charms=0;
        int charmCount=0;//to count the number of charms 
        double price=0.00; //for calculating the price
        double tempPrice=0.00;
        
        double pizzaPrice=0.00;
        double pepPrice=0.00;
        double piePrice=0.00;
        double charmPrice=0.00;
        
        
             System.out.println("\n");
             System.out.println("1.)Order Pizza. Plain $10.00. pepperoni $12.00");
             System.out.println("2.)Order Cherry Pies. Sold only in slices, $2.00 per slice. 6 slices=whole pie($10.00).");
             System.out.println("3.)Order π Charms. $50.00 per charm.");
             System.out.println("4.)Check Out");
             System.out.println("What would you like to order? Type in the order number.");//Third question
        
        while(x==0){
            
            

            
             String in = input.nextLine();  

                  if(in.equalsIgnoreCase("1")){//pizza
                      int y=0;
                      while(y==0){
                             
                           System.out.println("Do you want plain(enter in pl) or a pepperoni pizza(enter in pe)?");
                           in=input.nextLine();
                           
                            if(in.equalsIgnoreCase("pl")){//calculating price of plain pizza
                               
                              int z=0;
                             while(z==0){
                                System.out.println("How many plain pizzas do you want?");
                                
                                
                                if(input.hasNextInt()){
                                    sliceNumber = input.nextInt();
                                    
                                    if(sliceNumber>=0){
                                        //calculating price
                                        tempPrice = sliceNumber * 10.00;
                                        pizzaPrice = price + tempPrice;
                                        tempPrice=0.00;
                                    
                                        sliceNumberCount=sliceNumber+sliceNumberCount;
                                        
                                        System.out.println("\n");
                                        System.out.println("1.)Order Pizza. Plain $10.00. pepperoni $12.00");
                                        System.out.println("2.)Order Cherry Pies. Sold only in slices, $2.00 per slice. 6 slices=whole pie($10.00).");
                                        System.out.println("3.)Order π Charms. $50.00 per charm.");
                                        System.out.println("4.)Check Out");
                                        System.out.println("What would you like to order? Type in the order number.");//Third question
                                    
                                        z=1;
                                        y=1;
                                    }
                                }
                                else{
                                    System.out.println("Invalid input--enter again.");
                                    input.next();
                                }
                             }
                            }  
                         if(in.equalsIgnoreCase("pe")){//calculating price of pepporoni pizza
                               
                              int z=0;
                             while(z==0){
                                System.out.println("How many pepperoni pizzas do you want?");
                                
                                
                                if(input.hasNextInt()){
                                    sliceNumber = input.nextInt();
                                    
                                 if(sliceNumber>=0){ 
                                    //calculating price
                                    tempPrice = sliceNumber * 12.00;
                                    pepPrice = price + tempPrice;
                                    tempPrice=0.00;
                                    
                                    pepSliceCount=sliceNumber+pepSliceCount;
                                    
                                    System.out.println("\n");
                                    System.out.println("1.)Order Pizza. Plain $10.00. pepperoni $12.00");
                                    System.out.println("2.)Order Cherry Pies. Sold only in slices, $2.00 per slice. 6 slices=whole pie($10.00).");
                                    System.out.println("3.)Order π Charms. $50.00 per charm.");
                                    System.out.println("4.)Check Out");
                                    System.out.println("What would you like to order? Type in the order number.");//Third question
                                    
                                    z=1;
                                    y=1;
                                 }
                  
                                }
                              
                                else{//for if wrong input is entered
                                   System.out.println("Invalid input--enter again.");
                                    input.next();
                               }
                            }
                                
                         }
                   }   
                   
                           
             
         }

                  
                  //pie ordering
                   if(in.equalsIgnoreCase("2")){//pies
                       
                       int y=0;
                       while(y==0){
                           
                           System.out.println("How many pie slices do you want?");
                           
                           
                           
                           if(input.hasNextInt()){
                               
                               slices = input.nextInt();
                                  
                               
                            if(slices>=0){ 
                                
                               if(slices%6==0){ //for whole pie
                                        
                                        //calculating price
                                        tempPrice = (slices/6)*10.00;
                                        piePrice = price + tempPrice;
                                        tempPrice=0.00;
                                        
                                        sliceCount=slices+sliceCount;
                                        
                                        System.out.println("\n");
                                        System.out.println("1.)Order Pizza. Plain $10.00. pepperoni $12.00");
                                        System.out.println("2.)Order Cherry Pies. Sold only in slices, $2.00 per slice. 6 slices=whole pie($10.00).");
                                        System.out.println("3.)Order π Charms. $50.00 per charm.");
                                        System.out.println("4.)Check Out");
                                        System.out.println("What would you like to order? Type in the order number.");//Third question
                                        
                                        y=1;
                                        
                                    }
                               if(slices%6!=0){//for when they dont order exact number for whole pies 
                                        //calculating price
                                   if(slices>=6){
                                        tempPrice = ((slices/6)*10.00)+((slices%6)*2.00);
                                        piePrice = price + tempPrice;
                                        tempPrice=0.00;
                                        
                                        sliceCount=slices+sliceCount;
                                        
                                        System.out.println("\n");
                                        System.out.println("1.)Order Pizza. Plain $10.00. pepperoni $12.00");
                                        System.out.println("2.)Order Cherry Pies. Sold only in slices, $2.00 per slice. 6 slices=whole pie($10.00).");
                                        System.out.println("3.)Order π Charms. $50.00 per charm.");
                                        System.out.println("4.)Check Out");
                                        System.out.println("What would you like to order? Type in the order number.");//Third question
                    
                                        y=1;
                                   }
                                   else{
                                   
                                   //calculating price
                                    tempPrice = slices * 2.00;
                                    piePrice = price + tempPrice;
                                    tempPrice=0.00;
                                    
                                    sliceCount=slices+sliceCount;
                                    
                                    System.out.println("\n");
                                    System.out.println("1.)Order Pizza. Plain $10.00. pepperoni $12.00");
                                    System.out.println("2.)Order Cherry Pies. Sold only in slices, $2.00 per slice. 6 slices=whole pie($10.00).");
                                    System.out.println("3.)Order π Charms. $50.00 per charm.");
                                    System.out.println("4.)Check Out");
                                    System.out.println("What would you like to order? Type in the order number.");//Third question
                                   
                                    y=1;
                               }
                        
                                
                              }
                               if(slices == 0){
                                   //calculating price
                                        tempPrice = 0.00;
                                        piePrice = price + tempPrice;
                                        tempPrice=0.00;
                                        
                                        System.out.println("\n");
                                        System.out.println("1.)Order Pizza. Plain $10.00. pepperoni $12.00");
                                        System.out.println("2.)Order Cherry Pies. Sold only in slices, $2.00 per slice. 6 slices=whole pie($10.00).");
                                        System.out.println("3.)Order π Charms. $50.00 per charm.");
                                        System.out.println("4.)Check Out");
                                        System.out.println("What would you like to order? Type in the order number.");//Third question
                                        
                                        
                                        y=1;
                               }
                               
                           }
                       }
                           else{
                               System.out.println("Invalid input--enter again.");
                                    input.next();
                           }
                           
                       }
                       
                   }
                           
                           
                       
                       
                   
                   
                   
                   
                   //charms ordering
                   if(in.equalsIgnoreCase("3")){//π charms
                         
                       int t=0;
                       while(t==0){
                           
                           System.out.println("How many π Charms do you want?");
                           
                           
                           
                           if(input.hasNextInt()){
                               
                               charms = input.nextInt();
                               
                             if(charms>=0){
                                    //calculating price
                                    tempPrice = charms * 50.00;
                                    charmPrice = price + tempPrice;
                                    tempPrice=0.00;
                                    
                                    charmCount=charms+charmCount;
                                     
                                     
                                     System.out.println("\n");
                                     System.out.println("1.)Order Pizza. Plain $10.00. Pepperoni $12.00");
                                     System.out.println("2.)Order Cherry Pies. Sold only in slices, $2.00 per slice. 6 slices=whole pie($10.00).");
                                     System.out.println("3.)Order π Charms. $50.00 per charm.");
                                     System.out.println("4.)Check Out");
                                     System.out.println("What would you like to order? Type in the order number.");//Third question
                                    
                                    t=1;
                               }
                           }
                           else{
                               System.out.println("Invalid input--enter again.");
                                    input.next();
                           }
                           
                       }
                       
                   
                       }
                   
                   
                   //checking out
                   if(in.equalsIgnoreCase("4")){//checking out 
                       
                       //formatting decimals 
                       NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
                       
                        String order =sliceNumberCount+" plain pizza(s), "+pepSliceCount+" pepperoni pizza(s), "+sliceCount+" slice(s) of cherry pie, and "+charmCount+" π Charms.";
                        System.out.println(order);
                        System.out.println("\n");
                        
                        System.out.println("Would you like to cancel your order or no? Enter in a number.");
                        System.out.println("1.) Cancel my whole order.");
                        System.out.println("2.) Cancel my plain pizza orders.");
                        System.out.println("3.) Cancel my pepperoni pizza orders.");
                        System.out.println("4.) Cancel my cherry pie orders.");
                        System.out.println("5.)Cancel my π Charm orders.");
                        System.out.println("6.) My order is good. Continue to check out.");
                        
                         
                         int f=0;
                         while(f==0){
                             
                       
                             
                             String can = input.nextLine();
                             
                             if(can.equalsIgnoreCase("1")){
                                 
                                 price=0.00;
                                 pizzaPrice=0.00;
                                 pepPrice=0.00;
                                 piePrice=0.00;
                                 charmPrice=0.00;
                                 
                                 System.out.println("Order has been canceled");
                                 System.out.println("You owe: "+formatter.format(price));
                             
                                 f=1;
                                 
                             }
                             if(can.equalsIgnoreCase("2")){
                                 System.out.println(order);
                                 System.out.println("How many plain do you want to get rid of?");
                                 
                                 int o=0;
                               while(o==0){ 
                                   
                                if(input.hasNextInt()){
                                    
                                    int cans = input.nextInt();
                                      
                                        if(cans<=sliceNumberCount){
                                            System.out.println("Cancel made.");
                                            //price=(price-(pizzaPrice*cans));
                                            sliceNumberCount=sliceNumberCount-cans;
                                            pizzaPrice=sliceNumberCount*10.00;
                                            price = pizzaPrice+pepPrice+piePrice+charmPrice;
                                            
                                            order =sliceNumberCount+" plain pizza(s), "+pepSliceCount+" pepperoni pizza(s), "+sliceCount+" slice(s) of cherry pie, and "+charmCount+" π Charms.";
                                            System.out.println(order);
                                             System.out.println("\n");
                                             System.out.println("Would you like to cancel your order or no? Enter in a number.");
                                             System.out.println("1.) Cancel my whole order.");
                                             System.out.println("2.) Cancel my plain pizza orders.");
                                             System.out.println("3.) Cancel my pepperoni pizza orders.");
                                             System.out.println("4.) Cancel my cherry pie orders.");
                                             System.out.println("5.)Cancel my π Charm orders.");
                                             System.out.println("6.) My order is good. Continue to check out.");
                                            
                                            o=1;
                                            
                                          
                                            
                                 }
                                 else{
                                 	 System.out.println("Invalid input--enter again.");
                                    input.next();
                                 }
                                
                                }
                                else{
                                     System.out.println("Invalid input--enter again.");
                                    input.next();
                                 }
                             }
                           }
                             if(can.equalsIgnoreCase("3")){
                                  System.out.println(order);
                                 System.out.println("How many pepperoni do you want to get rid of?");
                                 
                                 int o=0;
                               while(o==0){ 
                                
                                if(input.hasNextInt()){
                                    
                                    int cans = input.nextInt();
                                      
                                        if(cans<=pepSliceCount){
                                            System.out.println("Cancel made.");
                                            //price=(price-(pizzaPrice*cans));
                                            pepSliceCount=pepSliceCount-cans;
                                            pepPrice=pepSliceCount*12.00;
                                            price = pizzaPrice+pepPrice+piePrice+charmPrice;
                                            
                                             order =sliceNumberCount+" plain pizza(s), "+pepSliceCount+" pepperoni pizza(s), "+sliceCount+" slice(s) of cherry pie, and "+charmCount+" π Charms.";
                                             System.out.println(order);
                                             System.out.println("\n");
                                             System.out.println("Would you like to cancel your order or no? Enter in a number.");
                                             System.out.println("1.) Cancel my whole order.");
                                             System.out.println("2.) Cancel my plain pizza orders.");
                                             System.out.println("3.) Cancel my pepperoni pizza orders.");
                                             System.out.println("4.) Cancel my cherry pie orders.");
                                             System.out.println("5.)Cancel my π Charm orders.");
                                             System.out.println("6.) My order is good. Continue to check out.");
                                            
                                            o=1;
                                            
                                            
                                 }
                                 else{
                                     System.out.println("Invalid input--enter again.");
                                    input.next();
                                 }
                                }
                                 else{
                                     System.out.println("Invalid input--enter again.");
                                    input.next();  
                                    
                                 }
                             }
                             }
                             if(can.equalsIgnoreCase("4")){
                                 System.out.println(order);
                                 System.out.println("How many cherry pies do you want to get rid of?");
                                 
                                         int o=0;   
                                          while(o==0){ 
                                            
                                            if(input.hasNextInt()){
                                                
                                                 int cans = input.nextInt();
                                      
                                                if(cans<=sliceCount){
                                                    System.out.println("Cancel made.");
                                                    //price=(price-(pizzaPrice*cans));
                                                    sliceCount=sliceCount-cans;
                                                    int temp = sliceCount;
                                                    
                                                         
                               if(sliceCount%6==0){ //for whole pie
                                        
                                        //calculating price
                                        piePrice = (sliceCount/6.00)*10.00;
                                       
                                        
                                        price = pizzaPrice+pepPrice+piePrice+charmPrice;
                                         
                                         order =sliceNumberCount+" plain pizza(s), "+pepSliceCount+" pepperoni pizza(s), "+sliceCount+" slice(s) of cherry pie, and "+charmCount+" π Charms.";
                                         System.out.println(order);
                                         System.out.println("\n");
                                         System.out.println("Would you like to cancel your order or no? Enter in a number.");
                                         System.out.println("1.) Cancel my whole order.");
                                         System.out.println("2.) Cancel my plain pizza orders.");
                                         System.out.println("3.) Cancel my pepperoni pizza orders.");
                                         System.out.println("4.) Cancel my cherry pie orders.");
                                         System.out.println("5.)Cancel my π Charm orders.");
                                         System.out.println("6.) My order is good. Continue to check out.");
                                        
                                        o=1;
                                        
                                        
                                        
                                    }
                               if(sliceCount%6!=0){//for when they dont order exact number for whole pies 
                                        //calculating price
                                   if(sliceCount>=6){
                                        piePrice = ((sliceCount/6)*10.00)+((slices%6)*2.00);
                                       
                                        
                                        price = pizzaPrice+pepPrice+piePrice+charmPrice;
                                        
                                         order =sliceNumberCount+" plain pizza(s), "+pepSliceCount+" pepperoni pizza(s), "+sliceCount+" slice(s) of cherry pie, and "+charmCount+" π Charms.";
                                         System.out.println(order);
                                         System.out.println("\n");
                                         System.out.println("Would you like to cancel your order or no? Enter in a number.");
                                         System.out.println("1.) Cancel my whole order.");
                                         System.out.println("2.) Cancel my plain pizza orders.");
                                         System.out.println("3.) Cancel my pepperoni pizza orders.");
                                         System.out.println("4.) Cancel my cherry pie orders.");
                                         System.out.println("5.)Cancel my π Charm orders.");
                                         System.out.println("6.) My order is good. Continue to check out.");
                                        
                                        o=1;
                                        
                                        
                                   }
                                   else{
                                   
                                   //calculating price
                                    piePrice = sliceCount * 2.00;
                                  
                                   
                                    price = pizzaPrice+pepPrice+piePrice+charmPrice;
                                     
                                     order =sliceNumberCount+" plain pizza(s), "+pepSliceCount+" pepperoni pizza(s), "+sliceCount+" slice(s) of cherry pie, and "+charmCount+" π Charms.";
                                     System.out.println(order);
                                     System.out.println("\n");
                                     System.out.println("Would you like to cancel your order or no? Enter in a number.");
                                     System.out.println("1.) Cancel my whole order.");
                                     System.out.println("2.) Cancel my plain pizza orders.");
                                     System.out.println("3.) Cancel my pepperoni pizza orders.");
                                     System.out.println("4.) Cancel my cherry pie orders.");
                                     System.out.println("5.)Cancel my π Charm orders.");
                                     System.out.println("6.) My order is good. Continue to check out.");
                                    
                                    o=1;
                                    
                                    
                               }
                        
                                
                              }
                               if(sliceCount == 0){
                                   //calculating price
                                        piePrice = 0.00;
                                       
                                        
                                        price = pizzaPrice+pepPrice+piePrice+charmPrice;
                                         
                                         order =sliceNumberCount+" plain pizza(s), "+pepSliceCount+" pepperoni pizza(s), "+sliceCount+" slice(s) of cherry pie, and "+charmCount+" π Charms.";
                                         System.out.println(order);
                                         System.out.println("\n");
                                         System.out.println("Would you like to cancel your order or no? Enter in a number.");
                                         System.out.println("1.) Cancel my whole order.");
                                         System.out.println("2.) Cancel my plain pizza orders.");
                                         System.out.println("3.) Cancel my pepperoni pizza orders.");
                                         System.out.println("4.) Cancel my cherry pie orders.");
                                         System.out.println("5.)Cancel my π Charm orders.");
                                         System.out.println("6.) My order is good. Continue to check out.");
                                        
                                        o=1;
                                        
                                        
                               }
                                                    
                                                    
                                 }
                                 else{
                                     System.out.println("Invalid input--enter again.");
                                    input.next();
                                 }
                                }
                                else{
                                     System.out.println("Invalid input--enter again.");
                                    input.next();
                                 }
                             }
                           }
                             
                             
                             //cancelling charms
                             if(can.equalsIgnoreCase("5")){
                                 System.out.println(order);
                                 System.out.println("How many charms do you want to get rid of?");
                                int o=0;
                                while(o==0){
                                    
                                     
                                    
                                 if(input.hasNextInt()){
                                     
                                        int cans = input.nextInt();
                                 
                                     if(cans<=charmCount){
                                         charmCount=charmCount-cans;
                                         
                                         charmPrice=charmCount*50.00;
                                          
                                          order =sliceNumberCount+" plain pizza(s), "+pepSliceCount+" pepperoni pizza(s), "+sliceCount+" slice(s) of cherry pie, and "+charmCount+" π Charms.";
                                          System.out.println(order);
                                          System.out.println("\n");
                                          System.out.println("Would you like to cancel your order or no? Enter in a number.");
                                          System.out.println("1.) Cancel my whole order.");
                                          System.out.println("2.) Cancel my plain pizza orders.");
                                          System.out.println("3.) Cancel my pepperoni pizza orders.");
                                          System.out.println("4.) Cancel my cherry pie orders.");
                                          System.out.println("5.)Cancel my π Charm orders.");
                                          System.out.println("6.) My order is good. Continue to check out.");
                                         
                                         o=1;
                                         
                                         
                                     }
                                      else{
                                 	 	System.out.println("Invalid input--enter again.");
                                    	input.next();
                                 	}
                                 }
                                  else{
                                     	System.out.println("Invalid input--enter again.");
                                    	input.next();
                                 	}
                                
                                }
                             }
                             
                             //final order price
                             if(can.equalsIgnoreCase("6")|| can.equals("6")){//for making payments
                                 
                                 price = pizzaPrice+pepPrice+piePrice+charmPrice;//get teh price without tax
                                 
                                 System.out.println("\n");
                                 
                                 order =sliceNumberCount+" plain pizza(s), "+pepSliceCount+" pepperoni pizza(s), "+sliceCount+" slice(s) of cherry pie, and "+charmCount+" π Charms.";
                                 System.out.println(order);
                         
                                System.out.println("Price:     "+ formatter.format(price));
                                System.out.println("Tax:       "+("+"+formatter.format(price*0.07)));
                         
                                //Full price
                                price = price+(price*0.07);
                                System.out.println("Total:       "+formatter.format(price));
                                 
                                
                                //asking customer to pay 
                                System.out.println("Please pay her. Enter in how much you would like to pay.");
                                
                                int p=0;
                                while(p==0){
                                
                                if(input.hasNextDouble()){
                                    
                                        double paying = input.nextDouble();
                                    
                                    if(paying>=price){
                                        double change = paying - price;
                                        System.out.println("Thank you for your order!");
                                        System.out.println("Your change is "+formatter.format(change));
                                        f=1;
                                        p=1;
                                       
                                    }
                                    else{
                                        System.out.println("Invalid input--enter again.");
                                        input.next();
                                    }
                                }
                                else{
                                   System.out.println("Invalid input--enter again.");
                                        input.next(); 
                                }
                             }
                                
                                
                                
                             }
                            
                             
                             //f=1;
                  
                         }
                         
                         
                         x=1;
                         
                         //MAKE SURE TO ADD IN TAXES AND FIX DECIMALS. 
                         //ALSO MAKE SURE TO PRINT BILL WITH TAXES INCLUDED
                         //ALSO MAKE SURE THEY CAN CANEL THE ORDER HERE. 
                   }
                   
                   else{
                           
                   }
            
        
    
    
    } 
    
 }
    
    //Pie Card Discount Method
    public static void QuestionThreeDiscount(){
        
               //Setting up scanner
        Scanner input = new Scanner(System.in);
        
        int x=0;
        int sliceNumber=0;
        int sliceNumberCount=0;//to count number of plain pizzas
        int pepSliceCount=0;//to count the number of pepperoni pizza slices
        int slices=0;
        int sliceCount=0;//to count the number of pie slices
        int charms=0;
        int charmCount=0;//to count the number of charms 
        double price=0.00; //for calculating the price
        double tempPrice=0.00;
        
        double pizzaPrice=0.00;
        double pepPrice=0.00;
        double piePrice=0.00;
        double charmPrice=0.00;
        
             System.out.println("\n");
             System.out.println("1.)Order Pizza. Plain $10.00. pepperoni $10.00");
             System.out.println("2.)Order Cherry Pies. Sold only in slices, $1.75 per slice. 6 slices=whole pie($8.00).");
             System.out.println("3.)Order π Charms. $50.00 per charm. 10% off each charm!");
             System.out.println("4.)Check Out");
             System.out.println("What would you like to order? Type in the order number.");//Third question
        
        while(x==0){
            
            

            
             String in = input.nextLine();  

                  if(in.equalsIgnoreCase("1")){//pizza
                      int y=0;
                      while(y==0){
                             
                           System.out.println("Do you want plain(enter in pl) or a pepperoni pizza(enter in pe)?");
                           in=input.nextLine();
                           
                            if(in.equalsIgnoreCase("pl")){//calculating price of plain pizza
                               
                              int z=0;
                             while(z==0){
                                System.out.println("How many plain pizzas do you want?");
                                
                                
                                if(input.hasNextInt()){
                                    sliceNumber = input.nextInt();
                                    
                                    if(sliceNumber>=0){
                                        //calculating price
                                        tempPrice = sliceNumber * 10.00;
                                        pizzaPrice = price + tempPrice;
                                        tempPrice=0.00;
                                    
                                        sliceNumberCount=sliceNumber+sliceNumberCount;
                                        
                                        System.out.println("\n");
                                        System.out.println("1.)Order Pizza. Plain $10.00. pepperoni $10.00");
                                        System.out.println("2.)Order Cherry Pies. Sold only in slices, $1.75 per slice. 6 slices=whole pie($8.00).");
                                        System.out.println("3.)Order π Charms. $50.00 per charm. 10% off each charm!");
                                        System.out.println("4.)Check Out");
                                        System.out.println("What would you like to order? Type in the order number.");//Third question
                                    
                                        z=1;
                                        y=1;
                                    }
                                }
                                else{
                                    System.out.println("Invalid input--enter again.");
                                    input.next();
                                }
                             }
                            }  
                         if(in.equalsIgnoreCase("pe")){//calculating price of pepporoni pizza
                               
                              int z=0;
                             while(z==0){
                                System.out.println("How many pepperoni pizzas do you want?");
                                
                                
                                if(input.hasNextInt()){
                                    sliceNumber = input.nextInt();
                                    
                                 if(sliceNumber>=0){ 
                                    //calculating price
                                    tempPrice = sliceNumber * 10.00;
                                    pepPrice = price + tempPrice;
                                    tempPrice=0.00;
                                    
                                    pepSliceCount=sliceNumber+pepSliceCount;
                                    
                                    System.out.println("\n");
                                    System.out.println("1.)Order Pizza. Plain $10.00. pepperoni $10.00");
                                    System.out.println("2.)Order Cherry Pies. Sold only in slices, $1.75 per slice. 6 slices=whole pie($8.00).");
                                    System.out.println("3.)Order π Charms. $50.00 per charm. 10% off each charm!");
                                    System.out.println("4.)Check Out");
                                    System.out.println("What would you like to order? Type in the order number.");//Third question
                                    
                                    z=1;
                                    y=1;
                                 }
                  
                                }
                              
                                else{//for if wrong input is entered
                                   System.out.println("Invalid input--enter again.");
                                    input.next();
                               }
                            }
                                
                         }
                   }   
                   
                           
             
         }

                  
                  //pie ordering
                   if(in.equalsIgnoreCase("2")){//pies
                       
                       int y=0;
                       while(y==0){
                           
                           System.out.println("How many pie slices do you want?");
                           
                           
                           
                           if(input.hasNextInt()){
                               
                               slices = input.nextInt();
                                  
                               
                            if(slices>=0){ 
                                
                               if(slices%6==0){ //for whole pie
                                        
                                        //calculating price
                                        tempPrice = (slices/6)*8.00;
                                        piePrice = price + tempPrice;
                                        tempPrice=0.00;
                                        
                                        sliceCount=slices+sliceCount;
                                        
                                        System.out.println("\n");
                                        System.out.println("1.)Order Pizza. Plain $10.00. pepperoni $10.00");
                                        System.out.println("2.)Order Cherry Pies. Sold only in slices, $1.75 per slice. 6 slices=whole pie($8.00).");
                                        System.out.println("3.)Order π Charms. $50.00 per charm. 10% off each charm!");
                                        System.out.println("4.)Check Out");
                                        System.out.println("What would you like to order? Type in the order number.");//Third question
                                        
                                        y=1;
                                        
                                    }
                               if(slices%6!=0){//for when they dont order exact number for whole pies 
                                        //calculating price
                                   if(slices>=6){
                                        tempPrice = ((slices/6)*8.00)+((slices%6)*1.75);
                                        piePrice = price + tempPrice;
                                        tempPrice=0.00;
                                        
                                        sliceCount=slices+sliceCount;
                                        
                                        System.out.println("\n");
                                        System.out.println("1.)Order Pizza. Plain $10.00. pepperoni $10.00");
                                        System.out.println("2.)Order Cherry Pies. Sold only in slices, $1.75 per slice. 6 slices=whole pie($8.00).");
                                        System.out.println("3.)Order π Charms. $50.00 per charm. 10% off each charm!");
                                        System.out.println("4.)Check Out");
                                        System.out.println("What would you like to order? Type in the order number.");//Third question
                    
                                        y=1;
                                   }
                                   else{
                                   
                                   //calculating price
                                    tempPrice = slices * 1.75;
                                    piePrice = price + tempPrice;
                                    tempPrice=0.00;
                                    
                                    sliceCount=slices+sliceCount;
                                    
                                    System.out.println("\n");
                                    System.out.println("1.)Order Pizza. Plain $10.00. pepperoni $10.00");
                                    System.out.println("2.)Order Cherry Pies. Sold only in slices, $1.75 per slice. 6 slices=whole pie($8.00).");
                                    System.out.println("3.)Order π Charms. $50.00 per charm. 10% off each charm!");
                                    System.out.println("4.)Check Out");
                                    System.out.println("What would you like to order? Type in the order number.");//Third question
                                   
                                    y=1;
                               }
                        
                                
                              }
                               if(slices == 0){
                                   //calculating price
                                        tempPrice = 0.00;
                                        piePrice = price + tempPrice;
                                        tempPrice=0.00;
                                        
                                        System.out.println("\n");
                                        System.out.println("1.)Order Pizza. Plain $10.00. pepperoni $10.00");
                                        System.out.println("2.)Order Cherry Pies. Sold only in slices, $1.75 per slice. 6 slices=whole pie($8.00).");
                                        System.out.println("3.)Order π Charms. $50.00 per charm.");
                                        System.out.println("4.)Check Out");
                                        System.out.println("What would you like to order? Type in the order number.");//Third question
                                        
                                        
                                        y=1;
                               }
                               
                           }
                       }
                           else{
                               System.out.println("Invalid input--enter again.");
                                    input.next();
                           }
                           
                       }
                       
                   }
                           
                           
                       
                       
                   
                   
                   
                   
                   //charms ordering
                   if(in.equalsIgnoreCase("3")){//π charms
                         
                       int t=0;
                       while(t==0){
                           
                           System.out.println("How many π Charms do you want?");
                           
                           
                           
                           if(input.hasNextInt()){
                               
                               charms = input.nextInt();
                               
                             if(charms>=0){
                                    //calculating price
                                    tempPrice = charms * 50.00;
                                    tempPrice = tempPrice-(tempPrice*0.10);
                                    charmPrice = price + tempPrice;
                                    tempPrice=0.00;
                                    
                                    charmCount=charms+charmCount;
                                    
                                     System.out.println("\n");
                                     System.out.println("1.)Order Pizza. Plain $10.00. pepperoni $10.00");
                                     System.out.println("2.)Order Cherry Pies. Sold only in slices, $1.75 per slice. 6 slices=whole pie($8.00).");
                                     System.out.println("3.)Order π Charms. $50.00 per charm. 10% off each charm!");
                                     System.out.println("4.)Check Out");
                                     System.out.println("What would you like to order? Type in the order number.");//Third question
                                    
                                    t=1;
                               }
                           }
                           else{
                               System.out.println("Invalid input--enter again.");
                                    input.next();
                           }
                           
                       }
                       
                   
                       }
                   
                   
                   //checking out
                   if(in.equalsIgnoreCase("4")){//checking out 
                       
                       //formatting decimals 
                       NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
                       
                        String order =sliceNumberCount+" plain pizza(s), "+pepSliceCount+" pepperoni pizza(s), "+sliceCount+" slice(s) of cherry pie, and "+charmCount+" π Charms.";
                        System.out.println(order);
                        System.out.println("\n");
                        
                        System.out.println("Would you like to cancel your order or no? Enter in a number.");
                        System.out.println("1.) Cancel my whole order.");
                        System.out.println("2.) Cancel my plain pizza orders.");
                        System.out.println("3.) Cancel my pepperoni pizza orders.");
                        System.out.println("4.) Cancel my cherry pie orders.");
                        System.out.println("5.)Cancel my π Charm orders.");
                        System.out.println("6.) My order is good. Continue to check out.");
                        
                         
                         int f=0;
                         while(f==0){
                             
                       
                             
                             String can = input.nextLine();
                             
                             if(can.equalsIgnoreCase("1")){
                                 
                                 price=0.00;
                                 pizzaPrice=0.00;
                                 pepPrice=0.00;
                                 piePrice=0.00;
                                 charmPrice=0.00;
                                 System.out.println("Order has been canceled");
                                 System.out.println("You owe: "+formatter.format(price));
                                 
                                 f=1;
                                 
                             }
                             if(can.equalsIgnoreCase("2")){
                                 System.out.println(order);
                                 System.out.println("How many plain do you want to get rid of?");
                                 
                                 int o=0;
                               while(o==0){  
                                   
                                if(input.hasNextInt()){
                                    
                                     int cans = input.nextInt();
                                      
                                        if(cans<=sliceNumberCount){
                                            System.out.println("Cancel made.");
                                            //price=(price-(pizzaPrice*cans));
                                            sliceNumberCount=sliceNumberCount-cans;
                                            pizzaPrice=sliceNumberCount*10.00;
                                            price = pizzaPrice+pepPrice+piePrice+charmPrice;
                                            
                                             order =sliceNumberCount+" plain pizza(s), "+pepSliceCount+" pepperoni pizza(s), "+sliceCount+" slice(s) of cherry pie, and "+charmCount+" π Charms.";
                                            System.out.println(order);
                                             System.out.println("\n");
                                             System.out.println("Would you like to cancel your order or no? Enter in a number.");
                                             System.out.println("1.) Cancel my whole order.");
                                             System.out.println("2.) Cancel my plain pizza orders.");
                                             System.out.println("3.) Cancel my pepperoni pizza orders.");
                                             System.out.println("4.) Cancel my cherry pie orders.");
                                             System.out.println("5.)Cancel my π Charm orders.");
                                             System.out.println("6.) My order is good. Continue to check out.");
                                            
                                            o=1;
                                            
                                          
                                            
                                 }
                                  else{
                                 	 System.out.println("Invalid input--enter again.");
                                    input.next();
                                 }
                                 
                                }
                                 else{
                                     System.out.println("Invalid input--enter again.");
                                    input.next();
                                 }
                             }
                           }
                             if(can.equalsIgnoreCase("3")){
                                  System.out.println(order);
                                 System.out.println("How many pepperoni do you want to get rid of?");
                                 
                                 int o=0;
                               while(o==0){
                                   
                                if(input.hasNextInt()){
                                    
                                        int cans = input.nextInt();
                                    
                                        if(cans<=pepSliceCount){
                                            System.out.println("Cancel made.");
                                            //price=(price-(pizzaPrice*cans));
                                            pepSliceCount=pepSliceCount-cans;
                                            pepPrice=pepSliceCount*10.00;
                                            price = pizzaPrice+pepPrice+piePrice+charmPrice;
                                            
                                             order =sliceNumberCount+" plain pizza(s), "+pepSliceCount+" pepperoni pizza(s), "+sliceCount+" slice(s) of cherry pie, and "+charmCount+" π Charms.";
                                            System.out.println(order);
                                             System.out.println("\n");
                                             System.out.println("Would you like to cancel your order or no? Enter in a number.");
                                             System.out.println("1.) Cancel my whole order.");
                                             System.out.println("2.) Cancel my plain pizza orders.");
                                             System.out.println("3.) Cancel my pepperoni pizza orders.");
                                             System.out.println("4.) Cancel my cherry pie orders.");
                                             System.out.println("5.)Cancel my π Charm orders.");
                                             System.out.println("6.) My order is good. Continue to check out.");
                                            
                                            o=1;
                                            
                                            
                                 }
                                  else{
                                 	 System.out.println("Invalid input--enter again.");
                                    input.next();
                                 }
                                
                                }
                                 else{
                                     System.out.println("Invalid input--enter again.");
                                    input.next();
                                 }
                             }
                             }
                             if(can.equalsIgnoreCase("4")){
                                 System.out.println(order);
                                 System.out.println("How many cherry pies do you want to get rid of?");
                                 
                                           int o=0;
                                          while(o==0){ 
                                                
                                             if(input.hasNextInt()){
                                                 
                                                 int cans = input.nextInt();
                                      
                                                if(cans<=sliceCount){
                                                    System.out.println("Cancel made.");
                                                    //price=(price-(pizzaPrice*cans));
                                                    sliceCount=sliceCount-cans;
                                                    int temp = sliceCount;
                                                    
                                                         
                               if(sliceCount%6==0){ //for whole pie
                                        
                                        //calculating price
                                        piePrice = (sliceCount/6.00)*8.00;
                                       
                                        
                                        price = pizzaPrice+pepPrice+piePrice+charmPrice;
                                         
                                         
                                         order =sliceNumberCount+" plain pizza(s), "+pepSliceCount+" pepperoni pizza(s), "+sliceCount+" slice(s) of cherry pie, and "+charmCount+" π Charms.";
                                         System.out.println(order);
                                         System.out.println("\n");
                                         System.out.println("Would you like to cancel your order or no? Enter in a number.");
                                         System.out.println("1.) Cancel my whole order.");
                                         System.out.println("2.) Cancel my plain pizza orders.");
                                         System.out.println("3.) Cancel my pepperoni pizza orders.");
                                         System.out.println("4.) Cancel my cherry pie orders.");
                                         System.out.println("5.)Cancel my π Charm orders.");
                                         System.out.println("6.) My order is good. Continue to check out.");
                                        
                                        o=1;
                                        
                                        
                                        
                                    }
                               if(sliceCount%6!=0){//for when they dont order exact number for whole pies 
                                        //calculating price
                                   if(sliceCount>=6){
                                        piePrice = ((sliceCount/6)*8.00)+((slices%6)*1.75);
                                       
                                        
                                        price = pizzaPrice+pepPrice+piePrice+charmPrice;
                                        
                                         
                                         order =sliceNumberCount+" plain pizza(s), "+pepSliceCount+" pepperoni pizza(s), "+sliceCount+" slice(s) of cherry pie, and "+charmCount+" π Charms.";
                                         System.out.println(order);
                                         System.out.println("\n");
                                         System.out.println("Would you like to cancel your order or no? Enter in a number.");
                                         System.out.println("1.) Cancel my whole order.");
                                         System.out.println("2.) Cancel my plain pizza orders.");
                                         System.out.println("3.) Cancel my pepperoni pizza orders.");
                                         System.out.println("4.) Cancel my cherry pie orders.");
                                         System.out.println("5.)Cancel my π Charm orders.");
                                         System.out.println("6.) My order is good. Continue to check out.");
                                        
                                        o=1;
                                        
                                        
                                   }
                                   else{
                                   
                                   //calculating price
                                    piePrice = sliceCount * 1.75;
                                  
                                   
                                    price = pizzaPrice+pepPrice+piePrice+charmPrice;
                                    
                                     
                                     order =sliceNumberCount+" plain pizza(s), "+pepSliceCount+" pepperoni pizza(s), "+sliceCount+" slice(s) of cherry pie, and "+charmCount+" π Charms.";
                                     System.out.println(order);
                                     System.out.println("\n");
                                     System.out.println("Would you like to cancel your order or no? Enter in a number.");
                                     System.out.println("1.) Cancel my whole order.");
                                     System.out.println("2.) Cancel my plain pizza orders.");
                                     System.out.println("3.) Cancel my pepperoni pizza orders.");
                                     System.out.println("4.) Cancel my cherry pie orders.");
                                     System.out.println("5.)Cancel my π Charm orders.");
                                     System.out.println("6.) My order is good. Continue to check out.");
                                    
                                    o=1;
                                    
                                    
                               }
                        
                                
                              }
                               if(sliceCount == 0){
                                   //calculating price
                                        piePrice = 0.00;
                                       
                                        
                                        price = pizzaPrice+pepPrice+piePrice+charmPrice;
                                        
                                         
                                         order =sliceNumberCount+" plain pizza(s), "+pepSliceCount+" pepperoni pizza(s), "+sliceCount+" slice(s) of cherry pie, and "+charmCount+" π Charms.";
                                         System.out.println(order);
                                         System.out.println("\n");
                                         System.out.println("Would you like to cancel your order or no? Enter in a number.");
                                         System.out.println("1.) Cancel my whole order.");
                                         System.out.println("2.) Cancel my plain pizza orders.");
                                         System.out.println("3.) Cancel my pepperoni pizza orders.");
                                         System.out.println("4.) Cancel my cherry pie orders.");
                                         System.out.println("5.)Cancel my π Charm orders.");
                                         System.out.println("6.) My order is good. Continue to check out.");
                                        
                                        o=1;
                                        
                                        
                               		}
                                                    
                                                    
                        		}
                        		else{
                                 	 	System.out.println("Invalid input--enter again.");
                                    	input.next();
                                 	}
                                 
                                }
                             else{
                                     System.out.println("Invalid input--enter again.");
                                    input.next();
                                 }
                             }
                           }
                             
                             
                             //cancelling charms
                             if(can.equalsIgnoreCase("5")){
                                 System.out.println(order);
                                 System.out.println("How many charms do you want to get rid of?");
                                int o=0;
                                while(o==0){
                                    
                                     
                                    
                                 if(input.hasNextInt()){
                                     
                                        int cans = input.nextInt();
                                 
                                     if(cans<=charmCount){
                                         charmCount=charmCount-cans;
                                         
                                         charmPrice=(charmCount*50.00)-(charmPrice*0.10);
                                         
                                          System.out.println("Cancel made.");
                                          order =sliceNumberCount+" plain pizza(s), "+pepSliceCount+" pepperoni pizza(s), "+sliceCount+" slice(s) of cherry pie, and "+charmCount+" π Charms.";
                                          System.out.println(order);
                                          System.out.println("\n");
                                          System.out.println("Would you like to cancel your order or no? Enter in a number.");
                                          System.out.println("1.) Cancel my whole order.");
                                          System.out.println("2.) Cancel my plain pizza orders.");
                                          System.out.println("3.) Cancel my pepperoni pizza orders.");
                                          System.out.println("4.) Cancel my cherry pie orders.");
                                          System.out.println("5.)Cancel my π Charm orders.");
                                          System.out.println("6.) My order is good. Continue to check out.");
                                         
                                         o=1;
                                         
                                         
                                     }
                                      else{
                                 	 	System.out.println("Invalid input--enter again.");
                                    	input.next();
                                 	}
                                 }
                                 else{
                                     System.out.println("Invalid input--enter again.");
                                    input.next();
                                 }
                                
                                }
                             }
                             
                             //final order price
                             if(can.equalsIgnoreCase("6")|| can.equals("6")){//for making payments
                             
                             	System.out.println("\n");
                                 
                                 price = pizzaPrice+pepPrice+piePrice+charmPrice;//get teh price without tax
                                 
                                                                 
                                
                                 
                                 System.out.println("\n");
                                 
                                 order =sliceNumberCount+" plain pizza(s), "+pepSliceCount+" pepperoni pizza(s), "+sliceCount+" slice(s) of cherry pie, and "+charmCount+" π Charms.";
                                 System.out.println(order);
                         		
                         		if(price>=100.00){
                                    
                                    System.out.println("You got 10% off!");
                                    price = price - (price*0.10);
                                    
                                } 
                         		
                                System.out.println("Price:     "+formatter.format(price));
                                System.out.println("Tax:       "+("+"+formatter.format(price*0.07)));
                         
                                
                                price = price+(price*0.07);
                                System.out.println("Total:       "+formatter.format(price));//full price
                                 
                                
                                //asking customer to pay 
                                System.out.println("Please pay her. Enter in how much you would like to pay.");
                                
                                int p=0;
                                while(p==0){
                                
                                if(input.hasNextDouble()){
                                    
                                        double paying = input.nextDouble();
                                    
                                    if(paying>=price){
                                        double change = paying - price;
                                        System.out.println("Thank you for your order!");
                                        System.out.println("Your change is "+formatter.format(change));
                                        f=1;
                                        p=1;
                                       
                                    }
                                    else{
                                        System.out.println("Invalid input--enter again.");
                                        input.next();
                                    }
                                }
                                else{
                                   System.out.println("Invalid input--enter again.");
                                        input.next(); 
                                }
                             }
                                
                                
                                
                             }
                            
                             
                             //f=1;
                  
                         }
                         
                         
                         x=1;
                         
                        
                   }
                   
                   else{
                           
                   }
            
        
    
    
    } 
    
       
    }
    
}
