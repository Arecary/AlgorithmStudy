package glint.homework.streamPractice;

import java.util.HashSet;
import java.util.stream.Stream;

public class StreamTest {


  public static void main(String[] args) {
    HashSet<Student> list = new HashSet<>();
    Student s1 = new Student("areca", 11);
    Student s2 = new Student("bill", 20);
    Student s3 = new Student("aa", 30);

    list.add(s1);
    list.add(s2);
    list.add(s3);

    list.stream()
//            .sorted(new Comparator<Student>() {
//              @Override
//              public int compare(Student o1, Student o2) {
//                return -o1.getName().compareTo(o2.getName());
//              }
//            })
            .sorted((o1, o2) -> -o1.getName().compareTo(o2.getName()))
            .forEach(element -> System.out.println(element.getName() + element.getAge()));


    Stream<Student> streamStudent = Stream.of(s1,s2,s3);



  }


}

// stream api
// 重写equals和hashCode
// dockerfile
// database index