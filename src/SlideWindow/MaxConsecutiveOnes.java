package SlideWindow;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));
    }

    public static int longestOnes(int[] A, int K) {
        int oneCount = 0, left = 0, max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1){
                oneCount++;
            }
            max = Math.max(max, oneCount);
            if (i - left + 1 > oneCount + K){
                if (A[left] == 1){
                    oneCount--;
                }
                left++;
            }
        }
        return  A.length - left;
    }
}
