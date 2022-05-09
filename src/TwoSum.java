import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/two-sum/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>(nums.length*4/3+1);
        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(target - nums[i]);
            if(j != null && i != j){
                res[0] = j;
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
