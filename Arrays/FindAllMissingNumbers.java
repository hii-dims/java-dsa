import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

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

        List<Integer> result = new ArrayList<>();

        for (i = 0; i < nums.length; i++) {

            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }

        return result;
    }
}