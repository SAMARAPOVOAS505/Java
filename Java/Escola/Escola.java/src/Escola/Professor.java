package Escola;

public class Professor {
    private int inscricao;
    private String nome;

    public Professor(int inscricao, String nome) {
        this.inscricao = inscricao;
        this.nome = nome;

    }

    public int getInscricao() {
        return inscricao;
    }
    public void setInscricao(int inscricao){
        this.inscricao = inscricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "matricula=" + inscricao +
                ", nome='" + nome + '\'';
    }
    
    
}
