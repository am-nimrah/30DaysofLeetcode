import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int end = intervals[0][1]; 
        int count = 0; 

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
            } else {
                end = intervals[i][1]; 
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] intervals1 = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(solution.eraseOverlapIntervals(intervals1)); 

        int[][] intervals2 = {{1,2},{1,2},{1,2}};
        System.out.println(solution.eraseOverlapIntervals(intervals2)); 

        int[][] intervals3 = {{1,2},{2,3}};
        System.out.println(solution.eraseOverlapIntervals(intervals3)); 
    }
}
