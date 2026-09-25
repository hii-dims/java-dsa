import java.util.*;

class Solution {

    public int[][] intervalIntersection(
            int[][] firstList,
            int[][] secondList) {

        List<int[]> ans = new ArrayList<>();

        int start = 0;
        int end = 0;

        int s, e;

        while (start < firstList.length &&
               end < secondList.length) {

            s = Math.max(
                firstList[start][0],
                secondList[end][0]
            );

            e = Math.min(
                firstList[start][1],
                secondList[end][1]
            );

            if (e >= s) {
                ans.add(new int[]{s, e});
            }

            if (firstList[start][1] == e) {
                start++;
            }

            if (secondList[end][1] == e) {
                end++;
            }
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}