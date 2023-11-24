public class Dealer extends GoodSupplier{

  private Manufacturer manufacturer;
  private double extraChargeRate;

  public Dealer(String inn, String name, String address, Manufacturer manufacturer, double extraChargeRate) {
    super(inn, name, address);
    setManufacturer(manufacturer);
    setExtraChargeRate(extraChargeRate);
  }

  public Dealer() {}

  public Manufacturer getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(Manufacturer manufacturer) {
    this.manufacturer = manufacturer;
  }

  public double getExtraChargeRate() {
    return extraChargeRate;
  }

  public void setExtraChargeRate(double extraChargeRate) {
    this.extraChargeRate = extraChargeRate;
  }
}
