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

public class Archiver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please insert the number of files to be compressed");
        Integer nmbf = new Integer (sc.nextLine());
        String [] files = new String [nmbf]; 
        for (int i = 0; i < files.length; i++){
            System.out.println("Please insert the name of the file to be compressed");
            File fname = new File (sc.nextLine());
            files[i] = fname.toString();
            Head cab = new Head();
            cab.SetNome(files[i]);
            cab.SetStatus(Boolean.TRUE);
            cab.SetSize(fname.length());
            cab.SetRn(i);
            if (i==0) {
                cab.SetPos(i);
            } else {
                cab.SetPos(cab.rn==(i-1).size==cab.rn + (i-1).pos); //ONDE COMEÇA O ANTERIOR + O TAMANHO DO ANTERIOR
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream("arqcompactado.aa");
            for (String file : files) {
                addToZipFile(file, fos);
            }
            cleanUP(fos);
        }
        catch (FileNotFoundException e) {
	}
        catch (IOException e) {
	}
        
        // TODO code application logic here
    }
    
    public static void addToZipFile(String fileName, FileOutputStream fos) throws FileNotFoundException, IOException {

		System.out.println("Writing '" + fileName + "' to zip file");

		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			fos.write(bytes, 0, length);
		}
		fis.close();
	}
    
//criei pq estava fechando o OutputStream antes do final da execução do programa
    public static void cleanUP (FileOutputStream fos) throws IOException{ 
        fos.close();
    }
}