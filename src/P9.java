class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int firstDigitPlaceValue = (int) Math.pow(10, Math.floor(Math.log10(x)));
        // Continue extracting first and last digit until the "middle" of the number is reached
        // For a number with an odd number of digits, this is when the first digit has a place value of 1
        // For a number with an even number of digits, this is when there are no digits, so the
        // value of firstDigitPlaceValue would be less than 1 (i.e. 1/10)
        while (firstDigitPlaceValue > 1) {
            // The first digit is the number of times the place value of the first digit goes into the number
            // For example, 234 / 100 = 2, which is the first digit.
            int firstDigit = x / firstDigitPlaceValue;
            // x % 10 here gives the last digit. If the first digit is not equal to the last digit, then the number is not a palindrome.
            if (firstDigit != x % 10) return false;
            // Subtract e.g. 2 * 100 = 200 from 234 to give 34, in essence removing the first digit.
            x -= firstDigit * firstDigitPlaceValue;
            // Divide the remaining value by 10 to get rid of the last digit e.g. 34 / 10 = 3
            x /= 10;
            // The number has lost two digits, so the place value of the first digit has decreased by a factor of 100
            firstDigitPlaceValue /= 100;
        }
        // If the number has reached this point, it must be a palindrome.
        return true;
    }

//    public static void main(String[] args) {
//        System.out.println(new Solution9().isPalindrome(1000021));
//    }
}