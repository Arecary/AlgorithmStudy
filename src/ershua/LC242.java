package ershua;

import java.util.HashMap;


public class LC242 {

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }


    HashMap<Character, Integer> include = new HashMap<>();

    for (char c : s.toCharArray() ) {
      if (include.containsKey(c)) {
        include.put(c, include.get(c) + 1);
      }else {
        include.put(c, 1);
      }
    }

    for (char c : t.toCharArray()) {
      if (!include.containsKey(c) || include.get(c) == 0) {
        return false;
      }else {
        include.put(c, include.get(c) - 1);
      }
    }

    return true;

  }


}
