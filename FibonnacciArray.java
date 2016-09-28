/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package fibonnacciarray;

import java.util.Random;

/**
 *
 * @author AntoninoFebbraro
 */
public class FibonnacciArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //callng method to make the array
        int [] array = getArray();
        
        //callling method for largest num in array
        int largest = getLargest(array);
        
        //calling sum method
        int sum=getSum(array);
        
        //the fibanocci sequence 
        double [] fib = getFib();
        
        //output calling method
        outPut(array, sum, fib, largest);
        
        //the new array 
         //calling method for swapping
         swapping(array,largest);
        
        
        
    }
   
    //array building method
    public static int [] getArray()
    {
        Random generator = new Random();
        
        final int size = 10;
        
        int [] array = new int [size];
        for(int x=0;x<10;x++)
        {
            int number = generator.nextInt(10);
            array[x]= number;
        }
        return array;
    }
    
    //output method
    static void outPut(int [] array, int sum, double []fib, int largest)
    {
        System.out.println("The array:\n");
        //displaying array
        for(int x=0;x<10;x++)
        {
            System.out.print(" "+ array[x]);
        }
        
        System.out.println();
        //largest output
        System.out.println("\nThe largest number in the array is "+ array[largest]);
        
        System.out.println();
        //dsplayig sum
        System.out.println("The sum of the array is "+ sum);
        
        System.out.println("\nThe Fibinocci Sequence for 20 spots:");
        //displaying fib
        for(int i=0;i<fib.length;i++)
        {
            System.out.println(fib[i]);
        }
    }
    
    //sum method
    public static int getSum(int [] array)
    {
        int sum = 0;
        
        for(int x=0;x<array.length;x++)
        {
            sum= sum +array[x];
            
        }
        return sum;
    }
    
    //fibbonnoci sequence array building 
    public static double [] getFib()
    {
        double [] fib = new double [20];
        fib[0] = 1;
        fib[1]=1;
        for (int x=2;x<fib.length;x++)
        {
            fib[x]=fib[x-2]+fib[x-1];
        }
        return fib;
    }
    
    //method for getting largest number
    public static int getLargest(int [] array)
    {
        int largest=array[0];
        int index=0;
            
            for(int i=0;i < array.length;i++)
            {
                if(array[i]> largest)
                {
                    largest= array[i];
                    index=i;
                }
            }
             return index;   
    }
    
    //swapping method
    public static void swapping (int [] array, int largest)//position of largest
    {
        int temp=array[0];
        array[0]= array[largest];
        array[largest]=temp;
        System.out.println("\nThe new array");
      for (int x=0;x<array.length;x++)
      {
          System.out.print(" "+ array[x]);
      }
    }
}
