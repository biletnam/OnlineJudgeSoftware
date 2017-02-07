package Online;

import java.util.logging.Level;
import java.util.logging.Logger;
import Online.Login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class Stopwatch{
    
    static int i1,i2,i3;
    Stopwatch(){
        
    }
    Stopwatch(int i1,int i2,int i3)
    {
        this.i1=i1;
        this.i2=i2;
        this.i3=i3;
    }
    
    public static class sec extends Thread{
        Login obj=new Login();
        public void run()
        {
            while(true)
            {
                if(i1==0)
                    i1=60;
                i1--;
                obj.setsec(i1);
         // Login.sec.setText(i1+"");
                //System.out.println(i1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Stopwatch.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
    }
    
    public static class min extends Thread{
        
        public void run()
        {
            while(true)
            {
                if(i2==0)
                    i2=60;
                //System.out.println(i2);
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Stopwatch.class.getName()).log(Level.SEVERE, null, ex);
                }
                i2--;
            }
        }
        
    }
    
    public static class hr extends Thread{
        
        public void run()
        {
            while(true)
            {
                if(i3==0)
                    i3=60;
                //System.out.println(i3);
                try {
                    Thread.sleep(3600000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Stopwatch.class.getName()).log(Level.SEVERE, null, ex);
                }
                i3--;
            }
        }
        
    }
    
}
