package br.com.samarah;


public class Aluno {
    public String nome;
    public double n1,n2,n3;

    public double calculaValor(){
        return (n1+n2+n3)/3;
    }
    public String resultado(double x){
        if (x < 7.0){
            return "Você se deu mal.";
        } else{
            return "Parabéns, não fez mais que sua obrigação.";
        }
    }
    public String toSrString(){
        return nome + ","
        + n1 + ","
        + n2 + ","
        + n3 + ",";
    }
    
}
