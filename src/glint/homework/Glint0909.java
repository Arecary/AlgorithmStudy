package glint.homework;

public class Glint0909 {


  public boolean isAgeValidToDrive(int age) {
    boolean isValid = true;
    if (age < 21) {
      isValid = false;
    }
    return isValid;
  }

}
