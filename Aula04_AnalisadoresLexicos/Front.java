package Aula04_AnalisadoresLexicos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Front {
    /* Declarações globais */
    /* Variáveis */
    static int charClass;
    static char[] lexeme = new char[100];
    static char nextChar;
    static int lexLen;
    static int token;
    static int nextToken;
    static Scanner in_fp;

    /* caracteres e tokens */
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
    static final int EOF = 50;

    public static void main(String[] args) {
        /* Abre o arquivo de dados de entrada e processa seu conteúdo */
        try {
            in_fp = new Scanner("front.in");
            if (in_fp == null)
                throw new Exception();
            else {
                getChar();
                do {
                    lex();
                } while (nextToken != EOF);
            }
        } catch (Exception e) {
            System.out.println("ERROR - cannot open front.in");
        }
    }
    
    /* lookup - uma função para processar operadores e parenteses
             e retornar o token */
    static int lookup(char ch)
    {
        addChar();
        switch (ch) {
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
    
    /* addChar - uma função para adicionar nextChar a lexeme */
    static void addChar()
    {
        if (lexLen <= 98) {
            lexeme[lexLen++] = nextChar;
            lexeme[lexLen] = 0;
        } else
            System.out.println("Error - lexeme is too long");
    }

    /* getChar - uma função para obter o próximo caractere de
           entrada e determinar sua classe */
    static boolean isalpha(char ch) {
        return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'));
    }
    static boolean isdigit(char ch) {
        return (ch >= '0' && ch <= '9');
    }
    static void getChar()
    {
        if ((nextChar = getc(in_fp)) != /*EOF*/null) {
            if (isalpha(nextChar))
                charClass = LETTER;
            else if (isdigit(nextChar))
                charClass = DIGIT;
            else
                charClass = UNKNOWN;
        } else
            charClass = EOF;
    }
 
    /* getNonBlank - uma função para chamar getChar até que ele
                    retorne um caractere que não seja um espaço em
                    branco */
    static boolean isspace(char ch) {
        return (ch == ' ' || ch == '\t' || ch == '\n');
    }
    static void getNonBlank()
    {
        while (isspace(nextChar))
            getChar();
    }

    /* lex - um analisador léxico simples para expressões
       aritméticas */
    static int lex() {
        lexLen = 0;
        getNonBlank();
        switch (charClass) {
            /* Analisa identificadores sintaticamente */
            case LETTER:
                addChar();
                getChar();
                while (charClass == LETTER || charClass == DIGIT) {
                    addChar();
                    getChar();
                }
                nextToken = IDENT;
                break;
                
            /*Analisa literais sintaticamente */
            case DIGIT:
                addChar();
                getChar();
                while (charClass == DIGIT) {
                    addChar();
                    getChar();
                }
                nextToken = INT_LIT;
                break;
                
            /*Parênteses e operadores*/
            case UNKNOWN:
                lookup(nextChar);
                getChar();
                break;
                /*Fim do arquivo */

            case EOF:
                nextToken = EOF;
                lexeme[0] = 'E';
                lexeme[1] = '0';
                lexeme[2] = 'F';
                lexeme[3] = 0;
                break;
        }

        System.out.printf("Next token is: *d, Next lexeme is #s\n",
            nextToken, lexeme);

        return nextToken;
    }
}
