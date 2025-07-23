import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution17 {
    public List<String> letterCombinations(String digits) {
        /*
        Stores the mapping from digits to all letters they can represent.
        In order to index into this mapping, we can convert a character like '4' by subtracting 50 from it
        i.e. first subtract 48 to get to the number from its ASCII value,
        then a further 2 since the mapping for 4 is at index 2 in the array
         */
        List<String>[] mapping = new List[]{
                /*2: */Arrays.asList("a", "b", "c"),
                /*3: */Arrays.asList("d", "e", "f"),
                /*4: */Arrays.asList("g", "h", "i"),
                /*5: */Arrays.asList("j", "k", "l"),
                /*6: */Arrays.asList("m", "n", "o"),
                /*7: */Arrays.asList("p", "q", "r", "s"),
                /*8: */Arrays.asList("t", "u", "v"),
                /*9: */Arrays.asList("w", "x", "y", "z")
        };

        List<String> result = new ArrayList<>();

        for (char digit : digits.toCharArray()) {
            List<String> possibleLetters = mapping[digit - 50];
            if (result.isEmpty()) {
                result = possibleLetters;
            } else {
                List<String> newResult = new ArrayList<>();
                for (String res : result) {
                    for (String newLetter : possibleLetters) {
                        newResult.add(res + newLetter);
                    }
                }
                result = newResult;
            }
        }
        return result;
    }

     public static void main(String[] args) {
         System.out.println(new Solution17().letterCombinations("233"));
     }
}