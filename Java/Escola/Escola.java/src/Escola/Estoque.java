package Escola;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Estoque {
    private static final String FILE_PATH = "estoque.txt";

    public static void main(String[] args) {
        List<Produto> estoque = lerEstoqueDoArquivo();
        exibirEstoque(estoque);

        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            exibirMenu();
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    Produto novoProduto = criarNovoProduto(scanner);
                    adicionarProduto(estoque, novoProduto);
                    break;
                case 2:
                    System.out.print("Digite o código do produto a ser atualizado: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    atualizarProduto(estoque, codigo, scanner);
                    break;
                case 3:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

            exibirEstoque(estoque);
        }

        salvarEstoqueNoArquivo(estoque);
        scanner.close();
    }

    private static List<Produto> lerEstoqueDoArquivo() {
        List<Produto> estoque = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                int codigo = Integer.parseInt(partes[0]);
                String nome = partes[1];
                double preco = Double.parseDouble(partes[2]);
                int quantidade = Integer.parseInt(partes[3]);

                if (partes.length == 5) {
                    String autor = partes[4];
                    Livro livro = new Livro(codigo, nome, preco, quantidade, autor);
                    estoque.add(livro);
                } else {
                    Produto produto = new Produto(codigo, nome, preco, quantidade);
                    estoque.add(produto);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return estoque;
    }

    private static void exibirEstoque(List<Produto> estoque) {
        System.out.println("\nEstoque:");
        if (estoque.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            for (Produto produto : estoque) {
                System.out.println(produto);
            }
        }
    }

   
    private static Produto criarNovoProduto(Scanner scanner) {
        exibirMenuProduto();
        int escolha = scanner.nextInt();
        scanner.nextLine();

        

        switch (escolha) {
            case 1:
                System.out.print("Digite o código do produto: ");
                int codigo = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Digite o nome do produto: ");
                String nome = scanner.nextLine();

                System.out.print("Digite o preço do produto: ");
                double preco = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Digite a quantidade do produto: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine();

                return new Produto(codigo, nome, preco, quantidade);
            case 2:
                System.out.print("Digite o código do livro: ");
                codigo = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Digite o nome do livro: ");
                nome = scanner.nextLine();

                System.out.print("Digite o preço do livro: ");
                preco = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Digite a quantidade do livro: ");
                quantidade = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Digite o autor do livro: ");
                String autor = scanner.nextLine();

                return new Livro(codigo, nome, preco, quantidade, autor);
            default:
                System.out.println("Opção inválida. Criando um produto padrão.");
                return new Produto(0, "Produto Padrão", 0.0, 0);
        }
    }

    private static void adicionarProduto(List<Produto> estoque, Produto novoProduto) {
        estoque.add(novoProduto);
        System.out.println("Produto adicionado com sucesso.");
    }

    private static void atualizarProduto(List<Produto> estoque, int codigo, Scanner scanner) {
        Produto produtoAtualizado = null;

        for (Produto produto : estoque) {
            if (produto.getCodigo() == codigo) {
                produtoAtualizado = produto;
                break;
            }
        }

        if (produtoAtualizado != null) {
            System.out.print("Digite o novo nome do produto: ");
            String nome = scanner.nextLine();
            produtoAtualizado.setNome(nome);

            System.out.print("Digite o novo preço do produto: ");
            double preco = scanner.nextDouble();
            produtoAtualizado.setPreco(preco);

            System.out.print("Digite a nova quantidade do produto: ");
            int quantidade = scanner.nextInt();
            produtoAtualizado.setQuantidade(quantidade);

            System.out.println("Produto atualizado com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void salvarEstoqueNoArquivo(List<Produto> estoque) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Produto produto : estoque) {
                if (produto instanceof Livro) {
                    Livro livro = (Livro) produto;
                    writer.write(produto.getCodigo() + "," + produto.getNome() + "," +
                            produto.getPreco() + "," + produto.getQuantidade() + "," +
                            livro.getAutor());
                } else {
                    writer.write(produto.getCodigo() + "," + produto.getNome() + "," +
                            produto.getPreco() + "," + produto.getQuantidade());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    private static void exibirMenu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1. Adicionar novo produto");
        System.out.println("2. Atualizar produto existente");
        System.out.println("3. Sair");
    }
    private static void exibirMenuProduto (){
        System.out.println("Escolha o tipo de produto:");
        System.out.println("1. Produto");
        System.out.println("2. Livro");
        
    }
}

class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(int codigo, String nome, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}

class Livro extends Produto {
    private String autor;

    public Livro(int codigo, String nome, double preco, int quantidade, String autor) {
        super(codigo, nome, preco, quantidade);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "codigo=" + getCodigo() +
                ", nome='" + getNome() + '\'' +
                ", preco=" + getPreco() +
                ", quantidade=" + getQuantidade() +
                ", autor='" + autor + '\'' +
                '}';
    }
}