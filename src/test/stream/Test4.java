package test.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

import test.lambda.User;

public class Test4 {

  public static void main(String[] args) {

    ArrayList<User> users = new ArrayList<>();
    users.add(new User(22, "wayne"));
    users.add(new User(12, "wayne"));
    users.add(new User(12, "virgil"));
    users.add(new User(32, "joey"));
    Stream<User> user = users.stream();

    user.skip(1).limit(2).forEach(User -> System.out.println(User.getName() + User.getAge()));
  }
}
