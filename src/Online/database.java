package Online;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class database {
    public int cnt,c2;
    ResultSet rs;
    boolean f;
    public void opendb(String query,int flag)
    {
        try {
    
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.43.38:3306/judge","root","root");
            Statement smt = conn.createStatement();
            if(flag==0){
            smt.executeUpdate(query);
            }
            else if(flag==1){
            smt.executeQuery(query);
            rs =smt.executeQuery(query);     
            boolean f=rs.next();
            if(!f){
                cnt=0;
                JOptionPane.showMessageDialog(null,"user doesnt exist");
            }
            else{
                cnt=1;
            }
            }
            else if(flag==2){
                //Statement sm = conn.createStatement();
            smt.executeQuery(query);
            rs =smt.executeQuery(query);     
            f=rs.next();
            if(!f){
                c2=0;
                JOptionPane.showMessageDialog(null,"There are presently no live contests");
            }
            else{
                c2=1;
            }    
            }
            if(flag!=2)
            conn.close();            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error 1");
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
