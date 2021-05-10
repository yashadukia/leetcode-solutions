class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        LinkedList<int[]> res = new LinkedList();
        int n = intervals.length;
        
        // Store new interval
        int start = newInterval[0];
        int end = newInterval[1];
        
        int idx = 0;
        
        // Keep adding intervals until the start is < newInterval
        while (idx < n && intervals[idx][0] < start)
        {
            res.add(intervals[idx]);
            idx++;
        }
        
        int[] temp = new int[2];
        // If newInt start > end of last interval. Then just add it
        if (res.isEmpty() || res.getLast()[1] < start)
        {
            res.add(new int[]{start, end});
        }
        // Else remove the last, calculate the end and add back to res
        else
        {
            temp = res.removeLast();
            temp[1] = temp[1] > end ? temp[1] : end;
            res.add(temp);
        }
        
        // Continue search
        while (idx < n)
        {
            temp = intervals[idx];
            idx++;
            
            // If start of interval > end of newInterval added previously, then just add to res
            if (res.getLast()[1] < temp[0])
                res.add(temp);
            // Else remove the last added and compare end times. and add it back to res
            else
            {
                int[] interval = res.removeLast();
                interval[1] = temp[1] > interval[1] ? temp[1] : interval[1];
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}