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

    public static ArrayList<Head> listOfHeads = new ArrayList();
    public static int headSize = Head.getHeadSize();
    public static String [] files; 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
        int aux;
        do {
        System.out.println("Press 1 to do another operation");
        Scanner sc = new Scanner(System.in);
        Integer nmb = new Integer (sc.nextLine());
        if (nmb == 1) {
            menu();
        }
        aux = nmb;
        } while (aux == 1);
    }
    
    public static void menu () {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("1. Start an archive from zero;");
        System.out.println("2. Add a file to the archive;");
        System.out.println("3. List all the files on the archive;");
        System.out.println("4. Extract a file from the archive;");
        System.out.println("5. Remove a file from the archive.");
        Integer option = new Integer (sc.nextLine());
        switch (option) {
            case (1): {
                StartFromZero();
                break;
            }
            case (2): {
                AddFile();
                break;
            }
            case(3): {
                ListFiles(); 
                break;
            }
            case(4): {
                System.out.println("Insert the name os the file to bem extracted");
                Scanner scnr = new Scanner(System.in);
                String name = scnr.nextLine();
                try {
                    ExtractFile(name);
                }
                catch (IOException e) {
                    System.out.println("Error");
                }
                break;
            }
            case(5): {
                System.out.println("Insert the name os the file to bem removed");
                Scanner scan = new Scanner(System.in);
                String nme = scan.nextLine();
                RemoveFile(nme);
            break;
            }
        }
    }
    /**
     * aqui está o javadoc de startfromzero
     */
    public static void StartFromZero () {
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
                //addToZipFile(head.nome, fos);
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
    
    public static void ListFiles () {                                                   //OK
        for(Head head : listOfHeads){
            System.out.println(head.nome);
        }
        }
    
    public static void RemoveFile (String nome) { //remover o arquivo do archive
        for(Head head : listOfHeads){
            if (head.nome.equals(nome)) {
                head.status = false;
            }
        }
    }
    
    public static void ExtractFile (String nome) throws IOException, FileNotFoundException { //extrair o arquivo do archive (cria CÓPIA)
        for(Head head : listOfHeads){
            if (head.nome.equals(nome)) {
                FileInputStream fis = new FileInputStream(nome);
                FileOutputStream f = new FileOutputStream("arqextraido");
		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			f.write(bytes, 0, length);
		}
		fis.close();
            }
        }
    }
    
    public static void AddFile() {
        
    }
    }
