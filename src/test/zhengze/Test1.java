package test.zhengze;

public class Test1 {

  public static void main(String[] args) {

    String rule = "19\\d\\d";  // 表示判断字符串是不是19xx
    String input1 = "1918";
    String input2 = "19AC";

    System.out.println(input1.matches(rule)); // ture
    System.out.println(input2.matches(rule)); // false

  }

}
