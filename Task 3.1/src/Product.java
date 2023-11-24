public class Product {

  private String articleNumber;
  private GoodSupplier goodSupplier;
  private Double price;
  private String title;

  public Product(String articleNumber, GoodSupplier goodSupplier, Double price, String title) {
    setArticleNumber(articleNumber);
    setGoodSupplier(goodSupplier);
    setPrice(price);
    setTitle(title);
  }

  public Product() {
  }

  public String getArticleNumber() {
    return articleNumber;
  }

  public void setArticleNumber(String articleNumber) {
    this.articleNumber = articleNumber;
  }

  public GoodSupplier getGoodSupplier() {
    return goodSupplier;
  }

  public void setGoodSupplier(GoodSupplier goodSupplier) {
    this.goodSupplier = goodSupplier;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
