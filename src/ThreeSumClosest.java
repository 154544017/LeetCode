import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4},1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i-1]){
                int implement = target - nums[i];
                int left = i + 1, right = nums.length - 1;
                while (left < right){
                    int towSum = nums[left] + nums[right];
                    int subtract = towSum - implement;
                    if (subtract == 0){
                        return target;
                    }
                    if (Math.abs(subtract) < Math.abs(closest)){
                        closest = subtract;
                    }
                    if (subtract < 0){
                        left++;
                    }else {
                        right--;
                    }

                }
            }
        }
        return target+closest;
    }
}
