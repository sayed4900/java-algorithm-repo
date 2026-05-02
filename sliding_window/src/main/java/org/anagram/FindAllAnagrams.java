package org.anagram;

import java.util.*;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
public class FindAllAnagrams {

    void main() {
        String s = "aaaaaaaaaa";
        String p = "aaaaaaaaaaaaa" ;

        System.out.println(findAnagrams(s,p));
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return ans;
        }
        int k = p.length();

        HashMap<Character,Integer> anagramMap= new HashMap<>();
        for(char c : p.toCharArray()){
            anagramMap.put(c,anagramMap.getOrDefault(c,0)+1);
        }

       HashMap<Character,Integer> windowMap = new HashMap<>();
        for (int i = 0 ; i < k ; i++){
           windowMap.put(s.charAt(i), windowMap.getOrDefault(s.charAt(i),0)+1);
        }

        if (windowMap.equals(anagramMap)) {
            ans.add(0);
        }

        for (int i = 0 ; i < s.length()-k ; i++){
            char leftChar = s.charAt(i);
            char rightChar = s.charAt(i+k);


            int count = windowMap.get(leftChar);
            if (count <= 1) {
                windowMap.remove(leftChar);
            } else {
                windowMap.put(leftChar, count - 1);
            }

            windowMap.put(rightChar, windowMap.getOrDefault(rightChar,0)+1);

            if (windowMap.equals(anagramMap)) {
                ans.add(i+1);
            }
        }
        return ans;
    }

}
