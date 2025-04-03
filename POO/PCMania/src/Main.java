import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Criando os Pcs

        Computador pc1 = new Computador();
        pc1.marca = "Apple";
        pc1.preco = 214;
        pc1.hardware[0].setNome("Pentium Core i3");
        pc1.hardware[0].setCapacidade(2200);
        pc1.hardware[1].setNome("Memória Ram");
        pc1.hardware[1].setCapacidade(8);
        pc1.hardware[2].setNome("HD");
        pc1.hardware[2].setCapacidade(500);
        pc1.sistema.setNome("IOS 18.4");
        pc1.sistema.setTipo(64);

        Computador pc2 = new Computador();
        pc2.marca = "Samsung";
        pc2.preco = 214 + 1234;
        pc2.hardware[0].setNome("Pentium Core i5");
        pc2.hardware[0].setCapacidade(3770);
        pc2.hardware[1].setNome("Memória Ram");
        pc2.hardware[1].setCapacidade(16);
        pc2.hardware[2].setNome("HD");
        pc2.hardware[2].setCapacidade(1000);
        pc2.sistema.setNome("Windows 11");
        pc2.sistema.setTipo(64);

        Computador pc3 = new Computador();
        pc3.marca = "Dell";
        pc3.preco = 214 + 5678;
        pc3.hardware[0].setNome("Pentium Core i7");
        pc3.hardware[0].setCapacidade(4500);
        pc3.hardware[1].setNome("Memória Ram");
        pc3.hardware[1].setCapacidade(32);
        pc3.hardware[2].setNome("HD");
        pc3.hardware[2].setCapacidade(2000);
        pc3.sistema.setNome("Linux");
        pc3.sistema.setTipo(64);

        // inicio da interface

        System.out.println("Bem vindo a PCMania!");
        System.out.println("Para começar insira seu nome e cpf respectivamente: ");
        Cliente cliente = new Cliente();
        cliente.nome = sc.nextLine();
        cliente.cpf = sc.nextLong();
        sc.nextLine();

        System.out.println("Dê uma olhada nas nossas promoções!!!");
        System.out.println("Digite 1 para ver a primeira promoção, 2 para ver a segunda e 3 para a terceira.");

        int promo = sc.nextInt();
        sc.nextLine();
        String option;

        while (promo != 0) {

            switch (promo) {
                case 1:
                    pc1.mostrarPCConfigs();
                    System.out.println("Deseja adicionar memória USB na sua compra? Digit S ou N");
                    option = sc.nextLine();
                    if (option.equalsIgnoreCase("S")) {
                        MemoriaUSB musb = new MemoriaUSB("Pendrive",16);
                        pc1.addMemoriaUSB(musb);
                    }
                    cliente.compra(pc1);
                    break;

                case 2:
                    pc2.mostrarPCConfigs();
                    System.out.println("Deseja adicionar memória externa na sua compra? Digite S ou N");
                    option = sc.nextLine();
                    if (option.equalsIgnoreCase("S")) {
                        MemoriaUSB musb = new MemoriaUSB("Pedrive", 32);
                        pc2.addMemoriaUSB(musb);
                    }
                    cliente.compra(pc2);
                    break;

                case 3:
                    pc3.mostrarPCConfigs();
                    System.out.println("Deseja adicionar memória externa na sua compra? Digite S ou N");
                    option = sc.nextLine();
                    if (option.equalsIgnoreCase("S")) {
                        MemoriaUSB musb = new MemoriaUSB("HD Externo", 1);
                        pc3.addMemoriaUSB(musb);
                    }
                    cliente.compra(pc3);
                    break;
            }

            System.out.println("Digite 1 para ver a primeira promoção, 2 para ver a segunda e 3 para a terceira.");
            System.out.println("Digite 0 para finalizar a compra.");
            promo = sc.nextInt();
            sc.nextLine();
        }

        System.out.println("Suas compras foram: ");

        for(int i = 0; i < cliente.pc.length; i++)
        {
            cliente.pc[i].mostrarPCConfigs();
        }

        System.out.println("Preço total da comra: R$" + cliente.calculaTotalCompra());

    }
}