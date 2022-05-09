//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3546 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome1(String s) {
            if (s == null || s.length() < 2) {
                return s;
            }
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expandAroundCenter(s, i, i);
                int len2 = expandAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - ((len - 1) >> 1);
                    end = i + (len >> 1);
                }
            }
            return s.substring(start, end + 1);
        }

        public int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                --left;
                ++right;
            }
            return right - left - 1;
        }


        public String longestPalindrome(String s) {
            if (s == null || s.length() < 2) {
                return s;
            }
            char[] chars = fillStr(s);
            int[] dp = new int[chars.length];
            int R = -1;
            int C = -1;
            int index = 0;
            int max = 0;
            int beg = -1;
            while (index < chars.length){
                dp[index] = R > index ? Math.min(R-index, dp[2*C-index]) :1;
                while (index-dp[index]>=0 && index+dp[index] < chars.length && chars[index-dp[index]] == chars[index+dp[index]])
                    dp[index]++;
                if(index+dp[index] > R){
                    R = index+dp[index];
                    C = index;
                }
                if(dp[index] >max){
                    beg = index-dp[index];
                    max = dp[index];
                }
                index++;
            }
            return s.substring((beg+1)/2, (beg+1)/2+max-1);
        }

        private char[] fillStr(String s) {
            char[] arr = new char[s.length()*2+1];
            arr[0] = '*';
            for (int i = 0; i < s.length(); i++) {
                arr[i*2+1] = s.charAt(i);
                arr[i*2+2] = arr[0];
            }
            return arr;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}