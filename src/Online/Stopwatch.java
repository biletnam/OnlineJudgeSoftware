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
    static int t1=i1;
    static int t2=i2;
    public static class sec extends Thread{
        public synchronized void run()
        {
            while(true)
            {
                if(i1==0)
                {
                    i1=60;
                }
                i1--;
                //obj.setsec(i1);
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
    final static int tt=t1;
    public static class min extends Thread{
        int flag1=0; 
        
        public synchronized void run()
        {
            while(true)
            {
                if(i2==0)
                    i2=60;
                
                //System.out.println(i2);
                try {
                    if(flag1==0)
                    {
                    Thread.sleep(tt*1000);
                    flag1=1;
                    }
                    else
                    Thread.sleep(60000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Stopwatch.class.getName()).log(Level.SEVERE, null, ex);
                }
                i2--;
            }
        }
        
    }
    
    public static class hr extends Thread{
        int flag2=0;
        public synchronized void run()
        {
            while(true)
            {
                if(i3==0)
                    i3=60;
                //System.out.println(i3);
                try {
                    if(flag2==0)
                    {
                        Thread.sleep(t2*60000);
                        flag2=1;
                    }
                    else
                    Thread.sleep(3600000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Stopwatch.class.getName()).log(Level.SEVERE, null, ex);
                }
                i3--;
            }
        }
        
    }
    
}
