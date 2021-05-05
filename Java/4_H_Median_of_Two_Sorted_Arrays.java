/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Example 3:
Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000

Example 4:
Input: nums1 = [], nums2 = [1]
Output: 1.00000

Example 5:
Input: nums1 = [2], nums2 = []
Output: 2.00000
*/

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