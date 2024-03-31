class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0; // Empty needle, return 0
        
        int n = haystack.length();
        int m = needle.length();
        
        // Iterate through the haystack
        for (int i = 0; i <= n - m; i++) {
            // Check if the substring of haystack starting at index i matches the needle
            if (haystack.substring(i, i + m).equals(needle)) {
                return i; // Return the index if a match is found
            }
        }
        
        return -1; // Return -1 if needle is not found in haystack
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        
        System.out.println(solution.strStr(haystack1, needle1)); // Output: 0
        System.out.println(solution.strStr(haystack2, needle2)); // Output: -1
    }
}