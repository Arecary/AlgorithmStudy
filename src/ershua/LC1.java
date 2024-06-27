package ershua;

import java.util.HashMap;
import java.util.HashSet;

public class LC1 {

  public int[] twoSum(int[] nums, int target) {
    int[] res = new int[2];
    if(nums == null || nums.length == 0){
      return res;
    }
    HashMap<Integer, Integer> record = new HashMap<>();


    for (int i = 0; i < nums.length; i++) {
      if (record.containsKey(target - nums[i])){
        res[0] = i;
        res[1] = record.get(target - nums[i]);
        return res;
      }else {
        record.put(nums[i], i);
      }
    }
    return res;
  }


}
