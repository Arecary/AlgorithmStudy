package ershua;

import java.util.ArrayList;

public class LC151 {

  public String reverseWords(String s) {
    if (s.isEmpty()) {
      return s;
    }
    char[] charList = s.toCharArray();
    StringBuilder item = new StringBuilder();
    String res = "";
    for (int i = 0; i < charList.length; i++) {

      if (i == 0 || i == charList.length - 1) {
        if (i == charList.length - 1 && charList[i] == ' ' && res.isEmpty()) {
          return item.toString();
        }
        if (charList[i] == ' ') {
          continue;
        }
      }

      if (charList[i] == ' ' && charList[i - 1] == ' ') {
        continue;
      }

      if (charList[i] == ' ') {
        if (res.isEmpty()) {
          res = item.toString();
        }else {
          res = item.toString() + " " + res;
        }

        item.setLength(0);
        continue;
      }

      if (i == charList.length - 1) {
        item.append(charList[i]);
        if (res.isEmpty()) {
          res = item.toString();
        }else {
          res = item.toString() + " " + res;
        }
        break;
      }

      item.append(charList[i]);
    }
    return res;
  }


  public String reverseWords2(String s) {
    StringBuilder ab = new StringBuilder();
    String[] words = s.split(" +");
    for (int i = words.length - 1; i >= 0; i--) {
      ab.append(words[i]);
      ab.append(" ");
    }
    return ab.toString().trim();
  }

}
