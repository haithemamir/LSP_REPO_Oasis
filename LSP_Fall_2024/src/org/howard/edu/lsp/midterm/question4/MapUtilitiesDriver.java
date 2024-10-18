package org.howard.edu.lsp.midterm.question4;

import java.util.HashMap;

public class MapUtilities {
    // Static method to count common key-value pairs between two HashMaps
    public static int commonKeyValuePairs(HashMap<String, String> map1, HashMap<String, String> map2) {
        // Return 0 if either map is empty or null
        if (map1 == null || map2 == null || map1.isEmpty() || map2.isEmpty()) {
            return 0;
        }

        int commonCount = 0;

        // Iterate over map1 and check if map2 contains the same key-value pairs
        for (String key : map1.keySet()) {
            if (map2.containsKey(key) && map2.get(key).equals(map1.get(key))) {
                commonCount++;
            }
        }

        return commonCount;
    }
}
