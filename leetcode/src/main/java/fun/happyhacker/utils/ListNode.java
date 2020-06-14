package fun.happyhacker.utils;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public static void print(ListNode node) {
        ListNode p = node;
        StringBuilder sb = new StringBuilder();
        while (p != null) {
            sb.append(p.val);
            sb.append(" -> ");
            p = p.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }

    public static ListNode createFromArray(int[] nums) {
        ListNode curr = new ListNode();
        ListNode dummyHead = curr;

        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }

        return dummyHead.next;
    }

    public static ListNode createFromList(List<Integer> list) {
        ListNode curr = new ListNode();
        ListNode dummyHead = curr;

        for (Integer integer : list) {
            curr.next = new ListNode(integer);
            curr = curr.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.createFromArray(new int[]{1,2,3,4,5});
        ListNode.print(node);
    }
}
