import java.util.Date;

public class B extends A{
  private double varB1;

  public double getVarB1() {
    return varB1;
  }

  public void setVarB1(double varB1) {
    this.varB1 = varB1;
  }

  public B(String varA1, int varA2, double varB1) {
    super(varA1, varA2);
    this.varB1 = varB1;
  }

  public B() {}

  @Override
  public int foo(Date dt) {
    return 0;
  }
}
