import java.util.*;

class Solution {
    public int[] findCorruptPair(int[] nums) {

        int i = 0;

        while (i < nums.length) {

            int correctIndex = nums[i] - 1;

            if (nums[i] != nums[correctIndex]) {

                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;

            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {

            if (nums[i] != i + 1) {

                int duplicate = nums[i];
                int missing = i + 1;

                return new int[]{duplicate, missing};
            }
        }

        return new int[]{-1, -1};
    }
}