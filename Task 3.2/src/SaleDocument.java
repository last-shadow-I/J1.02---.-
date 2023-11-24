import java.util.Date;
import java.util.UUID;

public class SaleDocument extends ShipmentDocument{

  private String customer; // получатель (только для продажи)

  public SaleDocument(UUID documentId, Date documentDate, String storage, String storageOwner,
                      String[] itemsArticle, double[] itemsQuantity, double[] itemsPrice, String customer) {
    super(documentId, documentDate, storage, storageOwner, itemsArticle, itemsQuantity, itemsPrice);
    this.customer = customer;
  }

  public SaleDocument() {
  }


  /**
   * Является ли продажа оптовой для переданного минимального объема.
   * Для перемещений неприменимо!
   */
  boolean isWholesale(double minQuantity) {
    // Убрал проверку на тип документа, т.к. метод имеется только в нужном типе.
    // Использовал getter-ы т.к. поменял модификаторы доступа
    double sumQuantity = 0;

    for (int i = 0; i < getItemsCount(); i++) {
      if (getItemsQuantity()[i] >= minQuantity) {
        return true;
      }
      sumQuantity += getItemsQuantity()[i];
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
