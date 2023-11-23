import java.util.Random;

public class GaussRandom extends Random {

  public GaussRandom() {
  }

  public GaussRandom(long seed) {
    super(seed);
  }

  public double nextNormal(double m, double sigma){

    double z = Math.cos(2 * Math.PI * this.nextDouble()) * Math.sqrt(-2 * Math.log(this.nextDouble()));

    return m + z*sigma;
  }

  public double nextNormal(){
    return nextNormal(0, 1);
  }
}
