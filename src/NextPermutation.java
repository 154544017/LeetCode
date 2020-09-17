import com.sun.jmx.snmp.SnmpNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class NextPermutation {
    public static void main(String[] args) {
        nextPermutation(new int[]{1,2,3});
        nextPermutation(new int[]{3,2,1});
        nextPermutation(new int[]{1,3,2});
    }

    public static void nextPermutation(int[] nums) {
        boolean flag = false;
        for (int i = nums.length-1; i > 0; i--) {
            int min = Integer.MAX_VALUE;
            int position = -1;
            for (int j = i; j< nums.length;j++){
                if (nums[j] > nums[i-1]){
                    flag = true;
                    if (min > nums[j]){
                        min = nums[j];
                        position = j;
                    }
                }
            }
            if (flag){
                int temp = nums[i-1];
                nums[i-1] = min;
                nums[position] = temp;
                Arrays.sort(nums,i,nums.length);
                break;
            }
        }
        if (!flag){
            reverse(nums);
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void reverse(int[] nums){
        for (int i = 0; i < nums.length  / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i -1];
            nums[nums.length - i -1] = temp;
        }
    }
}
