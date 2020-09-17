public class CommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        char c;
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(str.length(), minLength);
        }
        OUTER:
        for (int i = 0; i < minLength; i++) {
            c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c){
                    break OUTER;
                }
            }
            builder.append(c);
        }
        return builder.toString();
    }
}
