package glint.homework.streamPractice;

import java.util.stream.Stream;

public class StreamMap {

  public static void main(String[] args) {

    Student s1 = new Student("areca", 11);
    Student s2 = new Student("bill", 20);
    Student s3 = new Student("aa", 30);

    Stream<Student> stream = Stream.of(s1,s2,s3);

//    stream.map(Student::getName);
    stream.peek(e -> e.setName(e.getName().toUpperCase()))
            .forEach(element -> System.out.println(element.getName() + element.getAge()));



  }


}
