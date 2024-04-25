package test.lambda;

public class Test3 {

  public static void main(String[] args) {

    // 匿名内部类
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("线程名称" + Thread.currentThread().getName() + ", 子线程");
      }
    });

    thread.start();

    // lambda
    new Thread(() -> System.out.println("线程名称" + Thread.currentThread().getName() + ", 子线程")).start();


  }
}
