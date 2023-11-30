
public class Item {

  private String itemId; // GUID товара
  private String itemArticle; // артикул товара
  private String itemTitle; // название товара
  private double itemQuantity; // Количество шт. товара
  private double itemPrice; // цена товара

  public Item(String itemId, String itemArticle, String itemTitle, double itemQuantity, double itemPrice) {
    setItemId(itemId);
    setItemArticle(itemArticle);
    setItemTitle(itemTitle);
    setItemQuantity(itemQuantity);
    setItemPrice(itemPrice);
  }
  public double amountItems(){
    return itemQuantity * itemPrice;
  }

  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public String getItemArticle() {
    return itemArticle;
  }

  public void setItemArticle(String itemArticle) {
    this.itemArticle = itemArticle;
  }

  public String getItemTitle() {
    return itemTitle;
  }

  public void setItemTitle(String itemTitle) {
    this.itemTitle = itemTitle;
  }

  public double getItemQuantity() {
    return itemQuantity;
  }

  public void setItemQuantity(double itemQuantity) {
    this.itemQuantity = itemQuantity;
  }

  public double getItemPrice() {
    return itemPrice;
  }

  public void setItemPrice(double itemPrice) {
    this.itemPrice = itemPrice;
  }
}
