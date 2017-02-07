package Online;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class Clang {
    public void compile(String code,int type){
        try{
            
            String file="",com="";
            if(type==0)
            {
                file="code.c";
                com="gcc";
            }
            else
            {
               file="code.cpp";
               com="g++";
            }
            PrintWriter writer = null;
            writer=new PrintWriter("C:\\Users\\Asus\\Documents\\NetBeansProjects\\OnlineJudge\\"+file);
            writer.println(code);
            writer.close();
            ProcessBuilder p;
            p=new ProcessBuilder("C:\\Program Files (x86)\\Dev-Cpp\\MinGW64\\bin\\"+com,"C:\\Users\\Asus\\Documents\\NetBeansProjects\\OnlineJudge\\"+file,"-o","C:\\Users\\Asus\\Documents\\NetBeansProjects\\OnlineJudge\\code");
            p.directory(new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\OnlineJudge\\"));
            p.redirectErrorStream(true);
            Process pp=p.start();
            InputStream is=pp.getInputStream();
            BufferedReader b=new BufferedReader(new InputStreamReader(is));
            String temp="";
            boolean val=true;
            while((temp=b.readLine())!=null){
                val=false;
                
                break;
            }
            if(!val){
                   JOptionPane.showMessageDialog(null, "Compile error");
            }
            else{
                   JOptionPane.showMessageDialog(null, "Compile success");
            }
            is.close();
           
        }
        catch(Exception e){
            System.out.println("Exception occured");
        }
    }
    
    public void run()
    {
        System.out.println("Began Running...");
        ProcessBuilder p = new ProcessBuilder("C:\\Users\\Asus\\Documents\\NetBeansProjects\\OnlineJudge\\code");
        p.directory(new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\OnlineJudge\\"));
        p.redirectErrorStream(true);
        File in = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\OnlineJudge\\input.txt") ;
        File out = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\OnlineJudge\\output.txt") ;
        p.redirectInput(in) ;
        p.redirectOutput(out) ;
        try
        {
            Process pp = p.start();
            InputStream is = pp.getInputStream();
            BufferedReader b = new BufferedReader(new InputStreamReader(is));
            String temp; 
            if( !pp.waitFor(1, TimeUnit.SECONDS))
            {
                //System.out.println("TLEEEE\n");
                JOptionPane.showMessageDialog(null, "TLE");
                 
            }
            else{
            int ecode = pp.exitValue();
            if(ecode != 0 )
            {
                System.out.println("Runtime Error!!\n");
                JOptionPane.showMessageDialog(null, "RE");
            }
            else{
            while((temp = b.readLine()) != null )
            {
                System.out.println(temp);
            } 
            }
            }
            pp.destroy();
            
           
            
        }
        catch(IOException e)
        {
            System.out.println("in execute() " + e );
        } catch (InterruptedException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void check()
    {
         System.out.println("BEGAN CHECKING OUTPUT\n");
        try
        {
            File in = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\OnlineJudge\\corroutput.txt");
            File in1 = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\OnlineJudge\\output.txt");
            BufferedReader br1 = new BufferedReader(new FileReader(in));
            BufferedReader br2 = new BufferedReader(new FileReader(in1));
            String s="" , t="" , temp ;
            
            while((temp = br1.readLine()) != null )
            {
                s += temp.trim() + "\n" ;
            }
            while((temp = br2.readLine()) != null )
            {
                t += temp.trim() + "\n" ;
            }
            if( s.equals(t) )
            {
                JOptionPane.showMessageDialog(null, "AC");
            }
            else
            {
                System.out.println("Isss Wrong herererer!");
                JOptionPane.showMessageDialog(null, "WA");
            }
        }
        catch(IOException e)
        {
            System.out.println("in checkOutput() : " +  e);
        }
        //JOptionPane.showMessageDialog(null, "WA");;
    }
    }

