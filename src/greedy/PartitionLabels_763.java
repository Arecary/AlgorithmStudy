package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels_763 {

  public static void main(String[] args) {
    String s = "ababcbacadefegdehijhklij";
    partitionLabels(s);

  }

  public static List<Integer> partitionLabels(String s) {

    HashMap<Character, Integer> map = new HashMap<>();
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      map.put(c, i);
    }

    int count = 1;
    int end = 0;
    char[] chars = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      int index = map.get(chars[i]);
      end = Math.max(end, index);
      if (i == end) { // 当前字符的索引是当前字符串的最后一个索引，说明当前字符串已经遍历完了
        result.add(count);
        count = 1;
      }else {
        count++;
      }
    }

    return result;
  }


}
