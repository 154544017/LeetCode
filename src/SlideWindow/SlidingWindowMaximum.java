package SlideWindow;

import java.util.*;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] rs = new int[nums.length - k + 1];
        Queue<Integer> priorityQueue = new PriorityQueue<Integer>(k,((o1, o2) -> o2 - o1));
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
            if (i - left + 1 == k){
                rs[i- k +1] = priorityQueue.peek();
                priorityQueue.remove(nums[left]);
                left++;
            }
        }
        return rs;
    }

    public int[] maxSlidingWindow2(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

    public static void main(String[] args) {
        for(int i:maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)){
            System.out.print(String.valueOf(i) + '\t');
        }
    }
}
