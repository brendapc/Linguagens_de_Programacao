%%
%standalone

// Ident = [a-zA-Z][a-zA-Z0-9_]*
// Preferível utilizar macros
Digito = [0-9]
Letra = [a-zA-Z]
Ident = {Letra}({Letra}|{Digito})*
%%

abc { System.out.println("-----\"abc\""); }
{Ident} { System.out.println("-----id"); }