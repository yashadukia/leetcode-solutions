class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if (nums1 == null || nums2 == null)
            return;
        
        int len = nums1.length;
        int it1 = m - 1;
        int it2 = n - 1;
        int it = m + n - 1;
        
        while (it1 >= 0 && it2 >= 0)
        {
            nums1[it--] = nums1[it1] >= nums2[it2] ? nums1[it1--] : nums2[it2--];
            
            // Comment above and un-comment below also works
            // if (nums1[it1] >= nums2[it2])
            // {
            //     nums1[it] = nums1[it1];
            //     it1--;
            // }
            // else
            // {
            //     nums1[it] = nums2[it2];
            //     it2--;
            // }
            // it--;
        }
        
        if (it1 > it2)
        {
            while (it1 >= 0)
            {
                nums1[it] = nums1[it1];
                it--;
                it1--;
            }
        }
        else
        {
            while (it2 >= 0)
            {
                nums1[it] = nums2[it2];
                it--;
                it2--;
            }
        }
        
        
    }
}