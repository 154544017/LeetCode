import java.util.HashMap;

/**
 * Time complexity : O(n). We traverse the list containing n elements only once.Each look up in the table costs only O(1) time.
 * Space complexity: O(n). The extra space required depends on the number of items stored in the hash table, which stores at most n elements.
 */
public class TwoSum {
    public static void main(String[] args) {

    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0;i < nums.length; i++){
            int complement = target - nums[i];
            if(hashMap.containsKey(complement)){
                return new int[]{i,hashMap.get(complement)};
            }
            hashMap.put(nums[i],i);
        }
        return null;
    }
}
