package strings;


/**
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2
 * <p>
 * 示例 2: 输入: haystack = "aaaaa", needle = "bba" 输出: -1
 */
public class strStr_28 {


  public static void main(String[] args) {
    String input = "mississippi";
    String target = "issipi";

    System.out.println(strStr(input, target));

  }

  // 暴力循环
  static public int strStr(String haystack, String needle) {

    StringBuilder sb = new StringBuilder();
    int pointer = 0;
    int start = 0;

    if (haystack.length() == 0 && needle.length() == 0){
      return start;
    }

    if (haystack.length() < needle.length()) {
      return -1;
    }

    for (int i = 0; i < haystack.length(); i++) {
      if (haystack.charAt(i) == needle.charAt(pointer)) {
        start = i;


        for (int j = i; j < needle.length() + i; j++) {
          if (j >= haystack.length()) {
            return -1;
          }

          if (haystack.charAt(j) == needle.charAt(pointer)) {
            sb.append(haystack.charAt(i));
            pointer++;
            if (sb.length() == needle.length()) {
              return start;
            }
          }else {
            pointer = 0;
            sb.setLength(0);
            break;
          }

        }
      }
    }
    return -1;
  }


  // KMP算法
  //前缀表（不减一）Java实现
  public int strStr1(String haystack, String needle) {
    if (needle.length() == 0) return 0;
    int[] next = new int[needle.length()];
    getNext(next, needle);

    int j = 0;
    for (int i = 0; i < haystack.length(); i++) {
      while (j > 0 && needle.charAt(j) != haystack.charAt(i))
        j = next[j - 1];
      if (needle.charAt(j) == haystack.charAt(i))
        j++;
      if (j == needle.length())
        return i - needle.length() + 1;
    }
    return -1;

  }

  private void getNext(int[] next, String s) {
    //初始化
    int j = 0;
    next[0] = 0;

    for (int i = 1; i < s.length(); i++) {
      //前后缀不匹配的情况
      while (j > 0 && s.charAt(j) != s.charAt(i))
        j = next[j - 1];
      //前后缀匹配的情况
      if (s.charAt(j) == s.charAt(i))
        j++;
      //更新next表
      next[i] = j;
    }
  }

}
