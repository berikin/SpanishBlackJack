/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.jimenezfrontend;

import es.jimenezfrontend.cards.GameValues;
import es.jimenezfrontend.cards.SpanishCard;
import es.jimenezfrontend.cards.SpanishDeck;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author berik
 */
public class Game {

    /////////////////////////////////////////////////////////////////////////////////////////
    //
    // CONSTANTES
    //
    /////////////////////////////////////////////////////////////////////////////////////////
    final int SUITS = 4, NUMBERS = 10;
    final double MAX = 7.5, SCORE = 0.0;
    /////////////////////////////////////////////////////////////////////////////////////////
    //
    // VARIABLES
    //
    /////////////////////////////////////////////////////////////////////////////////////////		
    double aux_value = 0.0, visible_value = 0.0;
    double AI_score = 0.0;
    char plan = 'a';
    int aux_num;
    int aux_suit;
    int stops = 0;
    int pause = 0;
    int player_numb;
    Player[] players;
    Double[] player_values;
    SpanishDeck deck;
    SpanishCard[][] cards;
    private final Object lock = new Object();
    private static Game INSTANCE = null;

    // Private constructor suppresses 
    private Game() {
    }

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple 
    private synchronized static void createInstance() {
	if (INSTANCE == null) {
	    INSTANCE = new Game();

	}
    }

    public static Game getInstance() {
	createInstance();

	return INSTANCE;
    }

    public void makeGame(int gamers) {
	/////////////////////////////////////////////////////////////////////////////////////////
	//
	// CREACION DE LA BARAJA
	//
	/////////////////////////////////////////////////////////////////////////////////////////
	deck = new SpanishDeck(false); //CREACIÓN DEL MAZO
	cards = new SpanishCard[SUITS][NUMBERS]; //CREACIÓN DE CARTAS
	GameValues.sieteYMedia(SUITS, NUMBERS, cards); //ASIGNACIÓN DE VALORES
	player_numb = gamers;
	players = new Player[gamers];
	player_values = new Double[gamers];
	for (int i = 0; i < gamers; i++) {
	    player_values[i] = 0.0;
	    players[i] = new Player("pepe", i);
	}
    }

    public String[] Deal() {
	SpanishCard naipe = new SpanishCard(1, 1);
	naipe = deck.deal();
	aux_num = naipe.getIntNumber(false);
	aux_suit = naipe.getIntSuit();
	String response[] = new String[2];
	response[1] = Double.toString(cards[aux_suit][aux_num].getValue());
	response[0] = naipe.getIntSuit() + "" + naipe.getIntNumber(false) + ".gif";
	pause++;
	return response;
    }

    public boolean exitpause() {
	return pause == player_numb;
    }


    public String[] stopThread(int player_number, double player_value) {
	String[] response = new String[2];
	System.out.println("parando");
	player_values[player_number] = player_value;
	stops++;
	if (player_value == 7.5) {
	    response[0] = "Te has plantado en el momento justo";
	}
	else if (player_value > 7.5) {
	    response[0] = "¡Vaya!, te has pasado";
	}
	else {
	    response[0] = "Te has quedado algo corto, pero aún podrías ganar";
	}
	if (stops == 4) {
	    System.out.println("Juego terminado");
	}
	return response;
    }

}
