import java.util.Date;
import java.util.UUID;

public abstract class ShipmentDocument {

  private UUID documentId; // GUID документа
  private Date documentDate; // дата документа
  private String storage; // название склада отгрузки
  private String storageOwner; // владелец склада отгрузки
  private int itemsCount; // количество товаров в документе
  private String[] itemsId; // список GUID товаров
  private String[] itemsArticle; // список артикулов товаров
  private String[] itemsTitle; // список наваний товаров
  private double[] itemsQuantity; // список количества шт. товаров
  private double[] itemsPrice; // список цен товаров

  public ShipmentDocument(UUID documentId, Date documentDate, String storage, String storageOwner, int itemsCount) {
    this.documentId = documentId;
    this.documentDate = documentDate;
    this.storage = storage;
    this.storageOwner = storageOwner;
    this.itemsCount = itemsCount;
  }

  public ShipmentDocument() {
  }

  /**
   * Суммарная стоимость товаров в документе.
   */
  public double totalAmount() {
    double sum = 0;
    for (int i = 0; i < itemsCount; i++) {
      sum += Math.round(itemsQuantity[i] * itemsPrice[i] * 100) / 100.0;
    }
    return sum;
  }

  /**
   * Стоимость товара с переданным id.
   */
  public double itemAmount(String id) {
    for (int i = 0; i < itemsCount; i++) {
      if (itemsId[i] == id) {
        return Math.round(itemsQuantity[i] * itemsPrice[i] * 100) / 100.0;
      }
    }
    return 0;
  }

  /**
   * Суммарная стоимость товаров, попадающих в список промо-акции.
   */
  public double promoSum(String[] promoArticles) {
    double sum = 0;
    for (int i = 0; i < itemsCount; i++) {
      for (int j = 0; j < promoArticles.length; j++) {
        if (itemsArticle[i] == promoArticles[j]) {
          sum += Math.round(itemsQuantity[i] * itemsPrice[i] * 100) / 100.0;
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

  public String[] getItemsId() {
    return itemsId;
  }

  public void setItemsId(String[] itemsId) {
    this.itemsId = itemsId;
  }

  public String[] getItemsArticle() {
    return itemsArticle;
  }

  public void setItemsArticle(String[] itemsArticle) {
    this.itemsArticle = itemsArticle;
  }

  public String[] getItemsTitle() {
    return itemsTitle;
  }

  public void setItemsTitle(String[] itemsTitle) {
    this.itemsTitle = itemsTitle;
  }

  public double[] getItemsQuantity() {
    return itemsQuantity;
  }

  public void setItemsQuantity(double[] itemsQuantity) {
    this.itemsQuantity = itemsQuantity;
  }

  public double[] getItemsPrice() {
    return itemsPrice;
  }

  public void setItemsPrice(double[] itemsPrice) {
    this.itemsPrice = itemsPrice;
  }

  @Override
  public String toString() {
    return "documentId=" + documentId +
            ", documentDate=" + documentDate +
            ", storage='" + storage + '\'' +
            ", storageOwner='" + storageOwner + '\'' +
            ", itemsCount=" + itemsCount + ", ";
  }
}
