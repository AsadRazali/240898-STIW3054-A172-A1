package com.mycompany.rtpa1;

public class A1 implements readwrite,github{
    
    
    public void run()
    {
       
        readwrite.run();
        github.githubpush();
    }
    
    
      public static void main(String[] args) {
          
          A1 obj = new A1();
          obj.run();
        
    }

  
}
