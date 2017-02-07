/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Online;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author sushant oberoi
 */
public class Readpdf {
    public String read(String path) throws FileNotFoundException, IOException{
        String str="";
        PdfManager obj = new PdfManager();
        obj.setFilePath(path);
        str+=obj.ToText();
        return str;
    }
}
