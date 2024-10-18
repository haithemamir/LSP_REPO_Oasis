package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

public class VotingMachine {
    // Using a HashMap to store candidates and their respective votes
    private Map<String, Integer> candidates;

    // Constructor initializes the HashMap
    public VotingMachine() {
        candidates = new HashMap<>();
    }

    // Method to add a candidate
    public void addCandidate(String name) {
        // Add the candidate with 0 votes if they don't already exist
        if (!candidates.containsKey(name)) {
            candidates.put(name, 0);
        }
    }

    // Method to cast a vote for a candidate
    public void castVote(String name) {
        // Check if the candidate exists before casting a vote
        if (candidates.containsKey(name)) {
            candidates.put(name, candidates.get(name) + 1); // Increment vote count
        }
    }

    // Method to print out the candidates and their vote count
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            result.append(entry.getKey()).append(": ").append(entry.getValue()).append(" votes\n");
        }
        return result.toString();
    }
}
