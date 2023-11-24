public abstract class GoodSupplier {
  private String inn;
  private String name;
  private String address;

  public GoodSupplier(String inn, String name, String address) {
    setInn(inn);
    setName(name);
    setAddress(address);
  }

  public GoodSupplier() {}

  public String getInn() {
    return inn;
  }

  public void setInn(String inn) {
    this.inn = inn;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
