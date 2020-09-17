public class ReverseInteger {
    public static void main(String[] args) {
        int a = 320;
        int b = -123;
        String b_ = String.valueOf(b);
        System.out.println(reverse(-110));;
    }

    public static int reverse(int x) {
//        String s = String.valueOf(x);
//        if(s.length() <= 1){
//            return x;
//        }
//        StringBuilder builder = new StringBuilder();
//        char last = s.charAt(s.length() - 1);
//        if(last != '0'){
//            builder.append(last);
//        }
//        for (int i = s.length() - 2; i > 0 ; i--) {
//            char c = s.charAt(i);
//            builder.append(c);
//        }
//        char start = s.charAt(0);
//        if(start == '-'){
//            builder.insert(0,start);
//        }else {
//            builder.append(start);
//        }
//
//        try {
//            return Integer.parseInt(builder.toString());
//        }catch (Exception e){
//            return 0;
//        }
        String ans = x < 0 ? new StringBuilder(String.valueOf(-x)).append("-").reverse().toString()
                : new StringBuilder(String.valueOf(x)).reverse().toString();
        try {
            return Integer.parseInt(ans);
    }catch (Exception e){
        return 0;
    }
    }
}
