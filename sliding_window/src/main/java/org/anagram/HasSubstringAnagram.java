package org.anagram;

import java.util.HashSet;
import java.util.Set;

public class HasSubstringAnagram {

    String s = "greyhounds";
    String anagram = "hoy";

    public boolean hasSubStringAnagram(String str, String anagram){
        int k = anagram.length();
        Set<Character> anagramSet = new HashSet<>();
        for (char c : anagram.toCharArray()) {
            anagramSet.add(c);
        }
        Set<Character> windowSet = new HashSet<>();
        for (int i = 0; i < k; i++) {
            windowSet.add(s.charAt(i));
        }
        // 3. مقارنة أول نافذة
        if (windowSet.equals(anagramSet)) {
            return true;
        }
        // 4. تحريك النافذة (Sliding)
        for (int i = 0; i < s.length() - k; i++) {
            // إزالة الحرف اللي خرج من الشمال
            windowSet.remove(s.charAt(i));

            // إضافة الحرف اللي دخل من اليمين
            windowSet.add(s.charAt(i + k));

            // مقارنة الـ Set بعد التعديل
            if (windowSet.equals(anagramSet)) {
                return true;
            }
        }
        return false;
    }
}
