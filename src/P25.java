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
class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int iterations = length(head) / k;
        ListNode prevHead = head;
        ListNode result = reverseItems(prevHead, k);
        for (int i = 1; i < iterations; i++) {
            prevHead.next = reverseItems(prevHead.next, k);
            prevHead = advanceBy(prevHead, k);
        }
        return result;
    }

    private ListNode advanceBy(ListNode head, int k) {
        ListNode newHead = head;
        for (int i = 0; i < k; i++) {
            newHead = newHead.next;
        }
        return newHead;
    }

    private void swap(ListNode prevprev, ListNode prev, ListNode curr, ListNode nxt) {
        prev.next = nxt;
        if (curr != null) curr.next = prev;
        if (prevprev != null) prevprev.next = curr;
    }

    private int length(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    private ListNode reverseItems(ListNode head, int itemsToReverse) {
        // If 0 or 1 items have to be reversed, no actual work needs to be done.
        if (itemsToReverse == 0 || itemsToReverse == 1) return head;

//        // If the number of items that have to be reversed is greater than the number of items in the list, do nothing.
//        if (itemsToReverse > length(head)) return head;

        ListNode newHead = head;
        for (int swapCount = itemsToReverse - 1; swapCount > 0; swapCount--) {
            ListNode prevprev = null, prev = newHead, curr = newHead.next, nxt = newHead.next.next;
            for (int i = 0; i < swapCount; i++) {
                if (i == 0) newHead = curr;
                swap(prevprev, prev, curr, nxt);
                prevprev = curr;
                //prev = prev (unchanged)
                curr = nxt;
                nxt = (curr == null) ? null : curr.next;
            }
//            System.out.println(swapCount+";"+prevprev+";"+prev+";"+curr+";"+nxt);
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode prevHead = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(new Solution25().reverseKGroup(prevHead, 1));
//        ListNode prevReverse = new Solution25().reverseItems(prevHead, 3);
//        System.out.println(prevReverse);
//        System.out.println(prevHead);
//        ListNode currReverse = new Solution25().reverseItems(prevHead.next, 3);
//        prevHead.next = currReverse;
//        System.out.println(prevReverse);
//        System.out.println(prevHead);
    }
}