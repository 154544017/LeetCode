import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ICT {
    public static void main(String[] args) {
        List<Integer> inputs = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            inputs.add(scanner.nextInt());
        }
        int total = 0;
        for(Integer i : inputs){
            total+= inputs.get(i);
        }
        System.out.println(total);
    }

}
