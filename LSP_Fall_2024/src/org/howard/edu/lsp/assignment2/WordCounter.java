package org.howard.edu.lsp.assignment2;

import java.io.File;
import java.util.Scanner;

public class WordCounter {

	public static void main(String[] args) {
        //Read Input File Fucntion
        InputStream text = getClass().getResourceAsStream("words.txt");
        Scanner sc = new Scanner(text);
 
        while (sc.hasNextLine())
            System.out.println(sc.nextLine());



        //Create Hash Map
        //Parse through the file, Ignore words less than 3 letters and integers
    }
}