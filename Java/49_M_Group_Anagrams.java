class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if (strs == null)
            return null;
            
        List<List<String>> res = new ArrayList<>();
        List<String> t = new ArrayList<>();
        
        HashMap<String, List<String>> hm = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++)
        {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            
            if (!hm.containsKey(String.valueOf(c)))
            {
                t.add(strs[i]);
                hm.put(String.valueOf(c), t);
                t = new ArrayList<String>();
            }
            else
            {
                List<String> l =  hm.get(String.valueOf(c));
                l.add(strs[i]);
                hm.put(String.valueOf(c), l);
            }
        }
        
        for(List<String> x: hm.values())
            res.add(x);
        
        return res; 
    }
}