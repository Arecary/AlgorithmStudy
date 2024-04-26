package test.stream;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import test.lambda.User;

public class Test3 {

  public static void main(String[] args) {

    ArrayList<User> users = new ArrayList<>();
    users.add(new User(22, "wayne"));
    users.add(new User(12, "wayne"));
    users.add(new User(12, "virgil"));
    users.add(new User(32, "joey"));

    Stream<User> user = users.stream();
    Stream<User> userStream = user.filter(user1 -> user1.getName() == "wayne" && user1.getAge() > 20);

    userStream.forEach(userItem -> System.out.println(userItem.getAge() + " " + userItem.getName()));
  }
}
