package test.stream;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import test.lambda.User;

public class Test1 {

  public static void main(String[] args) {

    ArrayList<User> users = new ArrayList<>();
    users.add(new User(22, "wayne"));
    users.add(new User(12, "virgil"));
    users.add(new User(32, "joey"));

    // list to Map by using Stream API

    Stream<User> stream = users.stream();
    // 我想转化成一个map，key是User的名字，value是对应的user对象
    Map<String, User> map = stream.collect(Collectors.toMap(user -> user.getName(), user -> user));

    map.forEach((name, user) -> System.out.println(name + ":" + user));

  }
}
