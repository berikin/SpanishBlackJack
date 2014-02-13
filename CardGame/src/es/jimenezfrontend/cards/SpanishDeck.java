package es.jimenezfrontend.cards;

/**
 * DAM, IES Ribera de Castilla
 * @author José Antonio
 */

/**
*Clase para instanciar mazos de cartas de la baraja espanola.
*/
public class SpanishDeck 
    {
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    //
    //Atributos
    //
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    
    private boolean full_deck;
    private int deck;
    private SpanishCard[][] spa_deck;
    
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    //
    //Constructores
    //
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    
    /**
    *Este constructor Genera nuestro mazo de cartas, completo o ligero.
    *@param full_deck Booleana que indica si el mazo debe ser completo (48 cartas)
    *o ligero (40 cartas)
    */
    public SpanishDeck(boolean full_deck)
        {
        this.full_deck=full_deck;
        if(full_deck==true)
            {
            spa_deck=new SpanishCard[4][12];
            deck=48;
            }
        else
            {
            spa_deck=new SpanishCard[4][10];
            deck=40;
            }
        for(int suit=SpanishCard.OROS; suit<=SpanishCard.BASTOS; suit++)
            {
            for(int num=0; num<spa_deck[0].length; num++)
                {
                //if(!full_deck && num>6)
                if(full_deck==false && num>6)
                    {
                    spa_deck[suit][num]=new SpanishCard(num+3, suit);
                    }
                else
                    {
                    spa_deck[suit][num]=new SpanishCard(num+1, suit);
                    }
                }
            }   //for
        }   //public spa_deck end
    
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    //
    //Getters
    //
    ///////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////// 
    
    /**
    *Para obtener el número de cartas totales SIN REPARTIR que componen el mazo
    *@return Entero con el número de cartas sin repartir que componen el mazo
    */
    public int getDeck()
        {
        return deck;
        }
    
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    //
    //Otros
    //
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////  
         
    /**
    *Método que reparte una carta aleatoria y resta del mazo sin repartir uno.
    *@return Carta que ha sido seleccionada
    */
    public SpanishCard deal()
            {
            int suit=0;
            int num=0;
            do
                {
                suit=(int)(Math.random()*4);
                if(full_deck==true)
                    {
                    num=(int)(Math.random()*12);
                    }
                else
                    {
                    num=(int)(Math.random()*10);
                    }
                } while(spa_deck[suit][num].getDealed());
            spa_deck[suit][num].setDealed(true);
            deck--;
            return spa_deck[suit][num];
            }   //deal end

    /**
    *Método que baraja las cartas devolviendolas al mazo.
    */ 
    public void shuffle()
        {
        if(full_deck)
            {
            deck=48;
            }
        else
            {
            deck=40;
            }
        for(int suit=0; suit<=3; suit++)
            {
            for(int num=0; num<spa_deck[0].length; num++)
                {
                spa_deck[suit][num].setDealed(false);
                }
            }
        }   //fin shuffle
    
    @Override
    /**
    *Sobreescritura del método toString para ajustarse a las necesidades de la clase
    *@return String deseada con la información del objeto
    */ 
    public String toString() 
        {
        String card_string="";
        for (int suit=SpanishCard.OROS; suit<=SpanishCard.BASTOS; suit++) 
            {
            for (int num=SpanishCard.AS; num<=SpanishCard.REY; num++) 
                {
                if (full_deck) 
                    {
                    card_string=card_string+spa_deck[suit][num-1].toString()+"\n";
                    }
                else 
                    {
                    if (num==SpanishCard.SOTA || num==SpanishCard.CABALLO || num==SpanishCard.REY) 
                        {
                        card_string=card_string+spa_deck[suit][num-3].toString()+"\n";                        
                        }
                    else if (num<=7) 
                        {
                        card_string=card_string+spa_deck[suit][num-1].toString()+"\n";
                        }
                    }
                }
            }
        return card_string;
        }
    }


