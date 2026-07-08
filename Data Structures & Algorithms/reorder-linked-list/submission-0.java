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
    public void reorderList(ListNode head) {
      ListNode slowPtr = head;
      ListNode fastPtr = head.next;

      while(fastPtr != null && fastPtr.next != null) {
        slowPtr = slowPtr.next;
        fastPtr = fastPtr.next.next;
      }

      ListNode head1 = slowPtr.next;
      slowPtr.next = null;

      ListNode current = head1;
      ListNode prev = null;

      while(current != null) {
        ListNode next = current.next;
        current.next = prev;

        prev = current;
        current = next;
      }
      head1 = prev;

     ListNode first = head;
     ListNode second = head1;

     while(second != null) {
        ListNode temp1 = first.next;
        ListNode temp2 = second.next;
        
        first.next = second;
        second.next = temp1;

        first = temp1;
        second = temp2;
     }
    }
}
