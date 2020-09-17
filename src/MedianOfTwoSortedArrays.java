import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2};
        int[] arr2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays2(arr1,arr2));
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < length1 && j < length2){
            if(nums1[i] < nums2[j]){
                list.add(nums1[i]);
                i++;
            }else if (nums1[i] > nums2[j]){
                list.add(nums2[j]);
                j++;
            }else {
                list.add(nums1[i]);
                list.add(nums2[j]);
                i++;
                j++;
            }
        }
        if(i < length1){
            for (; i < length1; i++) {
                list.add(nums1[i]);
            }
        }else if(j < length2){
            for (; j < length2; j++) {
                list.add(nums2[j]);
            }
        }
        int size = list.size();
        if (size % 2 == 0){
            return (list.get(size/2 - 1) + list.get(size/2)) / 2.0;
        }else {
            return list.get(size/2);
        }
    }
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int value : nums1) {
            list.add(value);
        }
        for (int value : nums2) {
            list.add(value);
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t1 - t2;
            }
        });
        int size = list.size();
        if (size % 2 == 0){
            return (list.get(size/2 - 1) + list.get(size/2)) / 2.0;
        }else {
            return list.get(size/2);
        }
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        boolean oddFlag = totalLength % 2 == 1;
        int begin = 0, end = 0;
        if (oddFlag){
            begin = totalLength/2;
        }else {
            end = totalLength/2;
            begin = end -1;
        }
        int index1=0 ,index2 = 0;
        int startValue=0, endValue=0;
        for (int i = 0; i < totalLength; i++) {
            int num1 = getNum(index1,nums1),num2 = getNum(index2,nums2);
            if (i == begin){
                startValue = Math.min(num1,num2);
                if (oddFlag){
                    return startValue;
                }
            }
            if (!oddFlag && i == end){
                endValue = Math.min(num1,num2);
                return (double)(startValue+endValue)/2;
            }
            if (num1 < num2){
                index1++;
            }else {
                index2++;
            }

        }
        return 0;
    }

    private static int getNum(int index, int[] num){
        return index < num.length? num[index] : Integer.MAX_VALUE;
    }
}
