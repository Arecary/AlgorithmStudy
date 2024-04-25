package test.lambda;

import java.util.ArrayList;

public class Test1 {


  public static void main(String[] args) {
    ((LanmbdaTest) () -> System.out.println("Hello World")).get();

    ArrayList<String> s = new ArrayList<>();
    s.add("a");
    s.add("b");
    s.add("c");

    s.forEach(System.out::println);
  }

}
