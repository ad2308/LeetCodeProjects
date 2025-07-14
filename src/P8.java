class Solution8 {
    public int myAtoi(String s) {
        //TODO: Proper comments
        char[] chars = s.toCharArray();
        boolean isNegative = false;
        StringBuilder numbers = new StringBuilder();
        int currentIndex = 0;
        // First, discard any trailing whitespace.
        while (currentIndex < chars.length && chars[currentIndex] == ' ') currentIndex++;
        // Then, if there is a + or - sign, read it and advance. Otherwise, process the number.
        if (currentIndex < chars.length) {
            switch (chars[currentIndex]) {
                case '+':
                    currentIndex++;
                    break;
                case '-':
                    isNegative = true;
                    currentIndex++;
                    break;
            }
        }
        // Ignore leading zeroes.
        while (currentIndex < chars.length && chars[currentIndex] == 48) currentIndex++;
        // While there are numbers one after the other, read them.
        while (currentIndex < chars.length && chars[currentIndex] >= 48 && chars[currentIndex] <= 57) {
            numbers.append(chars[currentIndex]);
            currentIndex++;
        }
        // If the number is in the tens of billions or bigger in magnitude, automatically cut it off.
        // This is to ensure there is no overflow when calculating placeValue.
        if (numbers.length() > 10) {
            if (isNegative) return -2147483648;
            else return 2147483647;
        }

        int result = 0;
        int placeValue = (isNegative ? -1 : 1) * (int) Math.pow(10, numbers.length() - 1);
        for (char c : numbers.toString().toCharArray()) {
            try {
                result = Math.addExact(result, Math.multiplyExact(c - 48, placeValue));
            } catch (ArithmeticException e) {
                // An exception should only be thrown if there is an overflow
                if (isNegative) return -2147483648;
                else return 2147483647;
            }
            placeValue /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution8().myAtoi("  0000000000012345678"));
    }
}