package glint.homework.streamPractice;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class FibonacciStream {


/*  编写一个能输出斐波拉契数列（Fibonacci）的LongStream：

          1, 1, 2, 3, 5, 8, 13, 21, 34, ...*/


  public static void main(String[] args) {

    Stream<Integer> FibonacciStream = Stream.generate(new FibonacciSupplier());
    FibonacciStream.limit(9).forEach(System.out::println);


  }


}

class FibonacciSupplier implements Supplier<Integer> {
  int n = 1;
  int m = 1;
  int count = 0;

  public Integer get(){
    if (count == 0 || count == 1) {
      count++;
      return 1;
    }else {
      int res = n + m;
      m = n;
      n = res;
      return res;
    }

  }

}