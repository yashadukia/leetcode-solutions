class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        // See older slower solution using PriorityQueue
        // This is similar to Merge 2 sorted Arrays
        
        int i = 0;
        int j = 0;
        int total_elements = nums1.length + nums2.length;
        int count = total_elements / 2;
        int[] res = new int[total_elements];
        int k = 0;
        
        while (i < nums1.length && j < nums2.length)
        {
            int v1 = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
            res[k++] = v1;
        }
        while (i < nums1.length)
        {
            res[k++] = nums1[i++];
        }
        while (j < nums2.length)
        {
            res[k++] = nums2[j++];
        }
        
        if (total_elements % 2 == 0)
            return (res[count] + res[count-1]) / 2.0;
        
        return res[count] * 1.0;
        
    }
}