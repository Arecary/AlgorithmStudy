package glint.homework;

public class Glint0805 {

  public static void main(String[] args) {
    printPatternNumber();
    printPatternHash();

  }


  public static void printPatternNumber() {
    int n = 5;
    for (int i = n; i > 0; i--) {
      int j = 1;
      while ( j <= i) {
        System.out.print(j + " ");
        j++;
      }
      System.out.println();
    }
  }


  public static void printPatternHash() {
    int n = 5;
    for (int i = 0; i < n; i++) {
      int j = -1;
      while ( j < i) {
        System.out.print("#" + " ");
        j++;
      }
      System.out.println();
    }

  }


}
