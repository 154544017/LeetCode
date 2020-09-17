import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        List<List<String>> lists = groupAnagrams(new String[]{
                "eat", "tea", "tan", "ate", "nat", "bat"
        });
        for (List<String> list: lists){
            for(String str:list){
                System.out.print(str+'\t');
            }
            System.out.print('\n');
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rs = new ArrayList<>();
        int count = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(String str : strs){
            String sortStr = sortString(str);
            if (!map.containsKey(sortStr)){
                map.put(sortStr,count);
                ArrayList<String> temp = new ArrayList<>();
                temp.add(str);
                rs.add(temp);
                count++;
            }else {
                rs.get(map.get(sortStr)).add(str);
            }
        }
        return rs;
    }

    public static String sortString(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
