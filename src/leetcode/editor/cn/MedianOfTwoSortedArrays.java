//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3737 👎 0

package leetcode.editor.cn;
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m  = nums1.length;
        int n = nums2.length;
        int left1 = 0,left2=0;

        int midIdx = (m+n-1)>>>1;
        int lastNum = Integer.MIN_VALUE;
        while (left1+left2 <= midIdx){
            if(left1 == m){
                lastNum = nums2[left2];
                left2++;
                continue;
            }
            if(left2 == n){
                lastNum = nums1[left1];
                left1++;
                continue;
            }
            int num1 = nums1[left1];
            int num2 = nums2[left2];
            if(lastNum <= num1 && num1 <= num2){
                lastNum = num1;
                left1++;
                continue;
            }
            if(lastNum <= num2){
                lastNum = num2;
                left2++;
                continue;
            }
        }
        if(((m+n)&1) == 1){
            return lastNum;
        }
        int nextNum = Integer.MIN_VALUE;
        if(left1 == m){
            nextNum = nums2[left2];
        }
        if(left2 == n){
            nextNum = nums1[left1];
        }
        if(nextNum == Integer.MIN_VALUE){
            nextNum = Math.min(nums1[left1], nums2[left2]);
        }
        return (lastNum+nextNum)/2.0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}