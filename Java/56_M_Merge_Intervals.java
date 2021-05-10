class Solution {
    public int[][] merge(int[][] intervals) {
        
        if (intervals == null || intervals.length <= 1)
            return intervals;
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int result = Integer.compare(o1[0], o2[0]);
                if (result == 0) {
                    result = Integer.compare(o1[1], o2[1]);
                }
                return result;
            }
        });
        
        int len = intervals.length;
        
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for (int i = 1; i < len; i++)
        {
            if (intervals[i][0] <= end)
            {
                if (end < intervals[i][1])
                    end = intervals[i][1];
            }
            else
            {
                res.add(new int[]{start, end});
                
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
            
        res.add(new int[]{start, end});
        
        return res.toArray(new int[res.size()][]);
        
    }
}