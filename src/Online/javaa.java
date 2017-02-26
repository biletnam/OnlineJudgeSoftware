package Online;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Online.Login;
import java.io.FileReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sushant oberoi
 */
public class javaa {
    
    String path = "C:\\Users\\sushant oberoi\\Desktop\\OnlineJudge\\";
    String path2 = "";

    public void compile(String code) {
        try {
            String file = "", com = "";
            
                path2 = "C:\\Program Files\\Java\\jdk1.8.0_102\\bin\\";
                file = "code.java";
                com = "javac";
            
            PrintWriter writer = null;
            writer = new PrintWriter(path + file);
            writer.println(code);
            writer.close();
            ProcessBuilder p;
            p = new ProcessBuilder(com,file);
            p.directory(new File(path));
            p.redirectErrorStream(true);
            Process pp = p.start();
            InputStream is = pp.getInputStream();
            BufferedReader b = new BufferedReader(new InputStreamReader(is));
            String temp = "";
            String s = "";
            boolean val = true;
            while ((temp = b.readLine()) != null) {
                val = false;
                s += temp;

            }
            if(s!=null && s!="")
            JOptionPane.showMessageDialog(null, s);
            if (!val) {
                JOptionPane.showMessageDialog(null, "Compile error");
            } else {
                JOptionPane.showMessageDialog(null, "Compile success");
            }
            is.close();

        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    public void run(int idx) {
          String in1="input"+idx+".txt";
            String out1="output"+idx+".txt";
            String crout="correctoutput"+idx+".txt";
          
        System.out.println("Began Running...");
        ProcessBuilder p = new ProcessBuilder("java","code.class");
        p.directory(new File(path));
        p.redirectErrorStream(true);
        File in = new File(path + in1);
        File out = new File(path + out1);
        p.redirectInput(in);
        p.redirectOutput(out);
        try {
            Process pp = p.start();
            InputStream is = pp.getInputStream();
            BufferedReader b = new BufferedReader(new InputStreamReader(is));
            String temp;
            if (!pp.waitFor(3, TimeUnit.SECONDS)) {
                //System.out.println("TLEEEE\n");
                JOptionPane.showMessageDialog(null, "TLE");

            } else {
                int ecode = pp.exitValue();
                if (ecode != 0) {
                    System.out.println("Runtime Error!!\n");
                    JOptionPane.showMessageDialog(null, "RE");
                } else {
                    while ((temp = b.readLine()) != null) {
                        System.out.println(temp);
                    }
                }
            }
            pp.destroy();

        } catch (IOException e) {
            System.out.println("in execute() " + e);
        } catch (InterruptedException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void check(int idx) {
            String out1="output"+idx+".txt";
            String crout="correctoutput"+idx+".txt";
          
        System.out.println("BEGAN CHECKING OUTPUT\n");
        try {
            File in = new File(path + crout);
            File in1 = new File(path + out1);
            BufferedReader br1 = new BufferedReader(new FileReader(in));
            BufferedReader br2 = new BufferedReader(new FileReader(in1));
            String s = "", t = "", temp;

            while ((temp = br1.readLine()) != null) {
                s += temp.trim() + "\n";
            }
            while ((temp = br2.readLine()) != null) {
                t += temp.trim() + "\n";
            }
            if (s.equals(t)) {
                JOptionPane.showMessageDialog(null, "AC");
            } else {
                System.out.println("Isss Wrong herererer!");
                JOptionPane.showMessageDialog(null, "WA");
            }
        } catch (IOException e) {
            System.out.println("in checkOutput() : " + e);
        }
        //JOptionPane.showMessageDialog(null, "WA");;
    }

    
}
