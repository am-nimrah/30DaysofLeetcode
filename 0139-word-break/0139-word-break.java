import java.util.*;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        Set<String> wordSet = new HashSet<>(wordDict);
        int maxLength = maxLength(wordDict);

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= Math.max(0, i - maxLength); j--) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    private int maxLength(List<String> wordDict) {
        int maxLength = 0;
        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList("leet", "code");
        System.out.println(solution.wordBreak(s1, wordDict1)); 

        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        System.out.println(solution.wordBreak(s2, wordDict2)); 
        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(solution.wordBreak(s3, wordDict3)); 
    }
}
