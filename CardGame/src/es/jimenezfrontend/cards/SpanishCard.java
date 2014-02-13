package es.jimenezfrontend.cards;

/**
 * DAM, IES Ribera de Castilla
 * @author José Antonio
 */

/**
*Clase para instanciar un naipe espanol.
*/
public class SpanishCard 
    {
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    //
    //Atributos
    //
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    
    private int num;
    private String suit;
    private double value;
    private boolean dealed;
    
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    //
    //Constantes
    //
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    
    public final static int OROS=0;
    public final static int COPAS=1;
    public final static int ESPADAS=2;
    public final static int BASTOS=3;
    
    public final static int AS=1;
    public final static int SOTA=10;
    public final static int CABALLO=11;
    public final static int REY=12;
    
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    //
    //Constructores
    //
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    
    /**
    *Este constructor inicia la carta con su valor fijado en 0.
    *Las cartas siempre tienen la variable que indica si están repartidas como false
    *inicialmente.
    *@param num Entero que indica el número de carta
    *@param suit String que indica el palo
    */
    public SpanishCard(int num, String suit)
        {
        this.num=num;
        this.suit=suit.toUpperCase();
        this.value=0.0;
        this.dealed=false;
        }

    /**
    *Este constructor inicia la carta asignando también un valor a la misma.
    *Las cartas siempre tienen la variable que indica si están repartidas como false
    *inicialmente.
    *@param num Entero que indica el número de carta
    *@param suit String que indica el palo
    *@param value Double que indica el valor de la carta
    */  
    public SpanishCard(int num, String suit, double value)
        {
        this.num=num;
        this.suit=suit.toUpperCase();
        this.value=value;
        this.dealed=false;
        }
    
    /**
    *Este constructor inicia la carta recibiendo el palo como un valor numérico.
    *Las cartas siempre tienen la variable que indica si están repartidas como false
    *inicialmente.
    *@param num Entero que indica el número de carta
    *@param suit Entero que indica el palo (Los valores están definidos en constantes)
    */ 
    public SpanishCard(int num, int suit)
        {
        this.num=num;
        switch(suit)
            {
            case OROS:
                this.suit="OROS";
                break;
            case COPAS:
                this.suit="COPAS";
                break;
            case ESPADAS:
                this.suit="ESPADAS";
                break;
           case BASTOS:
                this.suit="BASTOS";
                break;     
                
            }
        this.value=0.0;
        this.dealed=false;
        }

    /**
    *Este constructor inicia la carta recibiendo el palo como un valor numérico y
    *asignando también un valor a la misma.
    *Las cartas siempre tienen la variable que indica si están repartidas como false
    *inicialmente.
    *@param num Entero que indica el número de carta
    *@param suit Entero que indica el palo (Los valores están definidos en constantes)
    *@param value Double que indica el valor de la carta
    */     
    public SpanishCard(int num, int suit, double value)
        {
        this.num=num;
        switch(suit)
            {
            case OROS:
                this.suit="OROS";
                break;
            case COPAS:
                this.suit="COPAS";
                break;
            case ESPADAS:
                this.suit="ESPADAS";
                break;
           case BASTOS:
                this.suit="BASTOS";
                break;     
                
            }
        this.value=value;
        this.dealed=false;
        }

    /**
    *Este constructor inicia la carta recibiendo el palo y el número como un valor String.
    *Las cartas siempre tienen la variable que indica si están repartidas como false
    *inicialmente. El valor asignado es 0.
    *@param num String que indica el número de carta
    *@param suit String que indica el palo
    */ 
    public SpanishCard(String num, String suit)
        {
        switch(num)
            {
            case "AS":
                this.num=1;
                break;
            case "SOTA":
                this.num=10;
                break;
            case "CABALLO":
                this.num=11;
                break;
           case "REY":
                this.num=12;
                break;     
                
            }
        this.suit=suit.toUpperCase();
        this.value=0.0;
        this.dealed=false;
        }
   
    /**
    *Este constructor inicia la carta recibiendo el palo y el número como un valor String y
    *asignando también un valor a la misma.
    *Las cartas siempre tienen la variable que indica si están repartidas como false
    *inicialmente. El valor asignado es 0.
    *@param num String que indica el número de carta
    *@param suit String que indica el palo
    *@param value Double que indica el valor de la carta
    */     
    public SpanishCard(String num, String suit, double value)
        {
        switch(num)
            {
            case "AS":
                this.num=1;
                break;
            case "SOTA":
                this.num=10;
                break;
            case "CABALLO":
                this.num=11;
                break;
            case "REY":
                this.num=12;
                break;     
                
            }
        this.suit=suit.toUpperCase();
        this.value=value;
        this.dealed=false;
        }

    /**
    *Este constructor inicia la carta recibiendo un número como String y un palo numérico.
    *El valor se fija a 0
    *Las cartas siempre tienen la variable que indica si están repartidas como false
    *inicialmente.
    *@param num String que indica el número de carta
    *@param suit int que indica el palo (Los valores están definidos en constantes)
    */ 
    public SpanishCard(String num, int suit)
        {
        switch(num)
            {
            case "AS":
                this.num=1;
                break;
            case "SOTA":
                this.num=10;
                break;
            case "CABALLO":
                this.num=11;
                break;
            case "REY":
                this.num=12;
                break;     
                
            }
        switch(suit)
            {
            case OROS:
                this.suit="OROS";
                break;
            case COPAS:
                this.suit="COPAS";
                break;
            case ESPADAS:
                this.suit="ESPADAS";
                break;
            case BASTOS:
                this.suit="BASTOS";
                break;     
                
            }
        this.value=0.0;
        this.dealed=false;
        }

    /**
    *Este constructor inicia la carta recibiendo un número como String y un palo numérico y
    *asignando también un valor a la misma.
    *Las cartas siempre tienen la variable que indica si están repartidas como false
    *inicialmente.
    *@param num String que indica el número de carta
    *@param suit int que indica el palo (Los valores están definidos en constantes)
    *@param value Double que indica el valor de la carta
    */ 
    public SpanishCard(String num, int suit, double value)
        {
        switch(num)
            {
            case "AS":
                this.num=1;
                break;
            case "SOTA":
                this.num=10;
                break;
            case "CABALLO":
                this.num=11;
                break;
            case "REY":
                this.num=12;
                break;     
                
            }
        switch(suit)
            {
            case OROS:
                this.suit="OROS";
                break;
            case COPAS:
                this.suit="COPAS";
                break;
            case ESPADAS:
                this.suit="ESPADAS";
                break;
            case BASTOS:
                this.suit="BASTOS";
                break;     
                
            }
        this.value=value;
        this.dealed=false;
        }
    
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    //
    //Setters
    //
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    
    /**
    *Fija el valor de una carta
    *@param value Double con el que asignamos el nuevo valor
    */
    public void setValue(double value)
        {
        this.value=value;
        }
    
   /**
   *Fija si la carta ha sido repartida
   *@param dealed True para indicar que la carta ha sido repartida
   */
    public void setDealed(boolean dealed)
        {
        this.dealed=dealed;
        }
    
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    //
    //Getters
    //
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////  
    
    /**
    *Para obtener el número de carta como una cadena (devolviendo as,2,3...sota, caballo, rey)
    *@return Cadena con el número de carta
    */
    public String getStrNumber()
        {
        switch(num)
            {
            case 1:
                return "AS";
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:    
                return ""+num;
            case 10:
                return "Sota";
            case 11:
                return "Caballo";
            default:
                return "Rey"; 
            }
        }
    
   /**
   *Para obtener el palo como una cadena (devolviendo oros/copas/espadas/bastos)
   *@return Cadena con el palo de la carta
   */
    public String getStrSuit()
        {
        return suit;
        }

    
    /**
    *Para obtener el número de carta como un entero !-Devuelve la posición del array
    *(devolviendo 0,1,2,3...)
    *@return Cadena con el número de carta
    */
    public int getIntNumber(boolean dealed)
        {
        if (dealed==false && num>7)
            {
            return num-3;
            }
        return num-1;
        }
    
    
    /**
    *Para obtener el palo de carta como un entero (devolviendo 0/1/2/3)
    *@return Entero con el palo de la carta
    */
    public int getIntSuit()
        {
        switch (this.suit)
            {
            case "OROS":
                return 0;
            case "COPAS":
                return 1;
            case "ESPADAS":
                return 2;
            default:
                return 3;
            }
        }

    /**
    *Para obtener el valor de carta como un double
    *@return Double con el valor de la carta
    */    
    public double getValue()
        {
        return value;
        }

    /**
    *Para saber si la carta ha sido repartida
    *@return True si ha sido repartida, false si no lo ha sido.
    */     
    public boolean getDealed()
        {
        return dealed;
        }
 
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    //
    //Otros
    //
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////     
    
    @Override
    /**
    *Sobreescritura del método toString para ajustarse a las necesidades de la clase
    *@return String deseada con la información del objeto
    */ 
    public String toString()
        {
        return "["+num+", "+suit+", "+value+", "+dealed+"]";
        }      
    }
