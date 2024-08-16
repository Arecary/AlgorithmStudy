package glint.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Glint0813 {


  public static void main(String[] args) {
    Product p1 = new Product(1, "Mango", "Fruit", 2.99);
    Product p2 = new Product(2, "Coca-Cola", "Beverage", 1.5);
    Product p3 = new Product(3, "iPhone 14", "Phone", 799); // lowerCase
    Product p4 = new Product(4, "Apple", "Fruit", 1.00);
    Product p5 = new Product(5, "Thinkpad x1", "Laptop", 1711.37);
    Product p6 = new Product(6, "IPhone 13", "Phone", 599);

    List<Product> products = new ArrayList<>();
    products.add(p6);
    products.add(p2);
    products.add(p3);
    products.add(p1);
    products.add(p5);
    products.add(p4);

    // 用stream流收集id大于2的产品并生成一个list
    List<Product> productList = products.stream().filter(P -> P.getId() > 2).toList();
    // Get product names, where category is in [Fruit , Phone]
    List<String> productName = products.stream()
            .filter(p -> p.getCategory().equals("Fruit") || p.getCategory().equals("Phone"))
            .map(p -> p.getName()).toList();


// sort by id
    Collections.sort(products);
    System.out.println("Sorted by ID:");
    products.forEach(System.out::println);

// sort by price
    products.sort(new PriceComparator());
    System.out.println("\nSorted by Price:");
    products.forEach(System.out::println);

// sort by category
    products.sort(new CategoryComparator());
    System.out.println("\nSorted by Category:");
    products.forEach(System.out::println);

// sort by name
    products.sort(new NameComparator());
    System.out.println("\nSorted by Name:");
    products.forEach(System.out::println);


  }

}


/**
 * Comparator for comparing two {@link Product} objects based on their price.
 * <p>
 * This comparator sorts products in ascending order by their price.
 * If two products have the same price, they are considered equal in terms of ordering.
 */
class PriceComparator implements Comparator<Product> {

  @Override
  public int compare(Product p1, Product p2) {
    return Double.compare(p1.getPrice(), p2.getPrice());
  }
}

/**
 * Comparator for comparing two {@link Product} objects based on their category.
 * <p>
 * This comparator sorts products lexicographically by their category in a case-insensitive manner.
 * Categories are compared without considering their case, so "Beverage" and "beverage" would be treated as equal.
 */
class CategoryComparator implements Comparator<Product> {

  @Override
  public int compare(Product p1, Product p2) {
    return p1.getCategory().compareToIgnoreCase(p2.getCategory());
  }
}

/**
 * Comparator for comparing two {@link Product} objects based on their name.
 * <p>
 * This comparator sorts products lexicographically by their name.
 * The comparison is case-sensitive, so names with different case will be ordered accordingly.
 */
class NameComparator implements Comparator<Product> {

  @Override
  public int compare(Product p1, Product p2) {
    return p1.getName().compareTo(p2.getName());
  }
}


class Product implements Comparable<Product> {
  private int id;
  private double price;
  private String category;
  private String name;

  public Product(int id, String name, String category, double price) {
    this.id = id;
    this.price = price;
    this.category = category;
    this.name = name;
  }

  @Override
  public int compareTo(Product other) {
    return Integer.compare(this.id, other.id); // Integer overflow
  }

  @Override
  public String toString() {
    return "product{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", category='" + category + '\'' +
            ", price=" + price +
            '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
