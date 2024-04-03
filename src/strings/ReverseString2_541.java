package strings;

public class ReverseString2_541 {

  public static void main(String[] args) {
    String s = "abcdefg";
    int k = 2;
    System.out.println(reverseStr(s, k));


  }


  static public String reverseStr(String s, int k) {
    String result;
    char[] res = new  char[s.length()];

    for(int i = 0; i < s.length(); i += 2 * k){

      int start = i;
      int end = Math.min(i + 2*k, s.length());
      int mid = Math.min(i + k, s.length());

      for (int j = start; j < mid; j++) {
        char c = s.charAt(j);
        //当 j == start 时，目标索引是 start + mid - start - 1 = mid - 1。
        //当 j == start + 1 时，目标索引是 start + mid - (start + 1) - 1 = mid - 2。
        //依此类推...
        res[start + mid - j - 1] = c;
      }

      for (int j = mid; j < end; j++) {
        char c = s.charAt(j);
        res[j] = c;
      }
    }

    result = new String(res);

    return result;
  }



  // 把原字符串分割成2k一组的区间，对于每个区间内按照反转字符串的操作来进行
  public String reverseStr1(String s, int k) {
    // 先把字符串变成char数组，这样就和第344题一样操作了
    char[] ch = s.toCharArray();
    for(int i = 0;i < ch.length;i += 2 * k){
      int start = i;
      // 判断尾数够不够k个来取决end指针的位置
      int end = Math.min(ch.length - 1,start + k - 1);
      while(start < end){

        char temp = ch[start];
        ch[start] = ch[end];
        ch[end] = temp;

        start++;
        end--;
      }
    }
    return new String(ch);
  }



}
