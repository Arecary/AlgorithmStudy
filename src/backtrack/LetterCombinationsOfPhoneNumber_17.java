package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
public class LetterCombinationsOfPhoneNumber_17 {

  // 思路：
  // 模仿77题
  // 比如给了234，那么我们拥有的[abc], [def], [ghi]三个集合
  // 此时可以得到的组合必须得是3个长度

  List<String> result = new ArrayList<>();
  String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
  Set<Character> validDigits = new HashSet<>(Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9'));

  StringBuilder combine = new StringBuilder();


  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.isEmpty()) {
      return result;
    }
//    StringBuilder sb = new StringBuilder();
    ArrayList<String> list = new ArrayList<>();

    for (int i = 0; i < digits.length(); i++) {
      char element = digits.charAt(i);
      if (validDigits.contains(element)) {
        list.add(mapping[element - '0']);
      }
    } // 到了这一步，我们有一个stringBuilder，包含了给定digit代表的字母
    backtrack(list, 0);
    return result;

  }

  // index 代表现在看第几个数字了。比如数字23，那么index 0代表现在是从2代表的string里挑选
  private void backtrack(ArrayList<String> list, int index) {
    if (index == list.size()) {
      result.add(combine.toString());
      return;
    }

    String s = list.get(index);

    for (int i = 0; i < s.length(); i++) {
      combine.append(s.charAt(i));
      backtrack(list, index + 1);
      combine.deleteCharAt(combine.length() - 1);
    }
  }

}
