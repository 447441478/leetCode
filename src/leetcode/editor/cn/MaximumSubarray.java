//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：nums = [-100000]
//输出：-100000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 3194 👎 0

package leetcode.editor.cn;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int[][] cache = new int[nums.length+1][nums.length+1];
            for (int i = 0; i < cache.length; i++) {
                for (int j = 0; j < cache[i].length; j++) {
                    cache[i][j] = Integer.MIN_VALUE;
                }
            }
            try {
                return process(nums,0, nums.length, cache);
            }finally {
                //System.out.println("count="+count);
            }
        }
        int count = 0;
        public int process(int[] nums, int L, int R, int[][]cache) {
            if (L > R || L == nums.length) {
                return Integer.MIN_VALUE;
            }
            if(cache[L][R] != Integer.MIN_VALUE){
                count++;
                return cache[L][R];
            }
            if (L == R) {
                return nums[L];
            }
            int sum = 0;
            for (int i = L; i < R; i++) {
                sum += nums[i];
            }
            int ans = Math.max(sum, Math.max(process(nums,L+1, R, cache), process(nums, L, R-1, cache)));
            cache[L][R] = ans;
            return ans;
        }
        public int dp(int[] nums){
           int preSum = 0, ans = nums[0];
            for (int num : nums) {
                preSum = Math.max(preSum + num, num);
                ans = Math.max(preSum, ans);
            }
           return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}