/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Online;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author sushant oberoi
 */
public class Readfile {

    public String read(String path) throws FileNotFoundException, IOException {
        String s="";
        BufferedReader br = null;
        FileReader fr = null;
        fr = new FileReader(path);
        br = new BufferedReader(fr);
        String sCurrentLine;
        while ((sCurrentLine = br.readLine()) != null) {
            s+=sCurrentLine;
            s+='\n';
        }
        return s;
    }
}
