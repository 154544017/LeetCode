import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * My solution costs too much time because when i find the repeated character,
 *  i will clear the map and traverse the string from i+1 again (it's not necessary because substring[i+1,j] is already checked;
 *  We can remove the key-value before i in the map but it costs time.
 *  The best solution is to update the map.
 */
public class LongestSubstring{

    public static void main(String[] args){
        String a = "pwwkew";
        System.out.println(lengthOfLongestSubstring(a));

    }

    public static int lengthOfLongestSubstring(String s) {
        int length = 0;
        int start= 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i;
        for(i = 0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start) {
                start = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i),i);
            length = Math.max(i - start + 1, length);
        }

        return length;
    }

    public static int lengthOfLongestSubstring_best(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

}