import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,5};
        int[] arr2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays1(arr1,arr2));
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
        for (int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            list.add(nums2[i]);
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
}
