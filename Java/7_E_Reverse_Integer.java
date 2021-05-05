
class Solution {
    public int reverse(int x) {
        long res = 0;
        
        while (x != 0)
        {
            // Think 123 => 0*10 + 123%10 -> 3 ------ x /= 10 -> 12
            // 3*10 + 12%10 -> 30 + 2 -> 32 --------- x /= 10 -> 1
            // 32*10 + 1%10 -> 320 + 1 -> 321 ------- x /= 10 -> 0
            res = res * 10 + x % 10;
            x = x / 10;
        }
        
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE)
            return 0;
        else
            return (int)res;
    }
}