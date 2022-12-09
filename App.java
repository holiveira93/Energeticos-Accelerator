package EnergeticosAccelerator;

import java.util.Scanner;
import java.text.DecimalFormat;

public class App {

    public static void main(String[] args) {

        int i = 0, opcao1, opcao2 = 0;
        int quantidade[] = new int[10];
        String cliente[] = new String[10];
        float venda_bruta, venda_liquida, desconto = 0, icms, ipi, pis, cofins,
                total, total_imposto = 0, total_mercadoria = 0, total_geral = 0;

        Scanner scan = new Scanner(System.in);
        DecimalFormat frmt = new DecimalFormat("#0.00");

        do {
            System.out.println("Insira o nome do cliente: ");
            cliente[i] = scan.nextLine();

            do {
                opcao1 = 0;
                System.out.println("Insira a quantidade (5% desconto a partir de"
                        + " 500 unidades : ");
                quantidade[i] = scan.nextInt();

                if (quantidade[i] <= 0) {
                    System.out.println("Quantidade deve ser maior que 0: ");

                    do {
                        System.out.println("1- Digitar novamente \n2- Cancelar ");
                        opcao1 = scan.nextInt();

                        if (opcao1 != 1 && opcao1 != 2) {
                            System.out.println("Opção inválida\n");
                        }
                    } while (opcao1 != 1 && opcao1 != 2);
                }
            } while (opcao1 == 1);

            do {
                System.out.println("Deseja adicionar outro cliente e quantidade?\n "
                        + "1 - SIM \n 2 - NÃO");
                opcao2 = scan.nextInt();

                if (opcao2 != 1 && opcao2 != 2) {
                    System.out.println("Opção inválida\n");
                }
            } while (opcao2 != 1 && opcao2 != 2);

            i++;
            scan.nextLine();
        } while (opcao2 == 1);

        for (i = 0; quantidade[i] != 0; i++) {
            desconto = 0;
            venda_bruta = quantidade[i] * 4.50f;

            if (quantidade[i] >= 500) {
                desconto = venda_bruta * (5f / 100);
            }
            venda_liquida = venda_bruta - desconto;
            icms = venda_liquida * (18f / 100);
            ipi = venda_liquida * (4f / 100);
            pis = venda_liquida * (1.86f / 100);
            cofins = venda_liquida * (8.54f / 100);
            total = venda_liquida + icms + ipi + pis + cofins;

            total_imposto = total_imposto + icms + ipi + pis + cofins;
            total_mercadoria = total_mercadoria + venda_liquida;

            System.out.println("\n\nCliente: " + cliente[i]);
            System.out.println("Quantidade: " + quantidade[i]);
            System.out.println("Valor da venda: R$" + frmt.format(venda_bruta));
            System.out.println("Valor do desconto: R$" + frmt.format(desconto));

            System.out.println("\nICMS: R$" + frmt.format(icms) + "; IPI: R$"
                    + frmt.format(ipi) + "; PIS: R$" + frmt.format(pis)
                    + "; COFINS: R$" + frmt.format(cofins) + "; TOTAL: R$"
                    + frmt.format(total));
        }

        total_geral = total_imposto + total_mercadoria;

        System.out.println("\n\nTotal Impostos: R$ " + frmt.format(total_imposto));
        System.out.println("Total Mercadorias: R$ " + frmt.format(total_mercadoria));
        System.out.println("Total Geral: R$ " + frmt.format(total_geral));
    }
}
