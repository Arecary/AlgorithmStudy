package glint.homework.streamPractice;

import java.util.Objects;

public class Student {
  String name;
  int age;

  public Student(String name, int age) {
    this.name = name;
    this.age = age;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

//  @Override
//  public boolean equals(Object o) {
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//    Student student = (Student) o;
//    return age == student.age &&
//            Objects.equals(name, student.name);
//  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(name, age);
//  }












  @Override
  public int hashCode(){
    return Objects.hash(name,age);
  }




  @Override
  public boolean equals(Object o){
    // 检查是否为同一个对象
    if (this == o) {
      return true;
    }
    // 检查传入的对象是否是 null，并确保传入对象的类型和当前对象一致。
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    // 逐一对比对象的属性attribute，使用Objects.equals可以防止对比的属性是null从而报错
    Student student = (Student)o;
    if (this.age == student.age && Objects.equals(this.name, ((Student) o).getName())) {
      return true;
    }else {
      return false;
    }
  }

































}
