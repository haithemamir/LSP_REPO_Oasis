package org.howard.edu.lsp.assignment2;

import java.io.InputStream;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static void main(String[] args) {
        // Read Input File Function using WordCounter class reference
        InputStream text = WordCounter.class.getResourceAsStream("words.txt");
        Scanner sc = new Scanner(text);

        // HashMap to store word counts
        Map<String, Integer> wordCount = new HashMap<>();

        // Read and process each line of the file
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            
            // Tokenize the line into words (not counting integers)
            String[] words = line.split("[^a-zA-Z]+");

            for (String word : words) {
                word = word.toLowerCase();  // Convert to lowercase 
                
                // Ignore trivial words (words with 3 or fewer characters)
                if (word.length() > 3) {
                    // Count the word occurrences in the map
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }

        // Close the scanner
        sc.close();

        // Print the word counts
        System.out.printf("%-15s %s%n", "Word", "Count");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.printf("%-15s %d%n", entry.getKey(), entry.getValue());
        }
    }
}
