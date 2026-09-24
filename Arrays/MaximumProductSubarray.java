public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {

        int currentMax = nums[0];
        int currentMin = nums[0];
        int maxProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int num = nums[i];

            int newMax = Math.max(
                num,
                Math.max(
                    currentMax * num,
                    currentMin * num
                )
            );

            int newMin = Math.min(
                num,
                Math.min(
                    currentMax * num,
                    currentMin * num
                )
            );

            currentMax = newMax;
            currentMin = newMin;

            maxProduct = Math.max(
                maxProduct,
                currentMax
            );
        }

        return maxProduct;
    }
}