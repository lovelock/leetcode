package fun.happyhacker.a0002;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        int high = 0;
        while (l1.next != null) {
            int tmp = l1.val + l2.val + high;
            if (tmp >= 10) {
                tmp -= 10;
                high = 1;
            } else {
                high = 0;
            }
            if (result == null) {
                result = new ListNode(tmp);
            } else {
                result.next = new ListNode(tmp);
            }
        }

        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(2, 4, 3);

        ListNode ln1 = null;
        ListNode ln2 = null;
        for (Integer integer : l1) {
            if (ln1 == null) {
                ln1 = new ListNode(integer);
            } else {
                ln1.next = new ListNode(integer);
            }
            System.out.println(ln1.val);
        }
        List<Integer> l2 = Arrays.asList(5, 6, 4);
        for (Integer integer : l2) {
            if (ln2 == null) {
                ln2 = new ListNode(integer);
            } else {
                ln2.next = new ListNode(integer);
            }
        }

        ListNode node = ln1;
        while (true) {
            if (node.next != null) {
                node = node.next;
            } else {
                node = null;
                break;
            }
            System.out.println(node.val);
        }
    }
}

