class Solution {
    public void cyclicSort(int[] nums) {

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
    }
}