import java.util.Scanner;
public class Semana {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o dia: ");
        int dia = sc.nextInt();
        sc.close();

        if (dia < 4) {
            System.out.println("Inicío de semana");
        } else{
            if(dia > 4) {
                System.out.println("Fim de semana");
            }
            else {
                System.out.println("Meio de semana");
            }
        }
    }
}
