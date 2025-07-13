import java.util.*;

public class P22
{
    static class Solution {
        HashMap<Integer, List<String>> sols = new HashMap<>();
        public List<String> generateParenthesis(int n) {
            if (sols.get(n) != null) {
                return sols.get(n);
            }
            if (n == 0) {
                return Arrays.asList("");
            }
            List<String> prevSols = generateParenthesis(n-1);
            Set<String> currSols = new HashSet<>(prevSols.stream()
                    .map((String x) -> "(" + x + ")")
                    .toList());

            for (int i = 1; i < n; i++) {
                List<String> firstHalfPossibilities = generateParenthesis(i);
                List<String> secondHalfPossibilities = generateParenthesis(n-i);
                for (String a : firstHalfPossibilities) {
                    for (String b : secondHalfPossibilities) {
                        currSols.add(a+b);
                    }
                }
            }

            List<String> result = currSols.stream().toList();

            sols.put(n, result);

            return result;
        }
    }

    public static void main(String[] args)
    {
        List<String> result = (new Solution()).generateParenthesis(4);
        System.out.println(result);
        System.out.println(result.size());
    }
}
