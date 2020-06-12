package fun.happyhacker.a0002;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * 链表逐位相加，注意进位
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = create(Arrays.asList(2, 4, 3));
        ListNode l2 = create(Arrays.asList(5, 6, 4));

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);
        print(result);
    }

    private static ListNode create(List<Integer> list) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        for (Integer integer : list) {
            curr.next = new ListNode(integer);
            curr = curr.next;
        }

        return dummyHead.next;
    }

    private static void print(ListNode listNode) {
        ListNode p = listNode;

        while (p != null) {
            System.out.print(p.val);
            p = p.next;
        }
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

    @Data
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

