class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int maxlen = 0;
        int left = 0;
        int right = 0;
        while (left <= right && right < s.length()) {
            int[] lastOccurrence = new int[128];

        }
//        for (int start = 0; start < s.length(); start++) {
//            int[] lastOccurrence = new int[255];
//            int current = start;
//            while (current < s.length()) {
//                char currentChar = chars[current];
//                if (lastOccurrence[currentChar]) {
//                    break;
//                }
//
//                lastOccurrence[currentChar] = true;
//                current++;
//            }
//            int len = current - start;
//            if (len > maxlen) {
//                maxlen = len;
//            }
//        }
        return maxlen;
    }

    public static void main(String[] args)
    {
        System.out.println(new Solution3().lengthOfLongestSubstring("pwwkew"));
    }
}