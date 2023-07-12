package Escola;
import Escola.Aluno;
import Escola.Chamada;
import Escola.Estoque;
import Escola.Professor;
import Escola.Turma;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlunoTeste {
    private static final String FILE_PATH = "alunos.txt";

    public static void main(String[] args) {
        List<Chamada> aluno = lerAlunoDoArquivo();
        exibirAlunos(aluno);

        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar o nome do aluno: ");
            System.out.println("2. Atualizar cadrato do aluno: ");
            System.out.println("3. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            int matricula;
            switch (escolha) {
                case 1:
                    Aluno novoAluno = criarNovaChamada(scanner);
                    adicionarChamada(matricula, aluno);
                    break;
                case 2:
                    System.out.print("Digite o código do produto a ser atualizado: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    atualizarChamada(aluno, matricula, scanner);
                    break;
                case 3:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

            exibirAlunos(aluno);
        }

        salvarAlunoNoArquivo(aluno);
        scanner.close();
    }

    private static List<Chamada> lerAlunoDoArquivo() {
        List<Chamada> alunos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                int matricula = Integer.parseInt(partes[0]);
                String nome = partes[1];
               

                Chamada chamada = new Chamada(matricula, nome);
                alunos.add(chamada);
            }
         /*catch= pega */  } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return alunos;
    }

    private static void exibirAlunos(List<Chamada> alunos) {
        System.out.println("\nAluno:");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno encontrado.");
        } else {
            for (Chamada chamada : alunos) {
                System.out.println(chamada);
            }
        }
    }

    private static Aluno criarNovaChamada(Scanner scanner) {
        System.out.print("Digite o código da matricula: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

       

        return new Chamada(matricula, nome);
    }

    private static void adicionarChamada(int matricula, List<Chamada> aluno) {
        Aluno.add(null);
        System.out.println("Aluno adicionado com sucesso.");
    }

    private static void atualizarChamada(List<Chamada> alunos, int matricula, Scanner scanner) {
        Chamada ChamadaAtualizada = null;

        for (Chamada Chamada : alunos) {
            if (Chamada.getMatricula() == matricula) {
                ChamadaAtualizada = Chamada;
                break;
            }
        }

        if (ChamadaAtualizada != null) { /*!= negação */
            System.out.print("Digite o novo nome do aluno: ");
            String nome = scanner.nextLine();
            ChamadaAtualizada.setNome(nome);

            System.out.println("Aluno atualizado com sucesso.");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void salvarAlunoNoArquivo(List<Chamada> alunos) {
     /*try= tenta */   try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Chamada chamada : alunos) {
                writer.write(chamada.getMatricula() + "," + chamada.getNome();
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}


