import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Escola.Alunos;

public class Escola {
    private static final String FILE_PATH = "Turma.txt";

    public static void main(String[] args) {
        List<Alunos> chamada = lerChamadaDoArquivo();
        exibirChamada(chamada);

        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar novo aluno");
            System.out.println("2. Atualizar Aluno existente");
            System.out.println("3. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    Alunos novoAluno = criarNovoAluno(scanner);
                    adicionarAluno(chamada, novoAluno);
                    break;
                case 2:
                    System.out.print("Digite a matricula do aluno para ser atualizado: ");
                    int matricula = scanner.nextInt();
                    scanner.nextLine();
                    atualizarAluno(chamada, matricula, scanner);
                    break;
                case 3:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

            exibirChamada(chamada);
        }

        salvarChamadaNoArquivo(chamada);
        scanner.close();
    }

    private static List<Alunos> lerChamadaDoArquivo() {
        List<Alunos> chamada = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                int matricula = Integer.parseInt(partes[0]);
                String nome = partes[1];
                

                Alunos aluno = new Alunos(matricula, nome);
                chamada.add(aluno);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return chamada;
    }

    private static void exibirChamada(List<Alunos> chamada) {
        System.out.println("\nChamada:");
        if (chamada.isEmpty()) {
            System.out.println("Nenhum aluno encontrado.");
        } else {
            for (Alunos alunos : chamada) {
                System.out.println(alunos);
            }
        }
    }

    private static Alunos criarNovoAluno(Scanner scanner) {
        System.out.print("Digite a matricula do aluno: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        return new Alunos(matricula, nome);
    }

    private static void adicionarAluno(List<Alunos> chamada, Alunos novoAlunos) {
        chamada.add(novoAlunos);
        System.out.println("Aluno adicionado com sucesso.");
    }

    private static void atualizarAluno(List<Alunos> chamada, int matricula, Scanner scanner) {
        Alunos alunoAtualizado = null;

        for (Alunos alunos : chamada) {
            if (alunos.getMatricula() == matricula) {
                alunoAtualizado = alunos;
                break;
            }
        }

        if (alunoAtualizado != null) {
            System.out.print("Digite o novo nome do aluno: ");
            String nome = scanner.nextLine();
            alunoAtualizado.setNome(nome);

            System.out.print("Digite a nova matricula do aluno:");
            int Matricula = scanner.nextInt();

            System.out.println("Aluno atualizado com sucesso.");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void salvarChamadaNoArquivo(List<Alunos> chamada) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Alunos alunos : chamada) {
                writer.write(alunos.getMatricula() + "," + alunos.getNome());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}
