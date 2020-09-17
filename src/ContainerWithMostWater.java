public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] x = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(x));
    }

    public static int maxArea(int[] height) {
        int maxWater = 0;
        int i =0, j = height.length -1;
        while (i < j){
            maxWater = Math.max(maxWater, Math.min(height[i],height[j])*(j-i));
            if (height[i]<=height[j]){
                i++;
            }else {
                j--;
            }
        }
        return maxWater;
    }
}
