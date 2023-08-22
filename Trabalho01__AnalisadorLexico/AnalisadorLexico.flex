%%
%standalone

ComecoComentario = "/*"
FimComentario = "*/"
Letra = [a-zA-Z]
Digito = [0-9]
Palavra = {Letra}*
Numero = {Digito}+ 
Espaco = [ \t\n]
ComandosOuPalavras = {Espaco}*({Palavra}|{Numero})*{Espaco}*
Comentario = {ComecoComentario}{ComandosOuPalavras}*{FimComentario}
%%
//{ComandosOuPalavras} {System.out.println("Não é um Comentário Válido\n");}
{Comentario} {System.out.println("Comentario Valido\n");}