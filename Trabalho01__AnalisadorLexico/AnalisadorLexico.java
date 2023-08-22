package Trabalho01__AnalisadorLexico;

public class AnalisadorLexico {
    public static void main(String[] args) {
        String text = args.length > 0 ? args[0] : "/* comentario teste */";
        if (text.startsWith("/*") && text.endsWith("*/"))
            System.out.println("Comentário válido!");
        else
            System.out.println("Comentário inválido!");
    }
}
