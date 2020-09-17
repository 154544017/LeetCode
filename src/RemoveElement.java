public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                if (diff != i){
                    nums[diff] = nums[i];
                }
                diff++;
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }
}
