package Online;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
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
public class Request {
    public static int flag;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    public int start(){
        try {     
            s=new Socket("192.168.43.38",6666);
            din=new DataInputStream(s.getInputStream());
            dout= new DataOutputStream(s.getOutputStream());
            return 1;
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(null, "Server Down !!");
             return 0;
           // Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cont(){
        String str = null;
        try {
            str = din.readUTF();
            
            System.out.println(str+"");
            if(str.equals("accepted")){
                flag=1;
            }
            else{
                flag=0;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "First turn on the server !!");
            Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
