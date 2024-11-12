package org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerSetTest {

    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    public void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    @Test
    @DisplayName("Test case for clear method")
    public void testClear() {
        set1.add(1);
        set1.add(2);
        set1.clear();
        assertTrue(set1.isEmpty(), "Set should be empty after clear");
    }

    @Test
    @DisplayName("Test case for length method")
    public void testLength() {
        assertEquals(0, set1.length(), "Length of an empty set should be 0");
        set1.add(1);
        set1.add(2);
        assertEquals(2, set1.length(), "Length should be 2 after adding two elements");
    }

    @Test
    @DisplayName("Test case for equals method")
    public void testEquals() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(1);
        assertTrue(set1.equals(set2), "Sets with same elements should be equal");

        set2.add(3);
        assertFalse(set1.equals(set2), "Sets with different elements should not be equal");
    }

    @Test
    @DisplayName("Test case for contains method")
    public void testContains() {
        set1.add(1);
        assertTrue(set1.contains(1), "Set should contain the added element");
        assertFalse(set1.contains(2), "Set should not contain an element that was not added");
    }

    @Test
    @DisplayName("Test case for largest method")
    public void testLargest() {
        set1.add(1);
        set1.add(3);
        set1.add(2);
        assertEquals(3, set1.largest(), "Largest element should be 3");

        set1.clear();
        assertThrows(IllegalStateException.class, set1::largest, "largest() should throw an exception if set is empty");
    }

    @Test
    @DisplayName("Test case for smallest method")
    public void testSmallest() {
        set1.add(1);
        set1.add(3);
        set1.add(2);
        assertEquals(1, set1.smallest(), "Smallest element should be 1");

        set1.clear();
        assertThrows(IllegalStateException.class, set1::smallest, "smallest() should throw an exception if set is empty");
    }

    @Test
    @DisplayName("Test case for add method")
    public void testAdd() {
        set1.add(1);
        set1.add(2);
        set1.add(1); // Duplicate add
        assertEquals(2, set1.length(), "Duplicate addition should not increase set size");
    }

    @Test
    @DisplayName("Test case for remove method")
    public void testRemove() {
        set1.add(1);
        set1.add(2);
        set1.remove(1);
        assertFalse(set1.contains(1), "Set should not contain the removed element");
        assertEquals(1, set1.length(), "Length should be reduced after removal");

        set1.remove(3); // Removing non-existing element
        assertEquals(1, set1.length(), "Removing a non-existing element should not affect set");
    }

    @Test
    @DisplayName("Test case for union method")
    public void testUnion() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.union(set2);
        assertTrue(set1.contains(1) && set1.contains(2) && set1.contains(3), "Union should contain all elements from both sets");
    }

    @Test
    @DisplayName("Test case for intersect method")
    public void testIntersect() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.intersect(set2);
        assertTrue(set1.contains(2) && !set1.contains(1) && !set1.contains(3), "Intersection should only contain common elements");
    }

    @Test
    @DisplayName("Test case for diff method")
    public void testDiff() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.diff(set2);
        assertTrue(set1.contains(1) && !set1.contains(2) && !set1.contains(3), "Difference should contain elements in set1 but not in set2");
    }

    @Test
    @DisplayName("Test case for complement method")
    public void testComplement() {
        set1.add(1);
        set1.add(2);
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        set1.complement(set2);
        assertTrue(set1.contains(3) && set1.contains(4) && !set1.contains(1) && !set1.contains(2),
                "Complement should contain elements in universal set but not in set1");
    }

    @Test
    @DisplayName("Test case for isEmpty method")
    public void testIsEmpty() {
        assertTrue(set1.isEmpty(), "Newly created set should be empty");
        set1.add(1);
        assertFalse(set1.isEmpty(), "Set should not be empty after adding elements");
    }

    @Test
    @DisplayName("Test case for toString method")
    public void testToString() {
        set1.add(1);
        set1.add(2);
        assertEquals("[1, 2]", set1.toString(), "String representation should match expected format");
    }
}
