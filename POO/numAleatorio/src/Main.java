import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Random rand = new Random();

        int x = rand.nextInt(10) + 1;

        System.out.println("Qual o número que foi gerado?");
        int y = sc.nextInt();

        while(x != y){

            if (y > x)
            {
                System.out.println("Você errou!");
                System.out.println("O seu chute é maior que o número gerado");
            }

            if(y < x){

                System.out.println("Você errou!");
                System.out.println("O seu chute é menor que o número gerado");
            }


            System.out.println("Qual o número que foi gerado?");
            y = sc.nextInt();
        }

         System.out.println("Você acertou");
    }

}