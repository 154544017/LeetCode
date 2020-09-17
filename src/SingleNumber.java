import java.util.Arrays;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=2) {
            if (i + 1 >= nums.length || nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }

    public static int singleNumberXOR(int[] nums) {
        int rs = 0;
        for (int num : nums) {
            rs ^= num;
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(singleNumberXOR(new int[]{2,2,1}));
    }
}
