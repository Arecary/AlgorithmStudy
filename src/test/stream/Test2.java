package test.stream;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import test.lambda.User;

public class Test2 {

  public static void main(String[] args) {

    Stream<Integer> integerStream = Stream.of(10, 50, 30, 20);

    Optional<Integer> sum = integerStream.reduce((a,b) -> a + b);

    System.out.println(sum.get());


    ArrayList<User> users = new ArrayList<>();
    users.add(new User(22, "wayne"));
    users.add(new User(12, "virgil"));
    users.add(new User(32, "joey"));

    Stream<User> user = users.stream();
    Optional<User> ageSum = user.reduce((user1, user2) -> {
      User userEntity = new User(user1.getAge() + user2.getAge(), "sum");
      return userEntity;
    });

    System.out.println(ageSum.isPresent()? ageSum.get().getAge(): "empty");



  }

}
