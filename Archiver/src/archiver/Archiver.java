/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archiver;

/**
 *
 * @author Karen
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archiver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("arqcompactado.zip");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
	}
        catch (IOException e) {
            e.printStackTrace();
	}
        // TODO code application logic here
    }
    
}
