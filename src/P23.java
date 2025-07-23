class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int currentLength = lists.length;
        while (currentLength > 1) {
            int newLength = (currentLength+1) / 2;
            for (int i = 0; i < newLength; i++) {
                if (currentLength % 2 == 1 && i == newLength - 1) {
                    lists[i] = lists[2*i];
                }
                else {
                    lists[i] = mergeTwoLists(lists[2*i], lists[2*i+1]);
                }
            }
            currentLength = newLength;
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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

    public static void main(String[] args) {
        System.out.println(new Solution23().mergeKLists(
                new ListNode[]{
                        new ListNode(1, new ListNode(4, new ListNode(5, null))),
                        new ListNode(1, new ListNode(3, new ListNode(4, null))),
                        new ListNode(2, new ListNode(6, null))
                }
        ));
    }
}