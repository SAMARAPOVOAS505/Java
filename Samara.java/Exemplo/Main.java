import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Produto p1 = new Produto();
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do Produto");
        p1.nome =sc.next();
        System.out.print("Digite a quantidade: ");
        p1.quantidade = sc.nextInt();
        System.out.print("Digite o valor");
        p1.valor = sc.nextDouble();

        System.out.print("Produto" + p1.nome + "valor em estoque " + p1.calculaValor());
        System.out.println("Quantidade:" + p1.quantidade);
        p1.adicionaItem(10);
        System.out.println("Quantidade: " + p1.quantidade);

        sc.close();
    }
}

class Produto {
    String nome;
    int quantidade;
    double valor;

    public double calculaValor() {
        return quantidade * valor;
    }

    public void adicionaItem(int x) {
        quantidade += x;
    }
}