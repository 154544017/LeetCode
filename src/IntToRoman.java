public class IntToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        int[] symbol = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int rs;
        for (int i = 0; i < symbol.length; i++) {
            rs = num/symbol[i];
            num -= rs * symbol[i];
            for (int j = 0; j < rs; j++) {
                builder.append(symbols[i]);
            }
        }
        return builder.toString();
    }
}
