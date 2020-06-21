package fun.happyhacker.a876;

import fun.happyhacker.utils.ListNode;

// 这个思路很巧妙，一遍就解决了问题，不用先求出链表的长度再遍历一遍
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast =head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
