public class BackspaceStringCompare {

    public static boolean backspaceCompare(String s, String t) {

        int i = s.length() - 1;
        int j = t.length() - 1;

        int skipS = 0;
        int skipT = 0;

        while (i >= 0 || j >= 0) {

            // Find next valid character in s
            while (i >= 0) {

                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;

                } else if (skipS > 0) {
                    skipS--;
                    i--;

                } else {
                    break;
                }
            }

            // Find next valid character in t
            while (j >= 0) {

                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;

                } else if (skipT > 0) {
                    skipT--;
                    j--;

                } else {
                    break;
                }
            }

            // Get next valid characters
            char charS = i >= 0 ? s.charAt(i) : '\0';
            char charT = j >= 0 ? t.charAt(j) : '\0';

            // Compare
            if (charS != charT) {
                return false;
            }

            // Move past the characters we just compared
            i--;
            j--;
        }

        return true;
    }
}