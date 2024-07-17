package ershua;

public class LC28 {

  public static void main(String[] args) {
    String haystack = "sadbutsad";
    String needle = "sad";
    System.out.println(strStr(haystack, needle));
  }

  public static int strStr(String haystack, String needle) {
    if (needle == null || needle.isEmpty()) {
      return 0;
    }
    if (needle.length() > haystack.length()) {
      return -1;
    }
    char[] haystackList = haystack.toCharArray();
    char[] needleList = needle.toCharArray();
    int res = -1;
    for (int i = 0; i < haystackList.length; i++) {
      if (haystackList[i] == needleList[0]) {
        res = i;
        int index = i + 1;
        for (int j = 1; j < needleList.length; j++) {
          if (index >= haystackList.length) {
            return -1;
          }
          if (needleList[j] != haystackList[index]) {
            res = -1;
            break;
          }
          index++;
        }
      }
      if (res != -1) {
        return res;
      }
    }

    return res;
  }


}
