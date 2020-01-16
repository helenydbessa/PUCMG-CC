/**
 * Estudo Dirigido 10
 *
 *
 * Nome: Rithie Natan   Vers�o: 0.1
 * Matr�cula: 541488    Data: 23/04/2016
 
   Exemplo0191
 
 *@version 01
*
*/

import IO.*;

class Arranjo
{
   public Object [ ] tabela;
   
   public Arranjo ( )
   {
      tabela = null;
   }
   
   public Arranjo ( int tamanho )
   {
      if( tamanho <= 0 )
      {
         IO.println( "ERROR! Quantidade inv�lida!" );
      }
      else
      {
         tabela = new Object [ tamanho ];
      }
   }
   
   public int length ( )
   {
      int tamanho = 0;
      
      if( tabela != null )
      {
         tamanho = tabela.length;
      }
      return( tamanho );
   }
   
   public void readIntArranjo ( String msn, int onde, int n )
   {
      int posicao, tamanho = length( );
      String linha;
      
      if( tamanho <= 0 || n <= 0 || n > tamanho )
      {
         IO.println( "ERROR! Quantidade inv�lidada!" );
      }
      else
      {
         if( onde < 0 )
         {
            IO.println( "ERRO: POsi��o inv�lida!" );
         }
         else
         {
            IO.println( msn );
            for( posicao = 0; posicao < tamanho; posicao = posicao + 1 )
            {
               if( posicao >= onde )
               {
                  linha = IO.readln( );
                  
                  tabela [ posicao ] = IO.getint ( linha );
               }
            }
         }
      }
   }
   
   public void printIntArranjo ( int quant )
   {
      int posicao, tamanho = length( );
      
      if( tabela == null || tamanho <= 0 )
      {
         IO.println( "ERROR: Tabela vazio ou quantidade inv�lida!" );
      }
      else
      {
         for( posicao = quant; posicao < tamanho; posicao = posicao + 1 )
         {
            IO.println( ""+( int )tabela[ posicao ] );
         }
      }
   }
}

public class Exemplo191
{
   public static void principal( )
   {
      int n, f;
      Arranjo teste = null;
      
      n = IO.readint( "Digite o tamanho do arranjo: " );
      f = IO.readint( "Digite a posi��o que voc� deseja come�ar a gravar os dados: " );
      
      teste = new Arranjo( n );
      
      teste.readIntArranjo( "Entrar com dados no arranjo: ", f, n );
      
      IO.println( "Dados mostrados a partir da posi��o desejada: "+"\n" );
      
      teste.printIntArranjo( f );      
   }
   
   public static void main( String [ ] args )
   {
      principal( );
   }
}