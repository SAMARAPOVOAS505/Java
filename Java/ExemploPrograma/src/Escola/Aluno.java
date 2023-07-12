package Escola;

public class Aluno extends Pessoa {
    private int numeroMatricula;
    public String aluno1;
    public int NumeroMatricula;

    public Aluno(String nome, int numeroMatricula) {
        super(nome);
        this.numeroMatricula = numeroMatricula;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public static void add(Chamada novaChamada) {
    }
}
