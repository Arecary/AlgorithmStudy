package glint.homework.hw0806;


class Main{
  public static void main(String[] args) {
    ScientificCalculator s = new ScientificCalculator();
    double res = s.log(5,25);
    System.out.println(res); // res = 2.0

  }
}

public class Calulator {

  public Calulator() {
  }

  /**
   * Adds two numbers.
   *
   * @param a the first number
   * @param b the second number
   * @return the sum of a and b
   */
  public double sum(double a, double b) {
    return a + b;
  }

  /**
   * Subtracts the second number from the first number.
   *
   * @param a the first number
   * @param b the second number
   * @return the difference of a and b
   */
  public double sub(double a, double b) {
    return a - b;
  }


  /**
   * Multiplies two numbers.
   *
   * @param a the first number
   * @param b the second number
   * @return the product of a and b
   */
  public double mult(double a, double b) {
    return a * b;
  }


  /**
   * Divides the first number by the second number.
   *
   * @param a the numerator
   * @param b the denominator
   * @return the quotient of a and b
   * @throws RuntimeException if b is 0
   */
  public double div(double a, double b) {
    if (b == 0) {
      throw new RuntimeException("Division by zero");
    }
    return a / b;
  }

}


class AdvanceCalculator extends Calulator {

  public AdvanceCalculator() {
  }


  /**
   * Computes the remainder of the division of the first number by the second number.
   *
   * @param a the dividend
   * @param b the divisor
   * @return the remainder of a divided by b
   * @throws RuntimeException if b is 0
   */
  public double mod(double a, double b) {
    if (b == 0) {
      throw new RuntimeException("Division by zero");
    }
    return a % b;
  }

  /**
   * Raises the first number to the power of the second number.
   *
   * @param a the base
   * @param b the exponent
   * @return the value of a raised to the power of b
   */
  public double pow(double a, double b) {
    return Math.pow(a, b);
  }

}

class ScientificCalculator extends AdvanceCalculator {

  public ScientificCalculator() {
  }

  /**
   * Computes the logarithm of a value to a specified base.
   *
   * @param base the base of the logarithm
   * @param value the value for which the logarithm is calculated
   * @return the logarithm of value to the specified base
   * @throws RuntimeException if base is less than or equal to 0, or equal to 1,
   *                          or if value is less than or equal to 0
   */
  public double log(double base, double value) {
    if (value <= 0) {
      throw new RuntimeException("Logarithm of non-positive number");
    }
    if (base <= 0 || base == 1) {
      throw new RuntimeException("Invalid base for logarithm");
    }
    return Math.log(value) / Math.log(base);
  }

}