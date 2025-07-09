import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")) return 0;

        HashMap<Character, Integer> count = new HashMap<>();
        int max_sub = 1;
        int start = 0;
        char[] strArr = s.toCharArray();

        for (int i = 0; i < strArr.length; i++) {
            char ch = strArr[i];

            if (count.keySet().contains(ch) && count.get(ch) >= start) {
                start = count.get(ch) + 1;
            }
            max_sub = Math.max(max_sub, i - start + 1);
            count.put(ch, i);
        }
        
        return max_sub;
    }
}