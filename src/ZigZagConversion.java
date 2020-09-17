import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("ABC"
                ,2));

    }

    public static String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1){
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int row_i = 0;
        boolean mode = true;
        for(char c : s.toCharArray()){
            rows.get(row_i).append(c);
            if(mode){
                if(row_i == numRows - 1){
                    mode = false;
                    row_i--;
                }else {
                    row_i++;
                }
            }else {
                if(row_i == 0){
                    mode = true;
                    row_i++;
                }else {
                    row_i--;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder builder : rows){
            result.append(builder.toString());
        }
        return result.toString();
    }
}
