package SlideWindow;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aabcs"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")){
            return 0;
        }
        int[] count = new int[128];
        int left = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c]++;
            if (count[c] == 1){
                maxLen = Math.max(maxLen, i - left + 1);
            }
            while (count[c] > 1){
                char startChar = s.charAt(left);
                count[startChar]--;
                left++;
            }
        }
        return maxLen;
    }
}
