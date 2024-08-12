package glint.homework;

public class Glint0808 {


  public static void main(String[] args) {

    int num1 = 10;
    int num2 = 0;
    try {
      int res = doDiv(num1, num2);
      System.out.println("res is " + res);
    } catch (MyException e) {
      System.out.println("Caught exception: " + e.getMessage());
      e.printStackTrace();
    } finally {
      System.out.println("input num1 is " + num1);
      System.out.println("input num2 is " + num2);
    }

  }



  public static int doDiv(int num1, int num2){
    if (num2 == 0) {
      throw new MyException("The dividend cannot be 0 ");
    }

    return num1/num2;
  }

}

class MyException extends RuntimeException{

  public MyException() {
  }

  public MyException(String message) {
    super(message);
  }
}
