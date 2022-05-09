//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 链表 
// 👍 1091 👎 0

package leetcode.editor.cn;
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1){
            return head;
        }
        ListNode newHead = null;
        ListNode beforeTail = null;
        while (head != null){
            if(beforeTail != null){
                beforeTail.next = head;
            }
            ListNode tail = getNextK(head, k-1);
            if(tail == null){
                if(newHead == null){
                    newHead = head;
                }
                break;
            }
            ListNode nextHead = tail.next;
            ListNode tmp = head;
            if(newHead == null){
                newHead = tail;
            }
            ListNode pre = null;
            int n = k;
            while (n > 0){
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
                n--;
            }
            if(beforeTail != null){
                beforeTail.next = pre;
            }
            beforeTail = tmp;
            head = nextHead;
        }

        return newHead;
    }

    private ListNode getNextK(ListNode node, int k){
        if(node == null){
            return null;
        }
        while (k>0 && node != null){
            node = node.next;
            k--;
        }
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}