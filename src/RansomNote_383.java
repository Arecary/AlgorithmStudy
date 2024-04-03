import java.util.HashSet;
import java.util.Set;

public class RansomNote_383 {

  public boolean canConstruct(String ransomNote, String magazine) {

    int[] Char = new int[26];

    for (char c : magazine.toCharArray()) {
      int i =  c - 'a';
      Char[i] += 1;

    }

    for (char c : ransomNote.toCharArray()) {
      int i = c-'a';
      Char[i] -= 1;
      if (Char[i] < 0) {
        //break;
        return false;
      }
    }

    return true;

  }



}
