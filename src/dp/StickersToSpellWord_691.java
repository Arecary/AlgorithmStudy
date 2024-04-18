package dp;

import java.util.Arrays;
import java.util.HashMap;

public class StickersToSpellWord_691 {

  public static void main(String[] args) {
    String[] stickers = new String[]{"with","example","science"};
    String target = "thehat";
    int res = minStickers3(stickers, target);
    System.out.println(res);


  }


  public int minStickers1(String[] stickers, String target) {
    int ans = process1(stickers, target);
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }


  // 递归法
  // 从当前target开始，能怎么组合。已经组合的部分就不管了，去掉了。
  public static int process1(String[] stickers, String target) {
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
    return min + (min == Integer.MAX_VALUE ? 0 : 1);

  }


  // 返回target中哪些字符没被first贴纸用完了
  public static String minus(String target, String first) {

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
          builder.append((char) (i + 'a'));
        }
      }
    }

    return builder.toString();
  }


  // 剪枝法
  // 用一个int二维数组表示原来的贴纸，比如原来贴纸是"aab"和"bcc"
  // 那么转化成二维数组就是[[2,1,0,0,0...],[0,1,2,0,0...]]
  // 二维数组第一个值表示第几个贴纸，第二个值表示当前贴纸里第几个字母的个数，所以每一个子数组都应该是26长度。

  public  static int minStickers2(String[] stickers, String target) {
    int N = stickers.length;
    int[][] counts = new int[N][26];

    for (int i = 0; i < N; i++) {
      char[] str = stickers[i].toCharArray();
      for (char c : str ) {
        counts[i][c - 'a']++;
      }
    }
    int ans = process2(counts, target);
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }


  public static int process2(int[][] stickers, String target) {
    if (target.isEmpty()) {
      return 0;
    }

    // 把原来target转化成一个数组并且记录每个字母的个数，比如"abccd" = [1,1,2,1,0,0,0...]
    char[] target1 = target.toCharArray();
    int[] tCounts = new int[26];

    for (char c : target1) {
      tCounts[c - 'a']++;
    }

    int n = stickers.length;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      int[] sticker = stickers[i]; // 等于原来的一张一张试贴纸
      // 但是这里剪枝，如果当前试的贴纸里没有当前target的首字母，那就不用试了, 比如target是"bbcd", 试的贴纸是"aac"，那就不用试了, 因为总会剩下开头的b，以后还是得解决。
      if (sticker[target1[0] - 'a'] > 0) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 26; j++) {
          if (tCounts[j] > 0) {
            int nums = tCounts[j] - sticker[j];
            for (int k = 0; k < nums; k++) {
              sb.append((char) (j + 'a'));

            }
          }
        }
        String rest = sb.toString();
        min = Math.min(min, process2(stickers, rest));
      }
    }

    return min + (min == Integer.MAX_VALUE ? 0 : 1);
  }


  // dp记忆化搜索方法
  // 用一个哈希表存储，如果剩余字符串rest已经在表里记录过了，那么直接返回有多少种方法。

  public  static int minStickers3(String[] stickers, String target) {
    int N = stickers.length;
    int[][] counts = new int[N][26];

    for (int i = 0; i < N; i++) {
      char[] str = stickers[i].toCharArray();
      for (char c : str ) {
        counts[i][c - 'a']++;
      }
    }
    HashMap<String, Integer> dp = new HashMap<>();
    dp.put("", 0);
    int ans = process3(counts, target, dp);
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }
  public static int process3(int[][] stickers, String target, HashMap<String, Integer> dp){
    if (dp.containsKey(target)) {
      return dp.get(target);
    }

    // 把原来target转化成一个数组并且记录每个字母的个数，比如"abccd" = [1,1,2,1,0,0,0...]
    char[] target1 = target.toCharArray();
    int[] tCounts = new int[26];

    for (char c : target1) {
      tCounts[c - 'a']++;
    }

    int n = stickers.length;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      int[] sticker = stickers[i]; // 等于原来的一张一张试贴纸
      // 但是这里剪枝，如果当前试的贴纸里没有当前target的首字母，那就不用试了, 比如target是"bbcd", 试的贴纸是"aac"，那就不用试了, 因为总会剩下开头的b，以后还是得解决。
      if (sticker[target1[0] - 'a'] > 0) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 26; j++) {
          if (tCounts[j] > 0) {
            int nums = tCounts[j] - sticker[j];
            for (int k = 0; k < nums; k++) {
              sb.append((char) (j + 'a'));

            }
          }
        }
        String rest = sb.toString();
        min = Math.min(min, process3(stickers, rest, dp));
      }
    }
    int ans = min + (min == Integer.MAX_VALUE ? 0 : 1);
    dp.put(target,ans);
    return ans;
  }


}
