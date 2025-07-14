class Solution7 {
    public int reverse(int x) {
        int result = 0;
        boolean isNegative = x < 0;
        x = (isNegative) ? -1 * x : x;
        // At this point, x should be positive;

        // For reversing a number, the place values go down by factors of 10, instead of up.
        // For example, reversing 123:
        // We want result = 300 + 20 + 1
        // So, 3 * 10^2 + 2 * 10^1 + 1 * 10^0
        // The initial place value is equal to 10^floor(log_10(x))
        // For each subsequent digit, the place value is divided by a factor of 10
        // x % 10 extracts the last digit, x / 10 discards the last digit
        // These are used to manipulate and use the input number x as required.
        // The calls to Math.addExact() and Math.multiplyExact() are used so we can detect overflows and return 0 if one occurs.
        int placeValue = (int) Math.pow(10, Math.floor(Math.log10(x)));
        while (x > 0) {
            try {
                result = Math.addExact(result, Math.multiplyExact(x % 10, placeValue));
            }
            catch (ArithmeticException e) {
                return 0;
            }
            placeValue /= 10;
            x /= 10;
        }

        //Make any negative numbers negative again.
        return (isNegative) ? -1 * result : result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution7().reverse(1534236469));
    }
}