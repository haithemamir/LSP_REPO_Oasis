package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * IntegerSet class to represent a collection of integers.
 */
public class IntegerSet {
    private List<Integer> set = new ArrayList<>();

    // Default constructor
    public IntegerSet() {
    }

    // Constructor to initialize with an already existing set
    public IntegerSet(ArrayList<Integer> set) {
        this.set = set;
    }

    /**
     * Clears the internal representation of the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the length of the set.
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if two sets are equal. Two sets are equal if they contain all of
     * the same values in any order.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntegerSet)) return false;
        IntegerSet otherSet = (IntegerSet) o;
        return set.containsAll(otherSet.set) && otherSet.set.containsAll(set);
    }

    /**
     * Returns true if the set contains the given value, otherwise false.
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest item in the set.
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest item in the set.
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        return Collections.min(set);
    }

    /**
     * Adds an item to the set or does nothing if it already exists.
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set or does nothing if not present.
     */
    public void remove(int item) {
        set.remove((Integer) item);
    }

    /**
     * Performs a union of the current set with another set.
     */
    public void union(IntegerSet intSetb) {
        for (int item : intSetb.set) {
            if (!set.contains(item)) {
                set.add(item);
            }
        }
    }

    /**
     * Performs an intersection of the current set with another set.
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /**
     * Performs the difference of the current set with another set (s1 - s2).
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /**
     * Complements the set (all elements not in the set).
     */
    public void complement(IntegerSet intSetb) {
        // Assumption: Complement is relative to the universal set represented by intSetb.
        set = intSetb.set;
        set.removeAll(this.set);
    }

    /**
     * Returns true if the set is empty, false otherwise.
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set.
     */
    @Override
    public String toString() {
        return set.toString();
    }
}
