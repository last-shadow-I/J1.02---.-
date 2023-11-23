import java.util.Date;

public abstract class A {

  public String varA1 = "aaa";
  public int varA2;

  public A(String varA1, int varA2) {
    this.varA1 = varA1;
    setVarA2(varA2);
  }

  public A() {
  }

  public String getVarA1() {
    return varA1;
  }

  public void setVarA1(String varA1) {
    this.varA1 = varA1;
  }

  public int getVarA2() {
    return varA2;
  }

  public void setVarA2(int varA2) {
    if(varA2 >= 0 && varA2 < 100){
      this.varA2 = varA2;
    } else if (varA2 < 0) {
      this.varA2 = 0;
    } else {
      this.varA2 = 99;
    }
  }

  public abstract int foo(Date dt);

  public void buzz(){
  }


}
