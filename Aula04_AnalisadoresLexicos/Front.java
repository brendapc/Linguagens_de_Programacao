package Aula04_AnalisadoresLexicos;

/*
 * Front.java - um sistema analisador léxico para expressões aritméticas simples
*/

import java.io.File;
import java.util.Scanner;

public class Front {
    /* Declarações e Variáveis Globais */
    static int charClass;
    static char[] lexeme = new char[100];
    static String fileContent;
    static char nextChar;
    static int nextCharIndex = 0;
    static int lexLen;

    /* Caracteres e Tokens */
    static final int LETTER = 0;
    static final int DIGIT = 1;
    static final int UNKNOWN = 99;
    static final int INT_LIT = 10;
    static final int IDENT = 11;
    static final int ASSIGN_OP = 20;
    static final int ADD_OP = 21;
    static final int SUB_OP = 22;
    static final int MULT_OP = 23;
    static final int DIV_OP = 24;
    static final int LEFT_PAREN = 25;
    static final int RIGHT_PAREN = 26;
    static final int EOF = -1;

    public static void main(String[] args) {
        /* Abre o arquivo de dados de entrada e processa seu conteúdo */
        String filePath = args.length > 0 ? args[0]
            : "Aula04_AnalisadoresLexicos/front.in";
        File file = new File(filePath);
        try (Scanner in_fp = new Scanner(file)) {
            fileContent = in_fp.nextLine();
            charClass = getCharClass();
            while (lex() != EOF) {}
        } catch (Exception e) {
            System.out.println("ERROR - cannot open file " + e.getMessage());
        }
    }

    /**
     * @param nextChar - next character from input
     * @return equivalent token for the given character
    */
    static int lookup(char nextChar) {
        addChar(nextChar);
        switch (nextChar) {
            case '(':
                return LEFT_PAREN;

            case ')':
                return RIGHT_PAREN;

            case '+':
                return ADD_OP;

            case '-':
                return SUB_OP;

            case '*':
                return MULT_OP;

            case '/':
                return DIV_OP;

            default:
                return EOF;
	    }
    }
    
    /**
     * Uma função para adicionar nextChar ao lexeme
     * @param nextChar - next character from input
    */
    static void addChar(char nextChar) {
        if (lexLen <= 98) {
            lexeme[lexLen++] = nextChar;
            lexeme[lexLen] = 0;
        } else
            System.out.println("Error - lexeme is too long");
    }

    /**
     * Determines the character class of nextChar
     * @return next character from input
     */
    static int getCharClass() {
        try {
            nextChar = fileContent.charAt(nextCharIndex++);
            if (Character.isAlphabetic(nextChar))
                return LETTER;
            else if (Character.isDigit(nextChar))
                return DIGIT;
            else
                return UNKNOWN;
        } catch (Exception e) {
            return EOF;
        }
    }
 
    /**
     * @param nextChar - next character from input
     * @return next non-whitespace character from input 
    */
    static void getNonBlank(char nextChar) {
        while (Character.isWhitespace(nextChar))
            charClass = getCharClass();
    }

    /**
     * @return next token
    */
    static int lex() {
        lexLen = 0;
        lexeme = new char[100];
        getNonBlank(nextChar);

        int nextToken = -1;
        switch (charClass) {
            /* Analisa identificadores sintaticamente */
            case LETTER:
                do {
                    addChar(nextChar);
                    charClass = getCharClass();
                } while (charClass == LETTER || charClass == DIGIT);
                nextToken = IDENT;
                break;
                
            /* Analisa literais sintaticamente */
            case DIGIT:
                do {
                    addChar(nextChar);
                    charClass = getCharClass();
                } while (charClass == DIGIT);
                nextToken = INT_LIT;
                break;
                
            /* Parênteses e operadores*/
            case UNKNOWN:
                nextToken = lookup(nextChar);
                charClass = getCharClass();
                break;

            /* Fim do arquivo */
            case EOF:
                lexeme[0] = 'E';
                lexeme[1] = '0';
                lexeme[2] = 'F';
                lexeme[3] = 0;
                nextToken = EOF;
                break;
        }

        System.out.println(
            "Next token is: " + nextToken +
            "  Next lexeme is: " + new String(lexeme)
        );

        return nextToken;
    }
}
