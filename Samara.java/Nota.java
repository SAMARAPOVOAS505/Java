import java.util.Scanner;
public class Nota {

    public static void main(String[] args) {
       double n1, n2, n3, m;
       String nome;
       Scanner sc = new Scanner(System.in);

       System.out.print("Digite o nome:");
       nome = sc.next();
       System.out.print("Digite a nota 1:");
       n1 = sc.nextDouble();
       System.out.print("Digite a nota 2:");
       n2 = sc.nextDouble();
       System.out.print("Digite a nota 3:");
       n3 = sc.nextDouble();
       sc.close();

        m = (n1+n2+n3)/3;
        System.out.println("O valor da nota 1 é: " +n1);
        System.out.println("O valor da nota 2 é:" + n2);
        System.out.println("O valor da nota 3 é: " + n3);
        System.out.println("O valor da média é: " + m);

        if (m >= 7) 
            System.out.println(nome + " Passou");
        else
            System.out.println(nome + " se ferrou");
        
    }
}