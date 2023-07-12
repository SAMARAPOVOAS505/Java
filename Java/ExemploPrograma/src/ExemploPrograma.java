import Escola.Aluno;
import Escola.Curso;
import Escola.Pessoa;
import Escola.*;
import java.util.Scanner;



public class ExemploPrograma {
    public static void main(String[] args) {
        java.util.Scanner sc = new Scanner(System.in);
        
        
        System.out.print("Digite o nome do aluno: ");
        String nome = sc.next();
        System.out.println("Digite o numero da matricula: ");
        int matricula = sc.nextInt();
        Aluno aluno1 = new Aluno(nome,matricula);

        System.out.print("Digite o nome do aluno: ");
        nome = sc.next();
        System.out.println("Digite o numero da matricula: ");
        matricula = sc.nextInt();
        Aluno aluno2 = new Aluno(nome,matricula);

        System.out.print("Digite o nome do aluno: ");
        nome = sc.next();
        System.out.println("Digite o numero da matricula: ");
        matricula = sc.nextInt();
        Aluno aluno3 = new Aluno(nome, matricula);


        System.out.print("Digite o nome do Professor: ");
        nome = sc.next();
        System.out.print("Digite o numero de inscrição: ");
        matricula = sc.nextInt();
        Professor professor = new Professor(nome, matricula);
        Curso curso = new Curso("Informática", "INF101");
        Turma turma = new Turma("T1", "14:00", professor, curso);
        
        turma.adicionarAluno(aluno1);
        turma.adicionarAluno(aluno2);
        turma.adicionarAluno(aluno3);

        // Exibir todos os alunos matriculados na turma
        System.out.println("Alunos matriculados na turma:");
        for (Aluno aluno : turma.getAlunosMatriculados()) {
            System.out.println(aluno.getNome() + " - Matrícula: " + aluno.getNumeroMatricula());
        }

        // Remover um aluno da turma
        turma.removerAluno(aluno2);

        // Exibir os alunos matriculados novamente após a remoção
        System.out.println("Alunos matriculados na turma após a remoção:");
        for (Aluno aluno : turma.getAlunosMatriculados()) {
            System.out.println(aluno.getNome() + " - Matrícula: " + aluno.getNumeroMatricula());
        }
    
        // Contar quantos alunos existem no ArrayList
        int quantidadeAlunos = turma.getAlunosMatriculados().size();
        System.out.println("Quantidade de alunos: " + quantidadeAlunos);
        
        // Excluir todos os alunos do ArrayList
        turma.getAlunosMatriculados().clear();

        // Verificar se a lista de alunos está vazia
        boolean listaVazia = turma.getAlunosMatriculados().isEmpty();
        System.out.println("Lista de alunos está vazia? " + listaVazia);
    }
}