class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        int initial = 2 * numRows - 2;
        int firstAdd, secondAdd, i;

        for (int rowNum = 0; rowNum < numRows; rowNum++) {
            firstAdd = (rowNum == 0 || rowNum == numRows - 1) ? initial : initial - 2 * rowNum;
            secondAdd = (rowNum == 0 || rowNum == numRows - 1) ? initial :  2 * rowNum;
            i = rowNum;
            boolean isFirst = true;
            while (i < s.length()) {
                result.append(chars[i]);
                i += (isFirst) ? firstAdd : secondAdd;
                isFirst = !isFirst;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution6().convert("PAYPALISHIRING", 6));
    }
}