/**
 * Estudo Dirigido 0037
 *
 * Trabalho Pratico: ED 03
 *
 * Nome: Rithie Natan   Vers�o: 0.1
 * Matr�cula: 541488    Data: 27/03/2016
 *
 *@version 0037
*/

import IO.*;

public class Exemplo0037
{
   public static void main( String [] args )
   {
      int x, y, z;
      
      x = IO.readint( "Digite uma quantidade: " );
         
      while( x > 0 )
      {
         y = IO.readint( "Digite o primeiro n�mero: " );
         z = IO.readint( "Digite o segundo n�mero: " );
            
         if( ( y <= 25 && y >= -25 ) && ( z <= 25 && z >= -25 ) )
         {
            IO.println( "y: "+ y );
            IO.println( "z: "+ z );
         }
            
         x = x - 1;
      }
   }
}