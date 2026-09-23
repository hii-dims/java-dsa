public class HappyNumber {

    public static boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        while (true) {

            slow = sumOfSquares(slow);

            fast = sumOfSquares(sumOfSquares(fast));

            if (fast == 1) {
                return true;
            }

            if (slow == fast) {
                return false;
            }
        }
    }

    private static int sumOfSquares(int n) {

        int sum = 0;

        while (n > 0) {

            int digit = n % 10;

            sum += digit * digit;

            n /= 10;
        }

        return sum;
    }
}