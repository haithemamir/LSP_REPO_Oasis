package org.howard.edu.lsp.midterm.question3;

public class VotingMachineDriver {
    public static void main(String[] args) {
        // Instantiate a new voting machine
        VotingMachine vm = new VotingMachine();
        
        // Add candidates
        vm.addCandidate("Alsobrooks");
        vm.addCandidate("Hogan");
        
        // Cast votes
        vm.castVote("Alsobrooks");
        vm.castVote("Alsobrooks");
        vm.castVote("Hogan");
        
        // Print the results
        System.out.println(vm.toString());
    }
}
