import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
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
        String template = "您的销售额为%d，提成为%d%% ，共获得佣金￥%.2f";
        if (total <= 1000){
            System.out.println(String.format(template, total,10,total * 0.1));
        }else if(total <= 1800){
            System.out.println(String.format(template, total,15,total * 0.15));
        }else {
            System.out.println(String.format(template, total,20,total * 0.2));
        }
    }
}
