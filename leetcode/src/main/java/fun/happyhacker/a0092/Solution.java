package fun.happyhacker.a0092;

import fun.happyhacker.utils.ListNode;

import java.util.Arrays;

// 通过前面的快进快速移动到目标位置，把问题转化为简单的链表反转问题
// 注意当m = 1时，其实是将从1到n的部分全部反转，这时候prev指针是空的，所以需要判断一下
// 这时候prev指向目标链表的头部，而head还是指向原始链表的头部，因为是要返回原始链表的头部指针，所以要把这个指针指向目标链表的头部
public class Solution {
    public static void main(String[] args) {
        ListNode node = ListNode.createFromList(Arrays.asList(3,5));
        Solution solution = new Solution();
        ListNode reverse = solution.reverseBetween(node, 1, 2);
        ListNode.print(reverse);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        for (int i = 1; i < m; i++) {
            prev = curr;
            curr = curr.next;
        }

        ListNode curr2 = curr;
        ListNode prev2 = prev;

        for (int i = m; i <=n; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        curr2.next = curr;
        if (prev2 != null)  {
            prev2.next = prev;
        } else {
            head = prev;
        }

        return head;
    }
}
