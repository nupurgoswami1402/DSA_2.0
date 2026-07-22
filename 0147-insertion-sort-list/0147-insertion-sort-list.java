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
    public ListNode insertionSortList(ListNode head) {
        // Create a dummy node to simplify edge cases (inserting at head)
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = null;
        
        ListNode current = head;
        
        while (current != null) {
            // Store the next node before we detach current
            ListNode nextTemp = current.next;
            
            // Find the correct position to insert 'current' in the sorted part
            // Start from dummyHead
            ListNode prev = dummyHead;
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }
            
            // Insert current node between prev and prev.next
            current.next = prev.next;
            prev.next = current;
            
            // Move to the next node in the original list
            current = nextTemp;
        }
        
        return dummyHead.next;
    }
}