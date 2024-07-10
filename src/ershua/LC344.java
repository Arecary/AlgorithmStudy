package ershua;

public class LC344 {


  public void reverseString(char[] s) {
    int right = s.length-1;
    for (int i = 0; i < s.length; i++) {
      if (i >= right) {
        break;
      }
      char temp = s[right];
      s[right] = s[i];
      s[i] = temp;
      right--;
    }
  }


}
