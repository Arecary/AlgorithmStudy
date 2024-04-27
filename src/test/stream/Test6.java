package test.stream;

import java.time.Duration;
import java.time.Instant;
import java.util.OptionalLong;
import java.util.function.LongBinaryOperator;
import java.util.stream.LongStream;

public class Test6 {

  public static void main(String[] args) {
    Instant start = Instant.now();
    int sum = 0;
    for (long i = 0; i <= 5000000000L; i++) {
      sum += i;
    }
    Instant end = Instant.now();

    System.out.println(sum + "的求和时间为：" + Duration.between(start, end).toMillis() + "毫秒");


    // 并行流
    start = Instant.now();
    LongStream longStream = LongStream.rangeClosed(0, 5000000000L);
    OptionalLong res = longStream.parallel().reduce(new LongBinaryOperator() {
      @Override
      public long applyAsLong(long left, long right) {
        return left + right;
      }
    });
    end = Instant.now();

    System.out.println(res.getAsLong() + "的求和时间为：" + Duration.between(start, end).toMillis() + "毫秒");
  }
}
