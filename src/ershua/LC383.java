package ershua;

import java.util.HashMap;

public class LC383 {

  public boolean canConstruct(String ransomNote, String magazine) {

    char[] mag = magazine.toCharArray();
    HashMap<Character, Integer> record = new HashMap<>();
    for (char c : mag) {
      record.put(c, record.getOrDefault(c, 0) + 1);
    }

    char[] rans = ransomNote.toCharArray();
    for (char c : rans) {
      if (!record.containsKey(c)) {
        return false;
      }
      if(record.get(c) == 0){
        return false;
      }
      record.put(c, record.getOrDefault(c, 0) - 1);
    }
    return true;
  }


}
