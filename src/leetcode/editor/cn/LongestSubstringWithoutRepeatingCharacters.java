//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4978 👎 0

package leetcode.editor.cn;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(" ".isEmpty());
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        if(s.isEmpty()){
            return maxLen;
        }
        int left=0,right= 0;
        HashSet<Character> set = new HashSet<>();
        while (right < s.length()){
            char c = s.charAt(right);
            if(!set.add(c)){
                maxLen = Math.max(maxLen, set.size());
                while (left < right){
                    char tmpc = s.charAt(left++);
                    if( tmpc != c){
                        set.remove(tmpc);
                        continue;
                    }
                    break;
                }
                set.add(c);
            }
            right++;
        }
        maxLen = Math.max(maxLen, set.size());
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}