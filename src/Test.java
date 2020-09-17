import java.util.*;

public class Test {
    public static void main(String[] args) {
        getSalary();
    }

    public static String minWindow(String s, String t) {
        int[] except = new int[128];
        int[] seen = new int[128];
        for (char c: t.toCharArray()) {
            except[c]++;
        }
        int left = 0, count = 0, minLeft = 0, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            seen[c]++;
            if (seen[c] <= except[c]){
                count++;
            }
            while (count >= t.length()){
                int len = i - left + 1;
                if (len < minLen){
                    minLeft = left;
                    minLen = len;
                }
                char startChar = s.charAt(left);
                seen[startChar]--;
                if (seen[startChar] < except[startChar]){
                    count--;
                }
                left++;
            }
        }
       return minLen == Integer.MAX_VALUE? "" : s.substring(minLeft,minLeft + minLen);
    }

    public static void getSalary() {
        System.out.println("请输入销售的主机数、显示器数、外设数，用空格分隔：");
        Scanner scanner = new Scanner(System.in);
        int host = 0, screen = 0, peripheral = 0;
        boolean inputFlag = false;
        while (!inputFlag) {
            try {
                host = Integer.parseInt(scanner.next());
                screen = Integer.parseInt(scanner.next());
                peripheral = Integer.parseInt(scanner.next());
                if (host < 1 || screen < 1 || peripheral < 1){
                    System.out.println("至少销售一台完整的机器才能结算佣金！请重新输入：");
                }else if (host > 70 || screen > 80 || peripheral > 90){
                    System.out.println("销售数量必须小于最大约束！请重新输入：");
                }else {
                    inputFlag = true;
                }
            }catch (Exception e){
                System.out.println("请输入正确的销售数量");
                scanner = new Scanner(System.in);
            }
        }
        int total = 25 * host + 30 * screen + 45 * peripheral;
        String template = "您的销售额为${total}，提成为${percent}%，共获得佣金￥${salary}";
        if (total <= 1000){
            System.out.println(String.format(template, total,10,total * 0.1));
        }else if(total <= 1800){
            System.out.println(String.format(template, total,15,total * 0.15));
        }else {
            System.out.println(String.format(template, total,20,total * 0.2));
        }
    }

}
