package fun.happyhacker.a0083;

import fun.happyhacker.utils.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode head = ListNode.createFromArray(new int[]{1, 4, 4});
        Solution solution = new Solution();
        ListNode result = solution.deleteDuplicates(head);
        ListNode.print(result);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode curr = head;

        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}
