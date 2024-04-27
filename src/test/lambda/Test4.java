package test.lambda;

public class Test4 {

  public static void main(String[] args) {
    // 匿名内部类
    MsgRef m1 = new MsgRef() {
      @Override
      public void printMsg(String msg) {
        System.out.println(msg);
      }
    };
    m1.printMsg("匿名内部类");

    // Lambda
    MsgRef m2 = (msg) -> System.out.println(msg);
    m2.printMsg("Lambda");

    // 方法引入
    MsgRef m3 = Test4::printM;
    m3.printMsg("方法引入");


  }

  public static void printM(String s){
    System.out.println("这是静态方法，" + s);
  }
}
