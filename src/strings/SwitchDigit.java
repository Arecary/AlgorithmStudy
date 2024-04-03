package strings;

public class SwitchDigit {

  public static void main(String[] args) {

    String s = "a1b2c3";
    String result = switchDigit(s);
    System.out.println("result is : "+ result);


  }



  /**
   * 给定一个字符串 s，它包含小写字母和数字字符，请编写一个函数，将字符串中的字母字符保持不变，而将每个数字字符替换为number。
   * @param s 例如，对于输入字符串 "a1b2c3"。
   * @return 函数应该将其转换为 "anumberbnumbercnumber"。
   */
  static public String switchDigit(String s) {
    StringBuilder sb = new StringBuilder();
    String result = "";

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)){
        sb.append("number");
      } else {
        sb.append(c);
      }

    }

    result = sb.toString();

    return result;
  }
}
