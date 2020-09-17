
public class ElementAppearingMoreThan {
    public static void main(String[] args) {
        System.out.println(findSpecialInteger(new int[]{1}));
    }
    public static int findSpecialInteger(int[] arr) {
        double key = arr.length/4.0;
        int count = 0;
        int value = -1;
        for (int temp : arr) {
            if (temp != value) {
                count = 0;
                value = temp;
            }
            count++;
            if (count > key) {
                return value;
            }
        }
        return -1;
    }
}
