package br.com.samarah;
import java.util.Scanner;
public class Escola {
    public static void main(String[] args) {
        java.util.Scanner sc = new Scanner(System.in);
        Aluno a1 = new Aluno();
        Professor p1= new Professor();
        Turma t1 = new Turma();

        t1.codigo = "fjfjgf";
        t1.materia = "dfjfjfjf";
        t1.professor = "ljdojirzx";
        t1.alunos = "kdfjiunfd";

        System.out.println(t1.toString() );

        /*
         System.out.print("Digite o nome do Professor: ");
         p1.nome = sc.next();

        System.out.print("Digite a matricula: ");
        p1.matricula = sc.next();

        System.out.print("Digite a materia: ");
        p1.materia = sc.next();

        sc.close();
        System.out.print("Digite o nome do aluno: ");
        a1.nome = sc.next();

        System.out.print("Digite a nota 1: ");
        a1.n1 = sc.nextDouble();

        System.out.print("Digite a nota 2: ");
        a1.n2 = sc.nextDouble();

        

        System.out.print("Digite a nota 3: ");
        a1.n3 = sc.nextDouble();
        sc.close();

        double media = a1.calculaValor();
        System.out.println(a1.nome + " " + a1.resultado(media));
        System.out.println(a1);

        p1.matricula = "001";
        p1.nome = "Petronio";
        p1.materia = "Programação";
        System.out.println(p1.toString() );*/

    }
}
