/**
 * Estudo Dirigido 0080
 *
 * Trabalho Pratico: ED 05
 *
 * Nome: Rithie Natan   Vers�o: 0.1
 * Matr�cula: 541488    Data: 27/03/2016
 
 *@version 80
*/

import IO.*;

public class Exemplo0081
{
// ---------------------------------------------- definicao de metodo auxiliar
 public static void metodo01 ( int x )
 {
 // repetir enquanto valor maior que zero
 while ( x > 0 )
 {
 // mostrar valor
 IO.println ( "Valor = " + x );
 // passar ao pr�ximo
 x = x - 1;
 } // fim se
 } // fim metodo01( )
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() � metodo principal
 */
 public static void main ( String [ ] args )
 {
 // identificar
 IO.println ( "EXEMPLO0081 - Programa em Java" );
 IO.println ( "Autor: ________________________" );
 IO.println ( );
 // executar o metodo auxiliar
 metodo01 ( 5 );
 // encerrar
 IO.pause ( "Apertar ENTER para terminar." );
 } // fim main( )
} // fim class Exemplo0081