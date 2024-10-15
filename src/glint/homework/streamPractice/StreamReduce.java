package glint.homework.streamPractice;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamReduce {

  public static void main(String[] args) {

    // 求学生的年龄总和
    Student s1 = new Student("areca", 11);
    Student s2 = new Student("bill", 20);
    Student s3 = new Student("aa", 30);

    Stream<Student> stream = Stream.of(s1,s2,s3);
    Optional<Integer> ageSum = stream.map(Student::getAge)
            .reduce((a,b) -> a + b);

    if (ageSum.isPresent()) {
      System.out.println(ageSum.get());
    }


  }



}
