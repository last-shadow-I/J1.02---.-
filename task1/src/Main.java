import java.util.Date;

public class Main {
  public static void main(String[] args) {

    A a = new B("aa", 121, 13.0);

    System.out.println(a.varA1);
    System.out.println(a.varA2);
    System.out.println(((B) a).getVarB1());
    System.out.println();

    A a2 = new D();
    Date date = new Date();

    System.out.println(a2.varA1);
    System.out.println(a2.varA2);
    System.out.println(a2.foo(date));

  }
}