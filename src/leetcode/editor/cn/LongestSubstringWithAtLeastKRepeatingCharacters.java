//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由小写英文字母组成 
// 1 <= k <= 105 
// 
// Related Topics 递归 分治算法 Sliding Window 
// 👍 380 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
        System.out.println(String.valueOf(('a' + (char)1)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubstring(String s, int k) {  // 递归
        if(s.length() < k){
            return 0;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < counts.length; i++) {
            if(counts[i] == 0){
                continue;
            }
            if(counts[i]<k){
                String[] subStrs = s.split(String.valueOf((char)('a' + i)));
                int ans = 0;
                for (String subStr : subStrs) {
                    ans = Math.max(ans, longestSubstring(subStr, k));
                }
                return ans;
            }
        }
        return  s.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}