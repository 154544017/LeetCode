package SlideWindow;

//424: https://leetcode.com/problems/longest-repeating-character-replacement/discuss/?currentPage=1&orderBy=most_votes&query=
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("ABCAAABBCCCC",1));
    }

    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int max = 0, left = 0;
        for (int i = 0; i < s.length() ; i++) {
            int index = s.charAt(i) - 'A';
            count[index]++;
            max = Math.max(max, count[index]);
            if (i - left + 1> max + k){
                count[s.charAt(left) - 'A']--;
                left++;
            }
        }
        //because we never shrink the window, so the window size is biggest at the end.
        return s.length() - left;
    }
}
