/**
 * Estudo Dirigido 20
 *
 * Trabalho Pratico: Guia 01
 *
 * Nome: Rithie Natan   Vers�o: 0.1
 * Matr�cula: 541488    Data: 14/02/2016
 *
 *@version 20
*/

import IO.*;

public class Exemplo0020
{
   public static void main (String[] args)
   {
      double x, y;
      int a, b;
      String z;
      
      x = IO.readdouble("Entre com uma sequ�ncia de digitos: ");
      
      z = IO.readString("Entre com uma sequ�ncia de digitos: ");
      
      a = IO.readint("Entre com uma sequ�ncia de digitos: ");
      
      y = IO.getdouble(z);
      
      b = IO.getint(z);
      
      z = "(" + x + "," + a + ")";
      
      z = z + "(" + y + "," + b + ")";
      
      IO.println ( "x = " + x );
      
      IO.println ( "y = " + y );
      
      IO.println ( "a = " + a );
      
      IO.println ( "b = " + b );
      
      IO.println ( "z = " + z );
   }
}
