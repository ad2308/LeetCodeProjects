class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int maxStart = 0, maxEnd = 0;
        for (int sum = (s.length() - 1) * 2; sum >= 0; sum--) {
            int lowerBound = Math.max(0, sum - s.length() + 1);
            for (int start = sum / 2; start >= lowerBound; start--) {
                int end = sum - start;
                boolean isThisPalindrome =
                        (start == end)
                                || (chars[start] == chars[end]) && (end == start + 1 || isPalindrome[start + 1][end - 1]);

                // System.out.println(start+","+end+":"+s.substring(start, end+1)+" - "+isThisPalindrome);
                if (isThisPalindrome && end - start > maxEnd - maxStart) {
                    maxStart = start;
                    maxEnd = end;
                }
                isPalindrome[start][end] = isThisPalindrome;
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }


    // public static void main(String[] args) {
    //     System.out.println(new Solution5().longestPalindrome("babad"));
    // }
}