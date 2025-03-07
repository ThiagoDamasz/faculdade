import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com os preços dos lanches que deseja cadastrar: ");
        int lanche1 = sc.nextInt();
        int lanche2 = sc.nextInt();
        int lanche3 = sc.nextInt();

        int total = lanche1 + lanche2 + lanche3;

        int media = total/3;

        System.out.println("Total dos preços dos lanches: " + total);
        System.out.println("Media dos preços: " + media);

        sc.close();
    }
}