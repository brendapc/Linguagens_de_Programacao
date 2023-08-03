## Aula 02 - 03/08/2023

### Conteúdo da Aula

| Linguagem / Gramáticas | Autômatos
| :---: | :---: |
| Mecanismos Geradores  | Reconhecedores

#### Gramática

##### Notação Formal

Uma gramática G é definida por uma quádrupla

`G = (N, T, P, S)` onde:

- N é um conjunto finito de símbolos não terminais
- T é um conjunto finito de símbolos terminais
- P é um conjunto finito de regras de produção
- S é o símbolo inicial

| Tipo | Esquerda | Direita | Exemplo
| :---: | :---: | :---: | :---: |
| Irrestritas (0) | Qualquer sequência com pelo menos um não terminal | Qualquer sequência de terminais e não terminais, inclusive & (vazio) | `BC -> CB`
| Sensíveis ao contexto (1) | Comprimento menor ou igual a sentença do lado direito | Comprimento maior ou igual a sentença do lado esquerdo, não aceita & | `S -> aBC`
| Livres de Contexto (2) | Apenas 1 não terminal | Não aceita & | `S -> aBC`
| Regulares (3) | Apenas 1 não terminal | pode ocorrer somente um terminal ou um terminal seguido de um não terminal | `S -> aS`

#### Critérios para avaliação de linguagens

1. Legibilidade
   - Deve ser considerado no contexto do domínio do problema.
   1. Simplicidade
      - Problemas que podem ser gerados pela falta de simplicidade: muitas construções básicas, multiplicidade de recursos, sobrecarga de operadores
   2. Ortogonalidade
   3. Tipos de dados
   4. Projeto da sintaxe
2. Facilidade de escrita
   - Deve ser considerada no contexto do domínio de problema alvo de uma linguagem
   1. Simplicidade e Ortogonalidade
   2. Expressividade
3. Confiabilidade
   - Diz-se que um programa é confiável quando está de acordo com suas especificações em todas as condições
   1. Verificação de tipos
   2. Tratamento de exceções
   3. Legibilidade e facilidade de escrita
4. Custo
   1. Treinar programadores para utilizar a linguagem
   2. Escrever programas na linguagem
   3. Compilar programas na linguagem
   4. Executar programas na linguagem
   5. Implementação da linguagem
   6. Confiabilidade baixa
   7. Manutenção de programas
      - Correções
      - Modificações

#### Categorias de Linguagens

1. Imperativa
   - Execução baseada em comandos e armazenamentos de dados
   - Principais ferramentas: variáveis, atribuições, comandos de controle de fluxo
   - Inclui linguagens
     - que suportam programação orientada a objetos
     - de script
     - visuais
   - Exemplos: C, Java, Perl, JavaScript, Visual BASIC .NET, C++
2. Funcional
    - O principal meio de fazer cálculos é aplicando funções a parâmetros dados
    - Exemplos: Haskell, LISP, Scheme
3. Lógica
    - Baseado em regras (sem ordem específica)
    - Exemplo: Prolog
4. Marcação/Programação Híbrida
    - Linguagens de marcação extendidas para suportar alguma programação
    - Exemplos: JSTL, XSLT

#### Exercícios sobre algumas linguagens
