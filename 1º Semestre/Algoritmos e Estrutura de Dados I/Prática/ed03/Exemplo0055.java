/**
 * Estudo Dirigido 0055
 *
 * Trabalho Pratico: ED 03
 *
 * Nome: Rithie Natan   Vers�o: 0.1
 * Matr�cula: 541488    Data: 27/03/2016
 
 *@version 55
*/

import IO.*;

public class Exemplo0055
{
   public static void metodo10( )
   {
      int x, a;
      double y ;
      
      x = IO.readint( "Quantos n�meros voc� que escrever: " );
      while( x > 0 )
      {
         y = IO.readdouble( "Digite um n�mero: " );
         
         if ( y >= 0 && y < 100 )
         {
            a = (int)y;
            
            IO.println( "Parte fracion�ria = " + ( y - a ));
            IO.println( "Parte inteira = " + a );
         }
         
         x = x - 1;
      }
   }
   
   public static void main ( String [] args )
   {
      metodo10( );
   }
}