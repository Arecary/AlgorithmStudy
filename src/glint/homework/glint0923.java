package glint.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class glint0923 {


  /*
  Give an array, you need to find all the pairs in the array whose sum is K.
input-
arr = [3,1,4,5,6], K=7
Only positive unique integers
output-
3,4
1,6
   */

  public static List<int[]> findPairs (int[] arr, int k) {
    List<int[]> result = new ArrayList<>();

    if (arr == null || arr.length == 0) {
      return result;
    }

    HashSet<Integer> record = new HashSet<>();

    for (Integer num : arr) {
      int temp = k - num;
      if (record.contains(temp)) {
        int[] res = new int[]{num, temp};
        result.add(res);
      }

      record.add(num);

    }

    return result;

  }

  public static void main(String[] args) {
    int[] arr = {3, 1, 4, 5, 6};
    int k = 7;
    List<int[]> pairs = findPairs(arr, k);
    for (int[] pair : pairs) {
      System.out.println(pair[0] + "," + pair[1]);
    }
  }



}
