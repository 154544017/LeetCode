package SlideWindow;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInaString {
    public static void main(String[] args) {
        List<Integer> rs = findAnagrams("cbaebabacd","abc");
        for (Integer i:rs
             ) {
            System.out.print(i.toString() + '\t');
        }
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> rs = new ArrayList<>();
        int exceptLen = p.length();
        int[] except = new int[26];
        for(char c: p.toCharArray()){
            except[c-'a']++;
        }
        int left = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (except[index] > 0){
                count++;
            }
            except[index]--;
            if (i - left + 1 >= p.length()){
                if (count == exceptLen){
                    rs.add(left);
                }
                int leftIndex = s.charAt(left) - 'a';
                except[leftIndex]++;
                if (except[leftIndex] > 0){
                    count--;
                }
                left++;
            }
        }
        return rs;
    }
}
