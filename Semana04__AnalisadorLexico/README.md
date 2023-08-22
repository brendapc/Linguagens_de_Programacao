## Aula 07 - Analisadores Léxicos com JFlex - 22/08/2023

### Como executar

1. Instale o JFlex
2. Execute o comando `jflex {fileName}.flex`
   - Alternativa 1: No Windows, execute o arquivo `jflex.bat` da pasta de instalação
   - Alternativa 2: No Windows, de 2 cliques no arquivo .jar da pasta de instalação
      - O arquivo .jar pode ser encontrado na pasta `lib`
3. Execute o comando `javac Yylex.java`
4. Execute o comando `java Yylex {inputFileName}.txt > {outputFileName}.txt`
