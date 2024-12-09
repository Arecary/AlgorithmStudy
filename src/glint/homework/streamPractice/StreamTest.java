package glint.homework.streamPractice;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
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


//    list.stream()
////            .sorted(new Comparator<Student>() {
////              @Override
////              public int compare(Student o1, Student o2) {
////                return -o1.getName().compareTo(o2.getName());
////              }
////            })
//            .sorted((o1, o2) -> -o1.getName().compareTo(o2.getName()))
//            .forEach(element -> System.out.println(element.getName() + element.getAge()));


    Stream<Student> streamStudent = Stream.of(s1,s2,s3);


    Optional<Student> optionalStudent = list.stream()
            .min((o1, o2) -> o1.getAge() - o2.getAge());


    Student res = optionalStudent.orElseGet(() -> new Student("ab", 33));
    System.out.println(res.getName() + res.getAge());


    Student s4 = new Student("testStudent", 40){
      @Override
      public int hashCode(){
        return Objects.hash(name,age);
      }
    };
    int code = s4.hashCode();
    System.out.println(code);





  }

}

// java8新特性
// stream api fini
// 重写equals和hashCode fini
// 写dockerfile  如何部署AWS
// 写database index，index有哪几类
// 数据库区别 sql nosql 优点，mongodb什么情况下用
// 存储过程，触发器，PL/SQL怎么写
// 微服务架构，优点，为什么用
// hibernate 写一个例子
// Jenkins 的集成和配置，如何编写 CI/CD 流水线，自动化测试和部署流程
// 如何使用 Spring Security 实现身份验证和授权。
// 如何通过 Spring AOP 引入日志和监控功能。DI IOC
// REACT REDUX AJAX
// 如何测试 junit
// Kafka怎么写
// 设计模式：工厂模式，模版模式
// 写一个json
// 如何创建并维护适当的文档 用swagger？