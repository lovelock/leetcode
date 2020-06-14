package fun.happyhacker.a0206;

import fun.happyhacker.utils.ListNode;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        ListNode node = ListNode.createFromList(Arrays.asList(1, 2, 3, 4, 5));
        Solution solution = new Solution();
        ListNode reverse = solution.reverseList(node);
        ListNode.print(reverse);
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode next;
        ListNode pre = null;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
