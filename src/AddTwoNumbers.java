/**
 * The first time i want to change the node to integer and simply perform the addition, but the number is too big(bigger than long).
 * The we need to traverse the two list, and add the numbers in the same position.
 * Time Complexity : O(max(m,n)).
 * Space Complexity: O(max(m,n)). The length of the new list is at most max(m,n)+1 (empty node in the head
 * */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = getNode(new int[]{9,8});

        ListNode l2 = getNode(new int[]{1});
        ListNode s = addTwoNumbers(l1,l2);
        System.out.print("hello");
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode getNode(int[]num){
        int i = 1;
        ListNode l1 = new ListNode(num[0]);
        ListNode s= l1;
        while (i < num.length){
            s.next = new ListNode(num[i]);
            s = s.next;
            i++;
        }
        return l1;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode ll1 = l1, ll2 = l2, ll3= result;
        int flag = 0;
        while (ll1 != null || ll2!= null){
            int x = ll1 == null? 0 : ll1.val;
            int y = ll2 == null? 0 : ll2.val;
            int sum = x + y + flag;
            flag = sum /10;
            ll3.next = new ListNode(sum % 10);
            if(ll1 != null) ll1 = ll1.next;
            if(ll2 != null) ll2 = ll2.next;
            ll3 = ll3.next;
            if(ll1 == null && flag == 0){
                ll3.next = ll2;
                break;
            }else if(ll2 == null && flag == 0){
                ll3.next = ll1;
                break;
            }
        }
        if(flag == 1){
            ll3.next = new ListNode(1);
        }
        return result.next;
    }
}
