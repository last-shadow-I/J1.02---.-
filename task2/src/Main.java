import java.util.List;

public class Main {
  public static void main(String[] args) {

    GaussRandom generator = new GaussRandom();

    int nNumber = 1000; // кол-во генерируемых чисел
    double summ = 0;
    double[] numberArray = new double[nNumber];

    for(int i = 0; i < nNumber; i++){
      double number = generator.nextNormal(0, 10);
      numberArray[i] = number;
      summ += number;
      if( i < 50){
        System.out.println(number);
      }
    }
    double mean = summ/nNumber; // Рассчитываем математическое ожидание
    System.out.println("\nMean: " + mean);

    summ = 0;
    // Рассчитываем стандартное отклонение
    for(int i = 0; i < nNumber; i++){
      summ += Math.pow(numberArray[i] - mean,2);
    }
    System.out.println("\nStandard deviation: " + Math.sqrt(summ/nNumber));
  }
}