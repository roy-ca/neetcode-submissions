/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int size = 0;
        while(temp != null) {
            temp = temp.next;
            size++;
        }

        int targetIndex = size - n;

        if(targetIndex == 0) {
            return head.next;
        }

        ListNode temp1 = head;
        ListNode prev = null;
        for(int i = 0; i < targetIndex; i++) {
            prev = temp1;
            temp1 = temp1.next;
        }

        prev.next = temp1.next;

        return head;

    }
}
