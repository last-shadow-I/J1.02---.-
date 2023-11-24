import java.util.Date;
import java.util.UUID;

public class Main {
  public static void main(String[] args) {

    Date date = new Date();
    ShipmentDocument saleDocumentDocument = new SaleDocument(UUID.randomUUID(), date, "1",
            "Кулешов Роман Глебович", 10, "Александрова Яна Алексеевна");

    System.out.println(saleDocumentDocument.toString());

    ShipmentDocument movingDocument = new MovingDocument(UUID.randomUUID(), date, "1",
            "Куликова Ксения Кирилловна", 10, "2",
            "Лебедева Варвара Тимофеевна");

    System.out.println(movingDocument.toString());

  }
}