public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("   -42"));
    }

    public static int myAtoi(String str) {
        String input = str.trim();
        int len = input.length();
        int index = 0;
        int sign = 1;
        int sum = 0;
        if (len <= 0){
            return 0;
        }
        if(input.charAt(index) == '-' || input.charAt(index) == '+'){
            sign = input.charAt(index) == '+' ? 1: -1;
            index++;
        }
        while (index < len){
            int digit = input.charAt(index) - '0';
            if (digit <= 9 && digit>= 0){
                if (Integer.MAX_VALUE/10 < sum || (Integer.MAX_VALUE/10 == sum && Integer.MAX_VALUE%10 < digit)){
                    return sign == -1? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }else {
                    sum = sum * 10 + digit;
                }
            }else {
                break;
            }
            index++;
        }
        return sign * sum;
    }
}
