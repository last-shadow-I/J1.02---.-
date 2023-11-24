import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    String[] innArray = {"816069159303", "368842140909",
            "296940061976", "717062697799",
            "037955848108"};

    String[] nameArray = {"Кулешов Роман Глебович", "Александрова Яна Алексеевна",
            "Куликова Ксения Кирилловна", "Лебедева Варвара Тимофеевна",
            "Гаврилов Макар Максимович"};

    GoodSupplier[] goodSuppliers = new GoodSupplier[5];

    for (int i = 0; i < 3; i++){
      goodSuppliers[i] = new Manufacturer(innArray[i], nameArray[i], i + "");
    }

    Manufacturer manufacturer = null;
    for (int i = 3; i < 5; i++){

      double extraCharge = (int) ( Math.random() * 100 ) / 100.0;
      int indexManufacturer = (int) (Math.random() * 3);
      if(goodSuppliers[indexManufacturer] instanceof Manufacturer){
        manufacturer = (Manufacturer) goodSuppliers[indexManufacturer];
      }

      goodSuppliers[i] = new Dealer(innArray[i], nameArray[i], i + "", manufacturer, extraCharge);
    }

    System.err.println("Адресс\tИНН\t\t\tНазвание\t\t\t\t\tНаценка\tПроизводитель");
    for (int i = 0; i < 5; i++){
      System.err.print(goodSuppliers[i].getAddress() + "\t");
      System.err.print(goodSuppliers[i].getInn() + "\t");
      System.err.print(goodSuppliers[i].getName() + "\t");
      if(goodSuppliers[i] instanceof Dealer){
        System.err.print(((Dealer)goodSuppliers[i]).getExtraChargeRate() + " \t");
        System.err.print(((Dealer)goodSuppliers[i]).getManufacturer().getName());
      } else {
        System.err.print("---   \t---");
      }
      System.err.print("\n");
    }
    System.err.print("\n");

    String[] articleArray = {"39063157183", "50331164927",
            "58245234096", "59758625882",
            "29170313867", "17403569770",
            "07193655484", "72930588321",
            "86658645278", "74349245215",
            "93337114295", "45782122702",
            "84974084665", "09632055369",
            "95609241533"};

    Product[] products = new Product[15];

    System.err.println("Артикл\t\tНазвание\tСтоимость\t\tПоставщик");
    for (int i = 0; i < 15; i++){
      int indexGoodSupplier = (int) (Math.random() * 5);
      double productPrice = (int) ( Math.random() * 30000 ) / 100.0;
      String title = String.format("Product %d",i);
      products[i] = new Product(articleArray[i], goodSuppliers[indexGoodSupplier], productPrice, title);
      System.err.print(products[i].getArticleNumber() + "\t");
      System.err.print(products[i].getTitle()+ "\t");
      System.err.print(products[i].getPrice() + "\t");
      System.err.print(products[i].getGoodSupplier().getName() + "\n");
    }

    Scanner scanner = new Scanner(System.in);
    String str;
    int productIndex;
    double realPrice;
    boolean isDealer;
    Dealer productDealer;

    while(true){
      System.out.println("\nВведите артикул искомого товара:   ");
      if(scanner.hasNext()){
        str = scanner.next();
        productIndex = -1;

        for (int i = 0; i < products.length; i++){
          if (str.equals(products[i].getArticleNumber())){
            productIndex = i;
            break;
          }
        }

        if(productIndex != -1){
          if(products[productIndex].getGoodSupplier() instanceof Dealer){
            productDealer = (Dealer) products[productIndex].getGoodSupplier();
            realPrice = products[productIndex].getPrice() * (1 + productDealer.getExtraChargeRate());
            isDealer = true;
          } else {
            productDealer = null;
            realPrice = products[productIndex].getPrice();
            isDealer = false;
          }
          System.out.println("\n___________Товар найден____________");
          System.out.println("Наименование товара: " + products[productIndex].getTitle());
          //    Цена (для дилера – с учетом наценки),
          System.out.println("Цена: " + realPrice);
          System.out.println("Имя поставщика: " + products[productIndex].getGoodSupplier().getName());
          System.out.print("Адрес поставщика: " + products[productIndex].getGoodSupplier().getAddress());
          if(isDealer){
            //    Если это дилер – то в скобках название реального производителя.
            System.out.print("\t(Имя производителя: " + productDealer.getManufacturer().getName() + " )");
          }
          System.out.println();
        } else {
          System.out.println(String.format("Товар с артикулом: %s не найден", str));
        }
      }
    }
  }
}