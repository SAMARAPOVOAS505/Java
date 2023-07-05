package Escola;

public class Professor extends Pessoa {
    private int numeroIdentificacao;

    public Professor(String nome, int numeroIdentificacao) {
        super(nome);
        this.numeroIdentificacao = numeroIdentificacao;
    }

    public int getNumeroIdentificacao() {
        return numeroIdentificacao;
    }

    public void setNumeroIdentificacao(int numeroIdentificacao) {
        this.numeroIdentificacao = numeroIdentificacao;
    }
}
