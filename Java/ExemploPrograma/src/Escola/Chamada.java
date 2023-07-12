package Escola;

public class Chamada {
    private int matricula;
    private String nome;

    public Chamada(int matricula, String nome) {/*contrutor =Produto */
        this.matricula = matricula;
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + matricula +
                ", nome='" + nome + '\'' + '}';
    }
    
}
