package fun.happyhacker.a0021;

import fun.happyhacker.utils.ListNode;

// ListNode dummyHead = curr;
// 这种操作几乎是所有链表题都会使用的技巧，因为curr总是会移动到尾部，这时候就拿不到链表的首部了，所以就需要在最开始先占个位置
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = ListNode.createFromArray(new int[]{1,2,4});
        ListNode l2 = ListNode.createFromArray(new int[]{1,3,4});

        Solution solution = new Solution();
        ListNode result =  solution.mergeTwoLists(l1, l2);
        ListNode.print(result);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode();
        ListNode dummyHead = curr;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;
        }

        if (l2 != null) {
            curr.next = l2;
        }

        return dummyHead.next;
    }
}
