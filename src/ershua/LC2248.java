package ershua;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class LC2248 {


  public List<Integer> intersection(int[][] nums) {
    HashMap<Integer, Integer> record = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums[i].length; j++) {
        record.put(nums[i][j], record.getOrDefault(nums[i][j],0) + 1);
      }
    }

    List<Integer> res = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : record.entrySet() ) {
      if (entry.getValue() >= nums.length) {
        res.add(entry.getKey());
      }
    }

    Collections.sort(res);
    return res;

  }

}
