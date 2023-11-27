
import java.util.Random;

public class Main {
  public static void main(String[] args) {

    Random random = new Random();

    GaussRandom generator = new GaussRandom(random, 42);

    int nNumber = 100000; // кол-во генерируемых чисел
    double sum = 0;
    double[] numberArray = new double[nNumber];

    for(int i = 0; i < nNumber; i++){
      double number = generator.nextNormal(1, 10);
      numberArray[i] = number;
      sum += number;
      if( i < 50){
        System.out.println(number);
      }
    }
    double mean = sum/nNumber; // Рассчитываем математическое ожидание
    System.out.println("\nMean: " + mean);

    sum = 0;
    // Рассчитываем стандартное отклонение
    for(int i = 0; i < nNumber; i++){
      sum += Math.pow(numberArray[i] - mean, 2);
    }
    System.out.println("\nStandard deviation: " + Math.sqrt(sum/nNumber));
  }
}