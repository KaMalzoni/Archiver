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

import java.util.Scanner;
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Please insert the number of files to be compressed");
        Integer nmbf = new Integer (sc.nextLine());
        String [] files = new String [nmbf]; 
        //System.out.println("Please insert the name of the file to be compressed");
        //File fname = new File (sc.nextLine());
        for (int i = 0; i < files.length; i++){
            System.out.println("Please insert the name of the file to be compressed");
            File fname = new File (sc.nextLine());
            files[i] = fname.toString();
        }
        try {
            FileOutputStream fos = new FileOutputStream("arqcompactado.zip");
            //ZipOutputStream zos = new ZipOutputStream(fos);
            for (int i = 0; i < files.length; i++) {
                addToZipFile(files[i], fos);
            }
            //zos.close();
            fos.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
	}
        catch (IOException e) {
            e.printStackTrace();
	}
        // TODO code application logic here
    }
    
    public static void addToZipFile(String fileName, FileOutputStream fos) throws FileNotFoundException, IOException {

		System.out.println("Writing '" + fileName + "' to zip file");

		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		//ZipEntry zipEntry = new ZipEntry(fileName);
		//fos.putNextEntry(fileEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			fos.write(bytes, 0, length);
		}

		fos.close();
		fis.close();
	}

    
}
