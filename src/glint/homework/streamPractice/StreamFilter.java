package glint.homework.streamPractice;

import java.util.stream.Stream;

public class StreamFilter {


  public static void main(String[] args) {
    Student s1 = new Student("areca", 11);
    Student s2 = new Student("bill", 20);
    Student s3 = new Student("aa", 30);

    Stream<Student> stream = Stream.of(s1,s2,s3);

    stream.filter(e -> e.getAge() < 20)
            .forEach(e -> System.out.println(e.getName() + ": " + e.getAge()));
  }


}
