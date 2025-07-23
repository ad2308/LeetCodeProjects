class Solution24 {
    public ListNode swapPairs(ListNode head) {
        // If the list is of length 0 or 1, return the list unchanged.
        if (head == null || head.next == null) return head;
        // prev stores the first node in the pair we are currently swapping.
        // curr stores the second node in the pair we are currently swapping.
        // nxt stores the node after the second node currently being swapped.
        // prevprev stores the node before the first node currently being swapped.
        ListNode prevprev = null, prev = head, curr = head.next, nxt = head.next.next;

        // The head of the resulting list is always the second item in the input list (since it gets swapped into the first position)
        ListNode newHead = head.next;
        do {
            // Swap prev with curr.
            // This means pointing the first node in the pair to the node after the second node,
            // The second node in the pair to the first node
            // And the node before the pair to the first node in the pair.
            prev.next = nxt;
            curr.next = prev;
            if (prevprev != null) prevprev.next = curr;

            // Advance all nodes by two.
            // Since prev and curr have been swapped around (check with diagram), the new prevprev is the earlier prev.
            // The remaining pointer changes are as would be expected for a jump of two (checking for null values, of course)
            prevprev = prev;
            prev = nxt;
            curr = (prev == null) ? null : prev.next;
            nxt = (curr == null) ? null : curr.next;
        } while (curr != null);
        // Stop when the second node in the pair is null i.e. for an odd-length list there is one unpaired item at the end,
        // which does not need to be swapped, or for an even-length list, we have processed the last pair, and there are no
        // unvisited items.

        return newHead;
    }

//    public static void main(String[] args) {
//        System.out.println(new Solution24().swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))))));
//    }
}