package fun.happyhacker.a0002;

import fun.happyhacker.utils.ListNode;

import java.util.Arrays;

/**
 * 链表逐位相加，注意进位
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = ListNode.createFromList(Arrays.asList(2, 4, 3));
        ListNode l2 = ListNode.createFromList(Arrays.asList(5, 6, 4));

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);
        ListNode.print(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}

