/**
 * Estudo Dirigido 0053
 *
 * Trabalho Pratico: ED 03
 *
 * Nome: Rithie Natan   Vers�o: 0.1
 * Matr�cula: 541488    Data: 27/03/2016
 
 *@version 53
*/

import IO.*;

public class Exemplo0053
{
   public static void metodo08( )
   {
      int x;
      double y;
      
      x = IO.readint( "Quantos n�meros voc� que escrever: " );
      while( x > 0 )
      {
         y = IO.readdouble( "Digite um n�mero: " );
         
         if ( y >= 25 && y <= 125 )
         {
            if( y % 2 != 0 )
            {
               IO.println( "Y = " + y );
            }
         }
         
         x = x - 1;
      }
   }
   
   public static void main ( String [] args )
   {
      metodo08( );
   }
}