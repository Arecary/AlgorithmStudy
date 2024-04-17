package dp;

public class StickersToSpellWord_691 {


  public int minStickers(String[] stickers, String target) {
    int ans = process1(stickers, target);
    return ans == Integer.MAX_VALUE? -1: ans;
  }


  // 递归法
  // 从当前target开始，能怎么组合。已经组合的部分就不管了，去掉了。
  public static int process1(String[] stickers, String target){
    // 说明字符串已经组合完了
    if (target.isEmpty()) {
      return 0;
    }

    int min = Integer.MAX_VALUE;
    for (String first : stickers) {
      // 把贴纸里的每一个都和target试一试，看看能不能组合出一部分
      String rest = minus(target, first); // rest就是剩下的string
      if (rest.length() != target.length()) { // 如果剩下string的长度不等于原string长度，那么说明尝试的这个贴纸可以组合出一部分
        min = Math.min(min, process1(stickers, rest)); // 但是我们要求最少要多少次组合，所以每次递归回来要滤一下
      }
    }
    // 如果min还是Integer.MAX_VALUE，说明没有组合出任何部分
    return min + (min == Integer.MAX_VALUE? 0:1);

  }


  // 返回target中哪些字符没被first贴纸用完了
  public static String minus(String target, String first){

    char[] str1 = target.toCharArray();
    char[] str2 = first.toCharArray();
    int[] count = new int[26];

    for (char c : str1) {
      count[c - 'a']++;
    }

    for (char c : str2) {
      count[c - 'a']--;
    }

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < count.length; i++) {
      if (count[i] != 0) {
        while (count[i]-- > 0) {
          builder.append((char)(i + 'a'));
        }
      }
    }

    return builder.toString();
  }

}
