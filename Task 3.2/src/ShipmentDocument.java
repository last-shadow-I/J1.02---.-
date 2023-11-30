import java.util.Date;
import java.util.UUID;

public abstract class ShipmentDocument {

  private UUID documentId; // GUID документа
  private Date documentDate; // дата документа
  private String storage; // название склада отгрузки
  private String storageOwner; // владелец склада отгрузки
  private int itemsCount; // количество товаров в документе
  private Item[] items; // список товаров

  public ShipmentDocument(UUID documentId, Date documentDate, String storage, String storageOwner, Item[] items) {
    setDocumentId(documentId);
    setDocumentDate(documentDate);
    setStorage(storage);
    setStorageOwner(storageOwner);
    setItemsCount(items.length);
    setItems(items);
  }

  public ShipmentDocument() {}

  /**
   * Суммарная стоимость товаров в документе.
   */
  public double totalAmount() {
    double sum = 0;
    for (int i = 0; i < itemsCount; i++) {

      sum += Math.round(this.items[i].amountItems() * 100) / 100.0;
    }
    return sum;
  }

  /**
   * Стоимость товара с переданным id.
   */
  public double itemAmount(String id) {
    for (int i = 0; i < itemsCount; i++) {
      if (items[i].getItemId().equals(id)) {

        return Math.round(items[i].amountItems() * 100) / 100.0;
      }
    }
    return 0;
  }

  /**
   * Суммарная стоимость товаров, попадающих в список промо-акции.
   */
  public double promoSum(String[] promoArticles, double[] discount) {
    double sum = 0;
    double amountWithDiscount;
    for (int i = 0; i < itemsCount; i++) {
      for (int j = 0; j < promoArticles.length; j++) {
        if (items[i].getItemArticle().equals(promoArticles[j])) {

          amountWithDiscount = items[i].amountItems();

          if(discount[j] != 0.0){
            amountWithDiscount *= (1.0 - discount[j]);
            System.out.println("\nБез округления " + amountWithDiscount);
            amountWithDiscount = Math.ceil(amountWithDiscount * 100) / 100;
            System.out.println("C округлением " + amountWithDiscount);
          } else {
            System.out.println("Без скидки " + items[i].getItemQuantity() + " * " + items[i].getItemPrice() + " = " + amountWithDiscount);
          }
          sum += amountWithDiscount;
          break;
        }
      }
    }
    return sum;
  }

  public UUID getDocumentId() {
    return documentId;
  }

  public void setDocumentId(UUID documentId) {
    this.documentId = documentId;
  }

  public Date getDocumentDate() {
    return documentDate;
  }

  public void setDocumentDate(Date documentDate) {
    this.documentDate = documentDate;
  }

  public String getStorage() {
    return storage;
  }

  public void setStorage(String storage) {
    this.storage = storage;
  }

  public String getStorageOwner() {
    return storageOwner;
  }

  public void setStorageOwner(String storageOwner) {
    this.storageOwner = storageOwner;
  }

  public int getItemsCount() {
    return itemsCount;
  }

  public void setItemsCount(int itemsCount) {
    this.itemsCount = itemsCount;
  }

  public Item[] getItems() {
    return items;
  }

  public void setItems(Item[] items) {
    this.items = items;
  }

  @Override
  public String toString() {
    return "documentId=" + documentId +
            ", documentDate=" + documentDate +
            ", storage='" + storage + '\'' +
            ",\n storageOwner='" + storageOwner + '\'' +
            ", itemsCount=" + itemsCount + ", ";
  }
}
