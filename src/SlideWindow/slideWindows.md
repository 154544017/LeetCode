# 滑动窗口

滑动窗口常用来扫描找到满足特定条件的解， 通过(left, right两个指针)来维护一个长度的窗口，通过right指针来扫描扩充窗口，当窗口内的元素不满足条件时，通过left指针来调整窗口。条件值和当前值可以用HashMap来记录、维护，由于题目往往只涉及到字母、数字，所以可以用数组来代替哈希表，以空间换时间。

1. [424,Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)

   count数组记录当前窗口内各字符出现的次数。max+k即为当前窗口大小，只有当前窗口内的max增加时才会变大，否则维持当前大小。因为窗口大小不会缩小，所以当遍历结束后，当前窗口即为最大的窗口。

```java
public int characterReplacement(String s, int k) {
    int[] count = new int[26];
    int max = 0, left = 0;
    for (int i = 0; i < s.length() ; i++) {
        int index = s.charAt(i) - 'A';
        count[index]++;
        max = Math.max(max, count[index]);
        if (i - left + 1> max + k){
            count[s.charAt(left) - 'A']--;
            left++;
        }
    }
    //because we never shrink the window, so the window size is biggest at the end.
    return s.length() - left;
}
```

2. [76.Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)

   except记录期望出现的字符，seen记录当前窗口内出现的字符(其实可以只用一个数组)，count表示当前窗口内满足的字符个数。当窗口内存在满足条件的字符串，则收缩窗口(调整left指针)，并记录最小字符串的位置。

   ```java
   public static String minWindow(String s, String t) {
       int[] except = new int[128];
       int[] seen = new int[128];
       for (char c: t.toCharArray()) {
           except[c]++;
       }
       int left = 0, count = 0, minLeft = 0, minLen = Integer.MAX_VALUE;
       for (int i = 0; i < s.length(); i++) {
           char c = s.charAt(i);
           seen[c]++;
           if (seen[c] <= except[c]){
               count++;
           }
           while (count >= t.length()){
               int len = i - left + 1;
               if (len < minLen){
                   minLeft = left;
                   minLen = len;
               }
               char startChar = s.charAt(left);
               seen[startChar]--;
               if (seen[startChar] < except[startChar]){
                   count--;
               }
               left++;
           }
       }
       return minLen == Integer.MAX_VALUE? "" : s.substring(minLeft,minLeft + minLen);
   }
   ```

   

3. [3.Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

   因为只期望每个字符出现一次，所以重复字符出现时，没必要用while循环去确定left位置，可以用count或map记录字符出现的位置，重复字符出现时，直接将left置为map[c]+1。

   ```
   public int lengthOfLongestSubstring(String s) {
       if (s == null || s.equals("")){
           return 0;
       }
       int[] count = new int[128];
       int left = 0, maxLen = 0;
       for (int i = 0; i < s.length(); i++) {
           char c = s.charAt(i);
           count[c]++;
           if (count[c] == 1){
               maxLen = Math.max(maxLen, i - left + 1);
           }
           while (count[c] > 1){
               char startChar = s.charAt(left);
               count[startChar]--;
               left++;
           }
       }
       return maxLen;
   }
   ```

4. [1004.Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/)

   同 [424: Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)

   ```java
   public int longestOnes(int[] A, int K) {
       int oneCount = 0, left = 0, max = 0;
       for (int i = 0; i < A.length; i++) {
           if (A[i] == 1){
               oneCount++;
           }
           max = Math.max(max, oneCount);
           if (i - left + 1 > max + K){
               if (A[left] == 1){
                   oneCount--;
               }
               left++;
           }
       }
       return  A.length - left;
   }
   ```

   

5. [567. Permutation in String](https://leetcode.com/problems/permutation-in-string/)

   固定窗口大小为目标字符数，本次用except代替except和seen两个数组，用count记录出现的目标字符数。思路同[76: Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)，只不过将窗口由可变长度变为固定长度。

   ```java
   public boolean checkInclusion3(String s1, String s2) {
       int[] except = new int[26];
       for(char c:s1.toCharArray()){
           except[c -'a']++;
       }
       int left = 0, count = 0;
       for (int i = 0; i < s2.length(); i++) {
           int index = s2.charAt(i) - 'a';
           if (except[index] > 0){
               count++;
           }
           except[index]--;
           if (count == s1.length()){
               return true;
           }
           if (i - left + 1 >= s1.length()){
               int beginIndex = s2.charAt(left) - 'a';
               except[beginIndex]++;
               if (except[beginIndex] > 0){
                   count--;
               }
               left++;
           }
       }
       return false;
   }
   ```

6. [438. Find All Anagrams in a String]{https://leetcode.com/problems/find-all-anagrams-in-a-string/}

   固定长度的滑动窗口，思路同[567. Permutation in String](https://leetcode.com/problems/permutation-in-string/)

   ```java
   public static List<Integer> findAnagrams(String s, String p) {
       List<Integer> rs = new ArrayList<>();
       int exceptLen = p.length();
       int[] except = new int[26];
       for(char c: p.toCharArray()){
           except[c-'a']++;
       }
       int left = 0, count = 0;
       for (int i = 0; i < s.length(); i++) {
           int index = s.charAt(i) - 'a';
           if (except[index] > 0){
               count++;
           }
           except[index]--;
           if (i - left + 1 >= p.length()){
               if (count == exceptLen){
                   rs.add(left);
               }
               int leftIndex = s.charAt(left) - 'a';
               except[leftIndex]++;
               if (except[leftIndex] > 0){
                   count--;
               }
               left++;
           }
       }
       return rs;
   }
   ```

7. [239. Sliding Window Maximum]{https://leetcode.com/problems/sliding-window-maximum/}

   用最大堆时间效率稍高，因为总是维护k个元素的堆。可以用双端队列dequeue存储下标，并及时维护(删除窗口外下标、删除值小于将要进窗口的元素的下标)来减少所用时间。

    ```java
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
    ```

