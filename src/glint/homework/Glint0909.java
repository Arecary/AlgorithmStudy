package glint.homework;

public class Glint0909 {

  public static void main(String[] args) {

    int n = 7;
    printStarPattern(n);

  }

  public static void printStarPattern(int n) {
    int mid = (n + 1) / 2;

    for (int i = 1; i <= mid; i++) {
      for (int j = 1; j <= 2 * i - 1; j++) {
        System.out.print("*");
      }
      System.out.println();
    }

    for (int i = mid - 1; i >= 1; i--) {
      for (int j = 1; j <= 2 * i - 1; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public boolean isAgeValidToDrive(int age) {
    boolean isValid = true;
    if (age < 21) {
      isValid = false;
    }
    return isValid;
  }

}
