import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"good","best","good"};
        List<Integer> integers = findSubstring(s, words);
        for(Integer i: integers){
            System.out.print(i + "\t");
        }
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> rs = new ArrayList<>();
        Map<String,Integer> wordCount =  new HashMap<>();
        for (String word: words){
            wordCount.put(word, wordCount.getOrDefault(word,0) + 1);
        }
        int wordLen = words[0].length();
        //s.length() - words.length * wordLen + 1 In case the index out of bounds
        for (int i = 0; i < s.length() - words.length * wordLen + 1; i++) {
            Map<String,Integer> curWordCount = new HashMap<>();
            int num = 0;
            while (num < words.length){
                String word = s.substring(i+num*wordLen,i+(num+1)*wordLen);
                if (wordCount.containsKey(word)){
                    curWordCount.put(word,curWordCount.getOrDefault(word,0) + 1);
                    if (curWordCount.get(word) <= wordCount.get(word)){
                        num++;
                    }else {
                        break;
                    }
                }else {
                    break;
                }
            }
            if (num == words.length){
                rs.add(i);
            }
        }
        return rs;
    }
}
