package es.jimenezfrontend.cards;

/**
* DAM, IES Ribera de Castilla
* @author José Antonio
*/

/**
*Clase para asignar valores a nuestros naipes en funci�n del juego lanzado.
*/
public class GameValues 
        {
	public static void sieteYMedia(int SUITS, int NUMBERS, SpanishCard[][] cards)
		{
		for(int suit=0; suit<SUITS; suit++)
			{
			for(int num=0; num<NUMBERS; num++)
				{
				if(num<=6)
					{
					cards[suit][num]=new SpanishCard((num+1),suit,(num+1));
					}
				if(num==7)
					{
					cards[suit][num]=new SpanishCard(10,suit,0.5);
					}
				if(num==8)
					{
					cards[suit][num]=new SpanishCard(11,suit,0.5);
					  }
				if(num==9)
					{
					cards[suit][num]=new SpanishCard(12,suit,0.5);
					}
				} //NUM ENDFOR
			} //SUIT ENDFOR
		}
        }
