class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        String currentPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String nextString = strs[i];
            StringBuilder newPrefix = new StringBuilder();
            int stopIndex = Math.min(currentPrefix.length(), nextString.length());
            for (int j = 0; j < stopIndex; j++) {
                if (currentPrefix.charAt(j) != nextString.charAt(j)) break;
                newPrefix.append(currentPrefix.charAt(j));
            }
            currentPrefix = newPrefix.toString();
        }
        return currentPrefix;
    }
}