package Escola;


// Classe abstrata que representa um Animal
abstract class Animal {
    public abstract void fazerBarulho(); // Método abstrato para fazer barulho
}

// Subclasse que herda de Animal
class Cachorro extends Animal {
    @Override
    public void fazerBarulho() {
        System.out.println("O cachorro faz: Au Au!");
    }
}

// Subclasse que herda de Animal
class Gato extends Animal {
    @Override
    public void fazerBarulho() {
        System.out.println("O gato faz: Miau Miau!");
    }
}

// Classe principal que testa as funcionalidades
public class ExemploPolimorfismo {
    public static void main(String[] args) {
        Animal cachorro = new Cachorro(); // Instanciando um objeto Cachorro como Animal
        Animal gato = new Gato(); // Instanciando um objeto Gato como Animal

        cachorro.fazerBarulho(); // Chamando o método fazerBarulho do cachorro (polimorfismo)
        gato.fazerBarulho(); // Chamando o método fazerBarulho do gato (polimorfismo)
    }
}