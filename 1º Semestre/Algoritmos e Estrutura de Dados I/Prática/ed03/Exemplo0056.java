/**
 * Estudo Dirigido 0056
 *
 * Trabalho Pratico: ED 03
 *
 * Nome: Rithie Natan   Vers�o: 0.1
 * Matr�cula: 541488    Data: 27/03/2016
 
 *@version 56
*/

import IO.*;

public class Exemplo0056
{
   public static void metodo11( )
   {
      int x;
      char y ;
      
      x = IO.readint( "Quantos n�meros voc� que escrever: " );
      while( x > 0 )
      {
         y = IO.readchar( "Digite uma letra: " );
         
         if ( y >= 'a' && y <= 'z' )
         {
            IO.println( "Letra min�scula = " + y );
         }
         
         x = x - 1;
      }
   }
   
   public static void main ( String [] args )
   {
      metodo11( );
   }
}