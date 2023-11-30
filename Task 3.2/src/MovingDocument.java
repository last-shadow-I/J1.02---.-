import java.util.Date;
import java.util.UUID;

public class MovingDocument extends ShipmentDocument{

  private String movingStorage; // название склада получения (только для перемещения)
  private String movingStorageOwner; // владелец склада получения (только для перемещения)

  public MovingDocument(UUID documentId, Date documentDate, String storage,
                        String storageOwner, Item[] items, String movingStorage, String movingStorageOwner) {
    super(documentId, documentDate, storage, storageOwner, items);
    setMovingStorage(movingStorage);
    setMovingStorageOwner(movingStorageOwner);
  }

  public MovingDocument() {
  }

  public double promoSum(String[] promoArticles) {
    double[] discount = new double[promoArticles.length];
    return super.promoSum(promoArticles, discount);
  }

  /**
   * Является ли перемещение внутренним (между складами одного владельца).
   * Для продаж неприменимо!
   */
  public boolean isInternalMovement() {
    // Убрал проверку на тип документа, т.к. метод имеется только в нужном типе.
    // Использовал getter т.к. поменял модификатор доступа
    return getStorageOwner().equals(movingStorageOwner);
  }

  public String getMovingStorage() {
    return movingStorage;
  }

  public void setMovingStorage(String movingStorage) {
    this.movingStorage = movingStorage;
  }

  public String getMovingStorageOwner() {
    return movingStorageOwner;
  }

  public void setMovingStorageOwner(String movingStorageOwner) {
    this.movingStorageOwner = movingStorageOwner;
  }

  @Override
  public String toString() {
    return "MovingDocument{" +
            super.toString() +
            "movingStorage='" + movingStorage + '\'' +
            ", movingStorageOwner='" + movingStorageOwner + '\'' +
            '}';
  }
}
