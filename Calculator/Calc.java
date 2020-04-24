/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab2.pkg0;

/**
 *
 * @author Nada
 */
public class Calc {
    private static int x;
    private static int y;
   // private static char sign;
    Calc()
    {
        x=0;
        y=0;
    }

    public static int sum(String args[])
    {
            
      	char sign= args[1].charAt(0);

        
         x=Integer.parseInt(args[0]);	
         y=Integer.parseInt(args[2]);
        switch(sign)
        {
            case '+':
                return x+y;
            
            case '-' :
                return x-y;                
                        
            case '*' :
                return x*y;    
                
            case '/' :
                return x/y;   
                                                
        }        
        return -1;
    }
    
  public static int sum_op(String args[])
  {
      int i=0;
      int sum=0;
      int flag=0;
      char op;
    while(i<=args.length-1)  
    {
        op=args[i+1].charAt(0);
      switch(op)
        {
            case '+':
                if(flag==0)
                {
                    x=Integer.parseInt(args[i]);
                    y=Integer.parseInt(args[i+2]);
                    sum+=x+y;
                    
                    flag=1;
                    break;
                }
                else
                {
                    y=Integer.parseInt(args[i+2]);
                    sum+=y;
                    
                    
                }
               break;               
        }       
                
     i=i+2;   
     if(i>=args.length-1)break;
     
    }       
            
                                                
             
        return sum;
        
    }
  
    
}
