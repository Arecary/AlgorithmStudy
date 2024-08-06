package glint.homework;

public class glint0802 {




  public static boolean isVowel1(char c) {
    c = Character.toLowerCase(c);
    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
      return true;
    } else {
      return false;
    }
  }


  public static boolean isVowel2(char c) {
    c = Character.toLowerCase(c);
    switch (c) {
      case 'a':
      case 'e':
      case 'i':
      case 'o':
      case 'u':
        return true;
      default:
        return false;
    }
  }



  public static int multiply(int a, int b) {
    int result = 0;
    boolean isNegative = false;

    if (a < 0 && b < 0) {
      a = -a;
      b = -b;
    } else if (a < 0) {
      a = -a;
      isNegative = true;
    } else if (b < 0) {
      b = -b;
      isNegative = true;
    }

    for (int i = 0; i < b; i++) {
      result += a;
    }

    return isNegative ? -result : result;
  }

}
