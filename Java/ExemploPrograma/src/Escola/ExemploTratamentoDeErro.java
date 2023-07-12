package Escola;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExemploTratamentoDeErro {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite um número inteiro: ");
            int numero = scanner.nextInt();

            System.out.print("Digite um divisor: ");
            int divisor = scanner.nextInt();

            int resultado = dividir(numero, divisor);

            System.out.println("Resultado da divisão: " + resultado);

            scanner.close();
      /*   } catch (InputMismatchException e) {
            System.out.println("Erro de entrada: você deve digitar um número inteiro.");
        } catch (ArithmeticException e) {
            System.out.println("Erro de divisão por zero: o divisor não pode ser zero.");*/
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    public static int dividir(int numero, int divisor) {
        return numero / divisor;
    }
}

