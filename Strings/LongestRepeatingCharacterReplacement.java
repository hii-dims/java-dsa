import java.util.HashMap;
import java.util.Map;

class Solution {

    public int characterReplacement(String s, int k) {

        int start = 0;
        int maxLen = 0;
        int maxFreq = 0;

        Map<Character, Integer> charCount = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {

            char ch = s.charAt(end);

            charCount.put(
                ch,
                charCount.getOrDefault(ch, 0) + 1
            );

            maxFreq = Math.max(
                maxFreq,
                charCount.get(ch)
            );

            while ((end - start + 1) - maxFreq > k) {

                char leftChar = s.charAt(start);

                charCount.put(
                    leftChar,
                    charCount.get(leftChar) - 1
                );

                start++;
            }

            maxLen = Math.max(
                maxLen,
                end - start + 1
            );
        }

        return maxLen;
    }
}