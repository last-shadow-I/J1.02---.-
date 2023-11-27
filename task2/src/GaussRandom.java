import java.time.LocalTime;
import java.util.Random;

public class GaussRandom {

  Random random;
  Random generator;

  public GaussRandom(Random random) {
    setRandom(random);
    setGenerator(new Random());
  }

  public GaussRandom(Random random, long seed) {
    setRandom(random);
    setGenerator(new Random());
    setSeed(seed);
  }

  public double nextNormal(double m, double sigma){
    double z = nextNormal();
    return m + z * sigma;
  }

  public double nextNormal(){
    // Для получения стандартных нормально распределённых случайных величин используется первый вариант
    // преобразования Бокса — Мюллера
    return Math.cos(2 * Math.PI * random.nextDouble()) * Math.sqrt(-2 * Math.log(generator.nextDouble()));
  }
  public Random getRandom() {
    return random;
  }

  public void setRandom(Random random) {
    this.random = random;
  }

  public Random getGenerator() {
    return generator;
  }

  public void setGenerator(Random generator) {
    this.generator = generator;
  }

  public void setSeed(long seed) {
    LocalTime time = LocalTime.now();
    System.out.println(time.getHour() * 3600 + time.getMinute() * 60 + time.getSecond());
    this.random.setSeed(seed);
    this.generator.setSeed(seed + (time.getHour() * 3600 + time.getMinute() * 60 + time.getSecond()));
  }
}
