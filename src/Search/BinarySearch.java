package Search;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new Integer[]{1,2,3,3,4,5},3));
    }
    public static <AnyType extends Comparable<? super AnyType>> int binarySearch(AnyType[] a, AnyType x){
        int low = 0,high = a.length - 1;
        while (low <= high){
            int mid = (low + high)/2;
            if (a[mid] == x){
                return mid;
            }else if(a[mid].compareTo(x) < 0){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
