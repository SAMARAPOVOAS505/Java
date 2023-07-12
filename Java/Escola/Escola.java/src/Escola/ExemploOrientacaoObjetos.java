package Escola;

// Classe abstrata que representa um funcionário
abstract class Funcionario {
    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public abstract void calcularSalario(); // Método abstrato a ser implementado nas subclasses
}

// Subclasse que herda de Funcionario
class Gerente extends Funcionario {
    private String departamento;

    public Gerente(String nome, double salario, String departamento) {
        super(nome, salario);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public void calcularSalario() {
        // Implementação específica para calcular o salário de um gerente
        double salario = getSalario();
        double bonus = salario * 0.2; // 20% de bônus para gerentes
        double salarioTotal = salario + bonus;
        System.out.println("Salário total do gerente " + getNome() + ": " + salarioTotal);
    }
}

// Subclasse que herda de Funcionario
class Desenvolvedor extends Funcionario {
    private String linguagem;

    public Desenvolvedor(String nome, double salario, String linguagem) {
        super(nome, salario);
        this.linguagem = linguagem;
    }

    public String getLinguagem() {
        return linguagem;
    }

    @Override
    public void calcularSalario() {
        // Implementação específica para calcular o salário de um desenvolvedor
        double salario = getSalario();
        double salarioTotal = salario;
        System.out.println("Salário total do desenvolvedor " + getNome() + ": " + salarioTotal);
    }
}

// Interface que define o comportamento de um bônus
interface Bonus {
    double calcularBonus();
}

// Classe que implementa a interface Bonus
class BonusProducao implements Bonus {
    private int quantidade;

    public BonusProducao(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public double calcularBonus() {
        // Implementação específica para calcular o bônus de produção
        double bonus = quantidade * 100; // Cada unidade produzida vale R$100 de bônus
        System.out.println("Bônus de produção: " + bonus);
        return bonus;
    }
}

// Classe principal que testa as funcionalidades
public class ExemploOrientacaoObjetos {
    public static void main(String[] args) {
        // Criando objetos das classes Gerente e Desenvolvedor
        Gerente gerente = new Gerente("João", 5000, "TI");
        Desenvolvedor desenvolvedor = new Desenvolvedor("Maria", 3000, "Java");

        // Chamando os métodos dos objetos
        System.out.println("Nome do gerente: " + gerente.getNome());
        System.out.println("Departamento do gerente: " + gerente.getDepartamento());
        gerente.calcularSalario();

        System.out.println("Nome do desenvolvedor: " + desenvolvedor.getNome());
        System.out.println("Linguagem do desenvolvedor: " + desenvolvedor.getLinguagem());
        desenvolvedor.calcularSalario();

        // Criando objeto da classe BonusProducao
        BonusProducao bonusProducao = new BonusProducao(100);
        bonusProducao.calcularBonus();
    }
}