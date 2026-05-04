package org.sum;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxSoFar = 0;
        int lastLeftIdx = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            while (set.contains(ch)) {
                set.remove(s.charAt(lastLeftIdx));
                lastLeftIdx++;
            }

            // add new char
            set.add(ch);

            //  the new window = i - lastLeftIdx + 1
            maxSoFar = Math.max(maxSoFar, i - lastLeftIdx + 1);
        }

        return maxSoFar;
    }

     void main() {
        String s = "dvdf";
         System.out.println(lengthOfLongestSubstring(s));
    }
}
