class Solution {
    public int maxProfit(int[] prs) {
        if (prs.length == 0) {
            return 0; // if array empty
        }
    int min_price = prs[0]; //value 0 index of prs list assigned as minimun
        int max_profit = 0;
        for (int price : prs) {//traverse each element in list
            min_price = Math.min(min_price, price);

            max_profit = Math.max(max_profit, price - min_price);
        }

        return max_profit;
    }
}
