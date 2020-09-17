package SlideWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBQCODEBANC","ABC"));
    }

    public static String minWindow(String s, String t) {
        Map<Character,Integer> countMap = new HashMap<>();
        for(char c: t.toCharArray()){
            countMap.put(c,countMap.getOrDefault(c,0)+1);
        }
        int minStart = 0,minLen = Integer.MAX_VALUE, start = 0, end = 0, curCount = 0;
        while (end < s.length()){
            char c = s.charAt(end);
            if (countMap.containsKey(c)){
                curCount = countMap.get(c) > 0 ? curCount + 1 : curCount;
                countMap.put(c,countMap.get(c)-1);
            }
            end++;
            while (curCount == t.length()){
                if (end - start < minLen){
                    minLen = end - start;
                    minStart = start;
                }
                char startChar = s.charAt(start);
                if (countMap.containsKey(startChar)){
                    countMap.put(startChar,countMap.get(startChar) + 1);
                    curCount = countMap.get(startChar) > 0? curCount-1 : curCount;
                }
                start++;
            }

        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static String minWindow2(String s, String t) {
        int [] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] > 0) counter--;
            map[c1]--;
            end++;
            while (counter == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                final char c2 = s.charAt(start);
                map[c2]++;
                if (map[c2] > 0) counter++;
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
