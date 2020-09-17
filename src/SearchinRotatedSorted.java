public class SearchinRotatedSorted {
    public static void main(String[] args) {
        System.out.println(search(new int[]{3,1},1));
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (right - left)/2 + left;
            int num;
            //target maybe in the right side
            if (target < nums[nums.length-1]){
                num = nums[mid] > nums[nums.length - 1]? Integer.MIN_VALUE : nums[mid];
            }
            //target maybe in the left side
            else if (target > nums[nums.length-1]){
                num = nums[mid] < nums[0] ? Integer.MAX_VALUE : nums[mid];
            }else {
                return nums.length -1;
            }
            if (num == target){
                return mid;
            }else if(target > num){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
