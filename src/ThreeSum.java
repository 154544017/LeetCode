import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 ||  nums[i] != nums[i - 1]) {
                int left = i + 1, right = nums.length - 1, implement = 0 - nums[i];
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == implement) {
                        ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        while (left < nums.length && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        right--;
                        while (right >= 0 && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum < implement) {
                        left++;
                        while (left < nums.length && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    } else {
                        right--;
                        while (right >= 0 && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
