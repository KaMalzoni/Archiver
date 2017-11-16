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
import java.util.ArrayList;

public class Archiver {

    ArrayList<Head> listOfHeads = new ArrayList();
    int headSize = Head.getHeadSize();
    String [] files; 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
    public void StartFromZero () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please insert the number of files to be compressed");
        Integer nmbf = new Integer (sc.nextLine()); 
        files = new String [nmbf];
        int pos = nmbf * headSize;
        for (int i = 0; i < files.length; i++){
            System.out.println("Please insert the name of the file to be compressed");
            File fname = new File (sc.nextLine());
            files[i] = fname.toString();
            Head cab = new Head(fname.length(),pos,true,i,nmbf);
            listOfHeads.add(cab);
            pos += fname.length();
        }
        try {
            FileOutputStream fos = new FileOutputStream("arqcompactado.aa");
            for(Head head : listOfHeads){
                fos.write(head.getBytes(), 0, Head.getHeadSize());
            }
            for (String file : files) {
                addToZipFile(file, fos);
            }
            cleanUP(fos);
        }
        catch (FileNotFoundException e) {
	}
        catch (IOException e) {
	}
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
    public static void cleanUP (FileOutputStream fos) throws IOException{               //OK
        fos.close();
    }
    
    public void ListFiles () {                                                   //OK
        for(Head head : listOfHeads){
            System.out.println(head.nome);
        }
        }
    
    public static void RemoveFile (String nome, ArrayList<Head> listOfHeads) { //remover o arquivo do archive
        for(Head head : listOfHeads){
            if (head.nome.equals(nome)) {
                head.status = false;
            }
        }
    }
    
    public static void ExtractFile (String nome) { //extrair o arquivo do archive (cria CÓPIA)
        
    }
    }
