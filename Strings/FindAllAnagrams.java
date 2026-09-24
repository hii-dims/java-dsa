import java.util.*;

public class FindAllAnagrams {

    public static List<Integer> findAnagrams(
            String s,
            String p) {

        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        Map<Character, Integer> required = new HashMap<>();

        for (char ch : p.toCharArray()) {
            required.put(
                ch,
                required.getOrDefault(ch, 0) + 1
            );
        }

        Map<Character, Integer> window = new HashMap<>();

        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);

            window.put(
                rightChar,
                window.getOrDefault(rightChar, 0) + 1
            );

            // Keep window size equal to p.length()
            if (right - left + 1 > p.length()) {

                char leftChar = s.charAt(left);

                window.put(
                    leftChar,
                    window.get(leftChar) - 1
                );

                if (window.get(leftChar) == 0) {
                    window.remove(leftChar);
                }

                left++;
            }

            // Check if current window is an anagram
            if (right - left + 1 == p.length()
                    && window.equals(required)) {

                result.add(left);
            }
        }

        return result;
    }
}