import java.util.Date;
import java.util.UUID;

public class SaleDocument extends ShipmentDocument{

  private String customer; // получатель (только для продажи)

  public SaleDocument(UUID documentId, Date documentDate, String storage, String storageOwner,
                      Item[] items, String customer) {
    super(documentId, documentDate, storage, storageOwner, items);
    setCustomer(customer);
  }

  @Override
  public double promoSum(String[] promoArticles, double discount) {
    double total = super.promoSum(promoArticles);
    total *= (1 - discount);
    return Math.round(total * 100) / 100.0;
  }

  /**
   * Является ли продажа оптовой для переданного минимального объема.
   * Для перемещений неприменимо!
   */
  public boolean isWholesale(double minQuantity) {
    // Убрал проверку на тип документа, т.к. метод имеется только в нужном типе.
    // Использовал getter-ы т.к. поменял модификаторы доступа
    double sumQuantity = 0;

    for (int i = 0; i < getItemsCount(); i++) {
      if (getItems()[i].getItemQuantity() >= minQuantity) {
        return true;
      }
      sumQuantity += getItems()[i].getItemQuantity();
    }
    return sumQuantity >= minQuantity;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  @Override
  public String toString() {
    return "SaleDocument{" +
            super.toString() +
            "customer='" + customer + '\'' +
            '}';
  }
}
