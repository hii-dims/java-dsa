import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> required = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            required.put(
                ch,
                required.getOrDefault(ch, 0) + 1
            );
        }

        Map<Character, Integer> window = new HashMap<>();

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {

            char rightChar = s2.charAt(right);

            window.put(
                rightChar,
                window.getOrDefault(rightChar, 0) + 1
            );

            // Keep window size equal to s1.length()
            if (right - left + 1 > s1.length()) {

                char leftChar = s2.charAt(left);

                window.put(
                    leftChar,
                    window.get(leftChar) - 1
                );

                if (window.get(leftChar) == 0) {
                    window.remove(leftChar);
                }

                left++;
            }

            // Compare frequencies
            if (right - left + 1 == s1.length()
                    && window.equals(required)) {

                return true;
            }
        }

        return false;
    }
}