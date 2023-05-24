import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

  /**
   * Método principal.
   */
  public static void main(String[] args) {
    ArrayList<Integer> ages = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    boolean mustContinue;
    do {
      int selectedOption = 0;

      do {
        if (selectedOption != 0) {
          System.out.println("Entre com uma opção válida!");
        }

        System.out.println("Entre com o número correspondente à opção desejada:");
        System.out.println("1 - Acessar o estabelecimento");
        System.out.println("2 - Finalizar sistema e mostrar relatório");

        String typedOption = scanner.next();
        selectedOption = Integer.parseInt(typedOption);

        if (selectedOption == 1) {
          System.out.println("Entre com a sua idade:");
          String typeAge = scanner.next();
          int age = Integer.parseInt(typeAge);
          if (age < 18) {
            System.out.println("Pessoa cliente menor de idade, catraca liberada!");
          } else if (age <= 49) {
            System.out.println("Pessoa adulta, catraca liberada!");
          } else {
            System.out.println("Pessoa adulta a partir de 50, catraca liberada!");
          }
          ;
          ages.add(age);
        }
      } while (selectedOption > 2 || selectedOption < 1);

      mustContinue = selectedOption == 1;
    } while (mustContinue);

    int children = 0;
    int adult = 0;
    int old = 0;

    for (int age : ages) {
      if (age < 18) {
        children++;
      } else if (age <= 49) {
        adult++;
      } else {
        old++;
      }
      ;
    }

    System.out.println("----- Quantidade -----");
    System.out.println("menores: " + children);
    System.out.println("adultas: " + adult);
    System.out.println("a partir de 50: " + old);
    System.out.println();

    double totalUsers = ages.size();
    double childrenPercent = 100 / totalUsers * children;
    double adultPercent = 100 / totalUsers * adult;
    double oldPercent = 100 / totalUsers * old;

    DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
    DecimalFormat df = new DecimalFormat("#.##", otherSymbols);
    System.out.println("----- Percentual -----");
    System.out.printf("menores: %s%%\n", df.format(childrenPercent));
    System.out.printf("adultas: %s%%\n", df.format(adultPercent));
    System.out.printf("a partir de 50: %s%%\n", df.format(oldPercent));
    System.out.println();

    System.out.printf("TOTAL: %.0f", totalUsers);
    scanner.close();
  }
}