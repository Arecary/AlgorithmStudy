package glint.homework.streamPractice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOut {


  public static void main(String[] args) {

    Student s1 = new Student("areca", 11);
    Student s4 = new Student("Jesse", 39);
    Student s2 = new Student("bill", 20);
    Student s3 = new Student("aa", 30);

    Stream<Student> stream = Stream.of(s1,s2,s3,s4);

    // 年龄大于20的一组，输出成Map
    Map<String, List<String>> groups = stream
            .collect(Collectors.groupingBy(
                    e -> e.getAge() > 20 ? "Age > 20" : "Age <= 20", // 自定义分组键,
                    Collectors.mapping(e -> e.getName(), Collectors.toList())
            ));

    System.out.println(groups);

//    // 把名字是areca的人打印出来
//    stream.filter(e -> e.getName().equals("areca"))
//            .forEach(e -> System.out.println(e.getName() + ": " + e.getAge()));
//
//    // 判断是否有叫bill的人
//    Boolean flag = stream.anyMatch(e -> e.getName().equals("bill"));
//    System.out.println(flag);

//    // 把名字转成一个string list
//    List<String> nameList =  stream.map(e -> e.getName())
//            .toList();
//
//    for (String s: nameList) {
//      System.out.println(s);
//    }
//
//
//    // 把流转化成一个map，key是名字，value是年龄
//    Map<String, Integer> map = stream.collect(Collectors.toMap(
//            Student::getName,
//            e -> e.getAge(),
//            (oldValue, newValue) -> newValue // 当名字重复时，选择新的年龄
//    ));




  }

}
