class Solution12 {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int multiplier = 1;
        while (num > 0) {
            result.insert(0, romanLookupTable(num % 10 * multiplier));
            num /= 10;
            multiplier *= 10;
        }
        return result.toString();
    }

    private String romanLookupTable(int num) {
        switch(num) {
            case 3000: return "MMM";
            case 2000: return "MM";
            case 1000: return "M";
            case 900: return "CM"  ;
            case 800: return "DCCC";
            case 700: return "DCC" ;
            case 600: return "DC"  ;
            case 500: return "D"   ;
            case 400: return "CD"  ;
            case 300: return "CCC" ;
            case 200: return "CC"  ;
            case 100: return "C"   ;
            case 90: return "XC"  ;
            case 80: return "LXXX";
            case 70: return "LXX" ;
            case 60: return "LX"  ;
            case 50: return "L"   ;
            case 40: return "XL"  ;
            case 30: return "XXX" ;
            case 20: return "XX"  ;
            case 10: return "X"   ;
            case 9: return "IX"  ;
            case 8: return "VIII";
            case 7: return "VII" ;
            case 6: return "VI"  ;
            case 5: return "V"   ;
            case 4: return "IV"  ;
            case 3: return "III" ;
            case 2: return "II"  ;
            case 1: return "I"   ;
            default: return ""    ;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution12().intToRoman(1994));
    }
}