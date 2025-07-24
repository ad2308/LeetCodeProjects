class Solution28 {
    public int strStr(String haystack, String needle) {
        char[] needleChars = needle.toCharArray();
        char[] haystackChars = haystack.toCharArray();
        char[] haystackBuffer = new char[needleChars.length];
        int haystackBufferIndex = 0;
        for (int haystackIndex = 0; haystackIndex < haystackChars.length; haystackIndex++) {
            haystackBuffer[haystackBufferIndex] = haystackChars[haystackIndex];
            if (checkEquiv(needleChars, haystackBuffer, haystackBufferIndex)) {
                return haystackIndex - needleChars.length + 1;
            }
            haystackBufferIndex = (haystackBufferIndex + 1) % haystackBuffer.length;
        }
        return -1;
    }

    private boolean checkEquiv(char[] needleChars, char[] haystackBuffer, int bufferEndIndex) {
        int stopPoint = (bufferEndIndex + 1) % needleChars.length;
        int bufferCurrentIndex = stopPoint;
        int needleIndex = 0;
        do {
            if (haystackBuffer[bufferCurrentIndex] != needleChars[needleIndex]) return false;
            bufferCurrentIndex = (bufferCurrentIndex + 1) % needleChars.length;
            needleIndex++;
        } while (bufferCurrentIndex != stopPoint);
        return true;
    }

//    public static void main(String[] args) {
//        System.out.println(new Solution28().strStr("mississippi", "issip"));
//    }
}