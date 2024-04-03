import java.util.HashMap;
import java.util.Map;

public class TwoSums_1 {


  // 这个方法解决不了case (3,3) target=6 的情况，因为我是先把所有元素放入map，再一一对比，
  // 所以如果出现相同值的元素，就会出问题，因为map里不能放相同的key：我将元素作为key, 索引作为value，所以相同值的元素，会覆盖掉之前的key。

  public int[] twoSum(int[] nums, int target) {
    int[] result = new int [2];
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int value = i;
      int key =  nums[i];
      map.put(key,value);
    }

    for (int i = 0; i < nums.length; i++) {
      int element1 = nums[i];
      int element2 = target - element1;
      if (map.containsKey(element2) && map.get(element2) != i) {
        result[0] = map.get(element1);
        result[1] = map.get(element2);

      }
    }
    return result;
  }


  // 改进方法：遍历数组，每遍历到一个元素，就看看target减去这个元素，是否在map里，如果在，直接返回结果，如果不在，就继续遍历
  public int[] twoSum1(int[] nums, int target) {
    int[] res = new int[2];
    if(nums == null || nums.length == 0){
      return res;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++){
      int temp = target - nums[i];   // 遍历当前元素，并在map中寻找是否有匹配的key
      if(map.containsKey(temp)){
        res[1] = i;
        res[0] = map.get(temp);
        break;
      }
      map.put(nums[i], i);    // 如果没找到匹配对，就把访问过的元素和下标加入到map中
    }
    return res;
  }

}
