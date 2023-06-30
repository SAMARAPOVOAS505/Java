public class Texto {
    public static void main(String[] args) {
        String texto = "  ABC abc AbC aBc ABC abc  ";
        int tamanho = texto.length(); //mostra quantos caracteres tem a String
        String s1 = texto.toLowerCase();// deixa a String tudo em minúscolo 
        String s2 = texto.toUpperCase();// deixa tudo em maiúsculo
        String s3 = texto.trim();// tira os espaços do inicio e fim
        String s4 = texto.substring(6);
        String s5 = texto.substring(6,9);
        String s6 = texto.replace("ABC",  "xyz");
        int x = texto.indexOf("ABC");
        int y = texto.lastIndexOf("ABC");

        System.out.println("Variável texto: *" + texto + "*");
        System.out.println("Tamanho do texto: " + tamanho + " caracteres");
        System.out.println("Variável s1: *" + s1 + "*");
        System.out.println("Variável s2: *" + s2 + "*");
        System.out.println("Variável s3: *" + s3 + "*");
        System.out.println("Variável s4: *" + s4 + "*");
        System.out.println("Variável s5: *" + s5 + "*");
        System.out.println("Variável s6: *" + s6 + "*");
        System.out.println("O valor de x é: " + x);
        System.out.println("O valor de y é: " + y);

        for (int i=tamanho; i>0; i--){
            System.out.print(s2.substring(i-1, i));
        }

        System.out.print("Vamos fazer split");

        String nome = "Jupira Pereira Costa Carvalho Santos Silva Barbosa";
        String[] pedaco = nome.split(" ");
        int i = pedaco.length;
        System.out.println(" São "+ i+ " nomes");
        for(int n=0;n<i;n++){
            System.out.println(pedaco[n]);
        }
    }
}