package Online;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class Class_Server {
        static DataOutputStream dout;
        static DataInputStream din;
    Class_Server()
    {
        try {
            ServerSocket ss = new ServerSocket(6666);
            Socket s =new Socket();
            s = ss.accept();
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("accepted");
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(Class_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    
}
