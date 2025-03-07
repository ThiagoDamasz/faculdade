import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a NP1 do aluno: ");
        int np1 = sc.nextInt();
        System.out.println("Digite a NP2 do aluno: ");
        int np2 = sc.nextInt();

        int npa = (np1 + np2)/2;

        int np3;

        if (npa < 60)
        {
            System.out.println("O aluno ficou de np3");

            System.out.println("Entre com a nota de np3 do aluno: ");
            np3 = sc.nextInt();

            if(((npa + np3)/2) > 50)
            {
                System.out.println("O aluno está aprovado");
            }


            else
            {
                System.out.println("O aluno fracassou ");
            }
        }

        else
        {
            System.out.println("O aluno está aprovado");
        }


    }
}