package test.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

import test.lambda.User;

public class Test5 {

  public static void main(String[] args) {
    // 排序
    ArrayList<User> users = new ArrayList<>();
    users.add(new User(22, "wayne"));
    users.add(new User(12, "wayne"));
    users.add(new User(12, "virgil"));
    users.add(new User(32, "joey"));
    Stream<User> user = users.stream();

    user.sorted((o1, o2) -> o1.getAge() - o2.getAge()).forEach(u -> System.out.println(u.getName() + ":" + u.getAge()));

  }
}
