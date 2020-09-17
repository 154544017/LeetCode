import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        Arrays.sort(nums);
        System.out.println(kSum(nums,0, 4, 0));
    }

    public static List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
        List<List<Integer>> rs = new ArrayList<>();
        if (k == 2) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (target == sum) {
                    rs.add(new ArrayList<>(Arrays.asList(nums[left], nums[right])));
                    left++;
                    while (left < nums.length && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;
                    while (right >= 0 && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (target > sum) {
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
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i == start || nums[i] != nums[i - 1]) {
                    List<List<Integer>> lists = kSum(nums, i + 1, k - 1, target - nums[i]);
                    for (List<Integer> list : lists) {
                        list.add(0, nums[i]);
                    }
                    rs.addAll(lists);
                }
            }
        }

        return rs;
    }
}
