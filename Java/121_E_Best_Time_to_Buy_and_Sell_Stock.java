class Solution {
    public int maxProfit(int[] prices) {
        
        if (prices.length == 0)
            return 0;
            
        int buy = prices[0];
        int max = 0;
        
        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] < buy)
            {
                buy = prices[i];
                continue;
            }
            
            if(prices[i] - buy > max)
            {
                max = prices[i] - buy;
            }
        }
        return max;
    }
}