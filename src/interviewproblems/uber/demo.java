package interviewproblems.uber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class demo {

  public static void main(String[] args) {
    int[] nums = {1, 2, 1, 3, 4};
    List<Integer> array = Arrays.asList(1, 2, 1, 1);
    System.out.println(oa25(nums, 2));
    System.out.println(oa25New(nums, 2));
  }

  // 一组positive int, 按照 奇数偶数奇数这样的规则排列，找出最先违背排列规则的index。
  // 假设每组int都一定有这么一个数
  public static int findIndex(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i % 2 == 0) {
        if (nums[i] % 2 == 0) {
          res = i;
          break;
        }
      } else {
        if (nums[i] % 2 != 0) {
          res = i;
          break;
        }
      }
    }

    return res;
  }


  // 25. *** 频率：2
  /* 給一個array, 要求找出多少個subarray 可以滿足 最少有 >=k 的unique chars appeared only once
  ex:
  [1,2,3,4,1], k = 2
  [1,2]
  [1,2,3]
  [1,2,3,4]
  [2,3]
  [3,4,1]
  etc. */
  // 第一想法：brute force

  public static int oa25(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int res = 0;

    for (int i = 0; i < nums.length; i++) {
      HashSet<Integer> record = new HashSet<>();
      record.add(nums[i]);

      for (int j = i + 1; j < nums.length; j++) {
        if (record.contains(nums[j])) {
          break;
        }
        if (record.size() < k) {
          record.add(nums[j]);
          if (record.size() == k) {
            res++;
          }
        } else {
          record.add(nums[j]);
          res++;
        }
      }
    }
    return res;
  }

  public static int oa25New(int[] nums, int k) {
    Set<Integer> visited = new HashSet<>();
    int l = 0;
    int ans = 0;
    for (int r = 0; r < nums.length; r++) {
      if (visited.contains(nums[r])) {
        // 移动左指针，直到没有重复元素
        while (true) {
          boolean canBreak = nums[l] == nums[r];
          visited.remove(nums[l]);
          l++;
          if (canBreak) {
            break;
          }
        }
      }
      visited.add(nums[r]);
      int len = r - l + 1;
      if (len >= k) {
        // 计算以 nums[r] 结尾的所有符合条件的子数组数量
        ans += len - k + 1;
      }
    }
    return ans;
  }

}
