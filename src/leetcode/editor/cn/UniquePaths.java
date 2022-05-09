//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 109 
// 
// Related Topics 数组 动态规划 
// 👍 979 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;

public class UniquePaths {
    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();
        solution.dp(3,7);
        LinkedList<Integer> list = new LinkedList<>();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            long ans = 1;
            for (int x = n, y = 1; y < m; ++x, ++y) {
                ans = ans * x / y;
            }
            return (int)ans;
        }
        public int uniquePaths1(int m, int n) {
            //return process(m, n);
            int[][] cache = new int[m][n];
            cache[m-1][n-1] = 1;
            return process(0, 0, m - 1, n - 1, cache);
        }

        /**
         * 从 m,n 到 M,N 有多少种解法
         */
        private int process(int m, int n, int M, int N, int[][] cache) {
            if (m > M || n > N) {
                return 0;
            }
            if(cache[m][n] != 0){
                return cache[m][n];
            }
            int ans = process(m + 1, n, M, N, cache) + process(m, n + 1, M, N, cache);
            cache[m][n] = ans;
            return ans;
        }

        public int dp(int m, int n){
            if (n == Math.min(m, n)){
                m = m^n;
                n = m^n;
                m = m^n;
            }
            int[] dp = new int[m+1];
            Arrays.fill(dp, 1);
            dp[0] = 0;
            for (int i = 1; i < n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[j] = dp[j]+dp[j-1];
                }
            }
            return dp[m];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}