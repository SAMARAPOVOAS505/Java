import java.util.Scanner;

public class Escola {

    public static void main(String[] args){
        Aluno a1 = new Aluno();
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nume do aluno: ");
        a1.nome = sc.next();

        System.out.print("Digite a nota 1: ");
        a1.n1 = sc.nextDouble();

        System.out.print("Digite a note 2: ");
        a1.n2 = sc.nextDouble();
     /* a1.nome = "Jupira";
        a1.n1 = 3.0;
        a1.n2 = 7.4;
     */

        double media = a1.calculaValor();
        String resultado = a1.resultado(media);
        
        System.out.println("A media foi " + media);
        System.out.println("E você foi " + resultado);
        

    }
    
}

class Aluno{
    String nome;
    double n1, n2;

    public double calculaValor(){
        return (n1 + n2)/ 2;
    }
    public String resultado(double x) {
        if (x < 7.0){
            return "se deu mal";
        } else{
            return "Aprovado";
        }
    }

}
        
    