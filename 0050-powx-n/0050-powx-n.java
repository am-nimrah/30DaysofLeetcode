class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        
        if (n < 0) {
            x = 1 / x;
            // Avoid integer overflow when n = Integer.MIN_VALUE
            if (n == Integer.MIN_VALUE)
                return x * myPow(x, -(n + 1));
            n = -n;
        }
        
        double result = 1;
        while (n > 0) {
            if (n % 2 == 1)
                result *= x;
            x *= x;
            n /= 2;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Solution powerFunction = new Solution();
        
        // Example test cases
        System.out.println(powerFunction.myPow(2.00000, 10));  // Output: 1024.0
        System.out.println(powerFunction.myPow(2.10000, 3));   // Output: 9.261
        System.out.println(powerFunction.myPow(2.00000, -2));  // Output: 0.25
    }
}