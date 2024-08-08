package glint.homework;

public class Glint0808 {


  public static void main(String[] args) {

    int age = -10;
    try {
      getAge(age);
    } catch (MyException e) {
      System.out.println("Caught exception: " + e.getMessage());
      e.printStackTrace();
    } finally {
      System.out.println("input age is " + age);
    }

  }


  /**
   * Method to get the age if it is valid.
   *
   * @param age the age to be checked
   * @return the valid age
   * @throws MyException if the age is less than 0
   */
  public static int getAge(int age){
    if (age < 0) {
      throw new MyException("age can not be less than 0");
    }
    return age;
  }

}

class MyException extends RuntimeException{

  public MyException() {
  }

  public MyException(String message) {
    super(message);
  }
}
