package strings;

import java.util.Scanner;

public class RightRotateString {

  public static void main(String[] args) {
    String[] testStrs = {"abcdefg", "hello", "123456", "a", "abcdefgh"};
    int[] rotations = {2, 3, 1, 1, 5};
    String[] expectedResults = {"fgabcde", "llohe", "612345", "a", "defghabc"};

    for (int i = 0; i < testStrs.length; i++) {
      String result = rightRotateString(testStrs[i], rotations[i]);
      boolean isCorrect = result.equals(expectedResults[i]);
      System.out.println("输入: " + testStrs[i] + ", " + rotations[i]);
      System.out.println("输出: " + result);
      System.out.println("预期: " + expectedResults[i]);
      System.out.println("是否正确: " + isCorrect);
      System.out.println();
    }

  }


  public static String rightRotateString(String str, int d) {
    String result = "";
    StringBuilder noRotate = new StringBuilder();
    StringBuilder rotate = new StringBuilder();
    int len = str.length() - d;

    for (int i = 0; i < str.length(); i++) {
      if (i < len) {
        noRotate.append(str.charAt(i));
      }else {
        rotate.append(str.charAt(i));
      }
    }
    result = rotate.append(noRotate).toString();
    return result;

  }







  // 不使用额外空间
  // 把原字符串分成两节，先整体翻转一次，这样第一段就是末尾了但是字符的顺序不对，那么把两节分别单独翻转一次。每节里的顺序就对了
  public static void main1(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = Integer.parseInt(in.nextLine());
    String s = in.nextLine();

    int len = s.length();  //获取字符串长度
    char[] chars = s.toCharArray();
    reverseString(chars, 0, len - 1);  //反转整个字符串
    reverseString(chars, 0, n - 1);  //反转前一段字符串，此时的字符串首尾尾是0,n - 1
    reverseString(chars, n, len - 1);  //反转后一段字符串，此时的字符串首尾尾是n,len - 1

    System.out.println(chars);

  }

  public static void reverseString(char[] ch, int start, int end) {
    //异或法反转字符串，参照题目 344.反转字符串的解释
    while (start < end) {
      ch[start] ^= ch[end];
      ch[end] ^= ch[start];
      ch[start] ^= ch[end];
      start++;
      end--;
    }
  }

}
