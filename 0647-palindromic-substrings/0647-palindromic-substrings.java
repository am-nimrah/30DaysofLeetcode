class Solution {
     public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        Solution ps = new Solution();
        
        // Example test cases
        System.out.println(ps.countSubstrings("abc"));  // Output: 3
        System.out.println(ps.countSubstrings("aaa"));  // Output: 6
    }
}