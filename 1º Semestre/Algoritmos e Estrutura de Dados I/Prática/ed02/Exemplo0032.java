/**
 * Estudo Dirigido 0032
 *
 * Trabalho Pratico: ED 03
 *
 * Nome: Rithie Natan   Vers�o: 0.1
 * Matr�cula: 541488    Data: 27/03/2016
 *
 *@version 0032
*/

import IO.*;

public class Exemplo0032
{
   public static void main( String [] args )
   {
      int x, y;
      
      x = IO.readint( "Digite uma quantidade: " );
         
      while( x > 0 )
      {
         y = IO.readint( "Digite um n�mero: " );
            
         if( y < 25 && y > -25 )
         {
            IO.println( y );
         }
            
         x = x - 1;
      }
   }
}