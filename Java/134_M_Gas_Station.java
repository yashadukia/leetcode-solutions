class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        // total is used to see if sum[gas] - sum[costs] > 0
        int total = 0;
        
        // Curr monitors current situation and resets if < 0
        int curr = 0;
        int start = 0;
        
        for (int i = 0; i < gas.length; i++)
        {
            total += gas[i] - cost[i];
            curr += gas[i] - cost[i];
            
            // Since we cannot reach i+1 with gas we have. We reset curr and choose i+1 as starting station
            if (curr < 0)
            {
                curr = 0;
                start = i + 1;
            }
        }
        
        return total >= 0 ? start : -1;
    }
}