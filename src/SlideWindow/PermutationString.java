package SlideWindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationString {
    public static void main(String[] args) {
        System.out.println(checkInclusion3("ab", "eidboaooo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            Map<Character, Integer> seen = new HashMap<>();
            String substring = s2.substring(i, i + s1.length());
            int count = 0;
            for (char c : substring.toCharArray()) {
                if (map.containsKey(c) && seen.getOrDefault(c, 0) < map.get(c)) {
                    seen.put(c, seen.getOrDefault(c, 0) + 1);
                    count++;
                } else {
                    break;
                }
            }
            if (count == s1.length()) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkInclusion2(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int len = s1.length();
        int count = 0;
        Map<Character, Integer> curMap = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (map.containsKey(c)) {
                curMap.put(c, curMap.getOrDefault(c, 0) + 1);
                if (map.get(c) >= curMap.get(c)) {
                    count++;
                }
            }
            if (i >= len){
                char startChar = s2.charAt(i-len);
                if (map.containsKey(startChar)){
                    curMap.put(startChar, curMap.get(startChar) - 1);
                    if (curMap.get(startChar) < map.get(startChar)) {
                        count--;
                    }
                }
            }
            if (count == len){
                return true;
            }

        }
        return false;
    }

    public static boolean checkInclusion3(String s1, String s2) {
        int[] except = new int[26];
        for(char c:s1.toCharArray()){
            except[c -'a']++;
        }
        int left = 0, count = 0;
        for (int i = 0; i < s2.length(); i++) {
            int index = s2.charAt(i) - 'a';
            if (except[index] > 0){
                count++;
            }
            except[index]--;
            if (count == s1.length()){
                return true;
            }
            if (i - left + 1 >= s1.length()){
                int beginIndex = s2.charAt(left) - 'a';
                except[beginIndex]++;
                if (except[beginIndex] > 0){
                    count--;
                }
                left++;
            }
        }
        return false;
    }

}
