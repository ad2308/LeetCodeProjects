class Solution13 {
    public int romanToInt(String s) {
        int result = 0;
        int previousValue = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int currentValue = processOneCharacter(s.charAt(i));
            if (currentValue > previousValue) {
                result -= previousValue;
            }
            else {
                result += previousValue;
            }
            previousValue = currentValue;
        }
        return result + previousValue;
    }

    private int processOneCharacter(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        System.out.println(new Solution13().romanToInt("MCMXCIV"));
    }
}