/**
 * Time Complexity: O(n*n)
 * Space Complexity: O(1)
 */

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String t1 = "babad";
        String t2 = "tattarrattat";
        System.out.println(longestPalindrome(t2));
        System.out.println(longestPalindrome(t1));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int result = 0;
            result = get(s, i, i);
            if (result > max) {
                max = result;
                start = i - (result - 1) / 2;
                end = i + (result - 1) / 2;
            }
            if (i + 1 <= s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                result = get(s, i, i + 1);
                if (result > max) {
                    max = result;
                    start = i - (result - 2) / 2;
                    end = i + 1 + (result - 2) / 2;
                }
            }
        }
        return s.substring(start, end+ 1);
    }

    private static int get(String s, int start, int end){
        int len = s.length();
        while (start >= 0 && end <= len -1){
            if(s.charAt(start) == s.charAt(end)){
                start--;
                end++;
            }
            else{
                break;
            }
        }
        return end - start - 1;
    }

}
