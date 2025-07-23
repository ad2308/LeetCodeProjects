class Solution20 {
    public boolean isValid(String s) {
        char[] openBraceStack = new char[s.length()];
        int head = 0;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                openBraceStack[head] = c;
                head++;
            }
            else if (c == ')' || c == '}' || c == ']') {
                if (head == 0) return false;
                char opposite = switch (c) {
                    case ')' -> '(';
                    case '}' -> '{';
                    case ']' -> '[';
                    default -> throw new IllegalStateException("Unexpected value: " + c);
                };
                if (openBraceStack[head-1] != opposite) return false;
                head--;
            }
        }
        return head == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution20().isValid("["));
    }
}