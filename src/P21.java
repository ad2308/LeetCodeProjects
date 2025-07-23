class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resultHead = null, resultCurrent = null, l1Current = list1, l2Current = list2;

        while (l1Current != null || l2Current != null) {
            ListNode next;
            if (l2Current == null || (l1Current != null && l1Current.val <= l2Current.val)) {
                next = l1Current;
                l1Current = l1Current.next;
            } else {
                next = l2Current;
                l2Current = l2Current.next;
            }

            if (resultHead == null) {
                resultHead = next;
            }
            else {
                resultCurrent.next = next;
            }
            resultCurrent = next;
        }
        return resultHead;
    }

//    public static void main(String[] args) {
//        System.out.println(new Solution21().mergeTwoLists(
//                new ListNode(1, new ListNode(2, new ListNode(4, null))),
//                new ListNode(1, new ListNode(3, new ListNode(4)))
//        ));
//    }
}