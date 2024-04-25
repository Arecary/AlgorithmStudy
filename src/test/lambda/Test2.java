package test.lambda;

import java.util.ArrayList;
import java.util.Comparator;

public class Test2 {

  public static void main(String[] args) {

    ArrayList<User> users = new ArrayList<>();
    users.add(new User(22, "wayne"));
    users.add(new User(12, "virgil"));
    users.add(new User(32, "joey"));

    // 匿名内部类
    users.sort(new Comparator<User>() {
      @Override
      public int compare(User o1, User o2) {
        return o1.getAge() - o2.getAge();
      }
    });

    // lambda
    users.sort((o1, o2) -> {
      return o1.getAge() - o2.getAge();
    });

    // 更精简lambda
    users.sort((o1, o2) -> o1.getAge() - o2.getAge());

    // best lambda
    users.sort(Comparator.comparingInt(User::getAge));


    users.forEach((user) -> System.out.println(user.getAge()));


  }
}
