/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
Find two lines, which, together with the x-axis forms a container, such that the container contains 
the most water.

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
the max area of water (blue section) the container can contain is 49.
*/

class Solution {
    public int maxArea(int[] height) {
        
        if (height == null)
            return 0;
        
        int start = 0;
        int end = height.length - 1;
        
        int maxArea = 0;
        
        while(start < end)
        {
            int area = Math.min(height[start], height[end]) * (end - start);
            
            if(area > maxArea)
                maxArea = area;
            
            if (height[start] <= height[end])
                start++;
            else
                end--;
        }
        
        return maxArea;
    }
}