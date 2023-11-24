import java.util.Date;
import java.util.UUID;

public class Main {
  public static void main(String[] args) {

    Date date = new Date();
    String[] articleArray = {"39063157183", "50331164927",
            "58245234096", "59758625882",
            "29170313867", "17403569770",
            "07193655484", "72930588321",
            "86658645278", "74349245215",
            "93337114295", "45782122702",
            "84974084665", "09632055369",
            "95609241533"};

    double[] quantityArray = {2.0, 3.0, 4.0, 5.0, 6.0, 2.0, 3.0, 1.0, 5.0, 6.0, 2.0, 3.0, 1.0, 5.0, 6.0};
    double[] priceArray = {1.27, 1.0, 3.19, 0.78, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};

    ShipmentDocument saleDocumentDocument = new SaleDocument(UUID.randomUUID(), date, "1",
            "Кулешов Роман Глебович", articleArray,
            quantityArray, priceArray, "Александрова Яна Алексеевна");

    System.out.println(saleDocumentDocument.toString());

    ShipmentDocument movingDocument = new MovingDocument(UUID.randomUUID(), date, "1",
            "Куликова Ксения Кирилловна", articleArray,
            quantityArray, priceArray, "2",
            "Лебедева Варвара Тимофеевна");

    System.out.println(movingDocument.toString());

    String[] articleArrayTest = {"39063157183", "50331164927"};

    double[] discount = {0.1, 0.1};

    System.out.println("Результат для перемещения " + ((MovingDocument) movingDocument).promoSum(articleArrayTest));

    System.out.println("Результат для продажи " + saleDocumentDocument.promoSum(articleArrayTest, discount));

    String[] articleArrayTest2 = {"58245234096", "59758625882"};
    double[] discount2 = {0.15, 0.13};

    System.out.println("Результат для перемещения " + ((MovingDocument) movingDocument).promoSum(articleArrayTest2));

    System.out.println("Результат для продажи " + saleDocumentDocument.promoSum(articleArrayTest2, discount2));

  }
}