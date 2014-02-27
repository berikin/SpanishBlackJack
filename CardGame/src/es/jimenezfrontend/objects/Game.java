package es.jimenezfrontend.objects;

import es.jimenezfrontend.*;
import es.jimenezfrontend.cards.GameValues;
import es.jimenezfrontend.cards.SpanishCard;
import es.jimenezfrontend.cards.SpanishDeck;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
* DAM, IES Ribera de Castilla
* @author José Antonio
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
    private int aux_num;
    private int aux_suit;
    private int stops;
    private int pause;
    private int player_numb;
    private Player[] players;
    private Double[] player_values;
    private SpanishDeck deck;
    private SpanishCard[][] cards;
    private final Object lock = new Object();
    private static Game INSTANCE = null;
    private ArrayList<Integer> winners;
    private boolean gameWithIA;

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

    public void clear() {
	INSTANCE = null;
    }

    public static Game getInstance() {
	createInstance();

	return INSTANCE;
    }

    public void makeGame(String[][] gamers) {
	/////////////////////////////////////////////////////////////////////////////////////////
	//
	// CREACION DE LA BARAJA
	//
	/////////////////////////////////////////////////////////////////////////////////////////
	gameWithIA = false;
	deck = new SpanishDeck(false); //CREACIÓN DEL MAZO
	cards = new SpanishCard[SUITS][NUMBERS]; //CREACIÓN DE CARTAS
	GameValues.sieteYMedia(SUITS, NUMBERS, cards); //ASIGNACIÓN DE VALORES
	player_numb = gamers.length;
	players = new Player[gamers.length];
	player_values = new Double[gamers.length];
	for (int i = 0; i < gamers.length; i++) {
	    if (Boolean.valueOf(gamers[i][1])) {
		gameWithIA = true;
	    }
	    player_values[i] = 0.0;
	    System.out.println(Boolean.valueOf(gamers[i][1]));
	    players[i] = new Player(gamers[i][0], i, Boolean.valueOf(gamers[i][1]));
	}
	stops = 0;
	pause = 0;
	winners = new ArrayList<>();
    }

    public String[] Deal() {
	SpanishCard card = new SpanishCard(1, 1);
	card = deck.deal();
	aux_num = card.getIntNumber(false);
	aux_suit = card.getIntSuit();
	String response[] = new String[3];
	response[2] = (gameWithIA) ? "true" : "false";
	response[1] = Double.toString(cards[aux_suit][aux_num].getValue());
	response[0] = card.getIntSuit() + "" + card.getIntNumber(false) + ".gif";
	pause++;
	if (exitPause()) {
	    resumeGame();
	}
	return response;
    }

    public void PauseIA(int number) {
	synchronized (players[number]) {
	    System.out.println("IA Pensando...");
	    players[number].fwindow.pausing();

	}
    }

    public void MakeIADeal() {
	for (int i = 0; i < player_numb; i++) {
	    if (!players[i].isHuman()) {
		if (players[i].isPlaying()) {
		    players[i].fwindow.get_card();
		    break;
		}
		break;
	    }
	}
    }

    public String[] IADeal() {
	SpanishCard card = new SpanishCard(1, 1);
	card = deck.deal();
	aux_num = card.getIntNumber(false);
	aux_suit = card.getIntSuit();
	String response[] = new String[3];
	response[2] = "false";
	if (stops == 1) {
	    response[2] = "true";
	}
	response[1] = Double.toString(cards[aux_suit][aux_num].getValue());
	response[0] = card.getIntSuit() + "" + card.getIntNumber(false) + ".gif";
	pause++;
	if (exitPause()) {
	    resumeGame();
	}
	return response;
    }

    private void resumeGame() {
	pause = 0;
	for (int i = 0; i < player_numb; i++) {
	    if (players[i].isPlaying()) {
		if (players[i].isHuman()) {
		    players[i].form_window.resume_game();
		}
	    }
	}
    }

    private void endGame() {
	System.out.println("fin del juego");
	int max = 0;
	double betterVal = 0.0;
	winners = new ArrayList<>();
	for (int j = 0; j < player_values.length; j++) {
	    if (player_values[j] > betterVal && player_values[j] <= MAX) {
		betterVal = player_values[j];
		max = j;
	    }
	}
	for (int j = 0; j < player_values.length; j++) {
	    if (player_values[j] == betterVal) {
		winners.add(j);
	    }
	}
	String outPut = "";
	outPut += (winners.size() > 1) ? "Los ganadores son " : "El ganador es " + players[winners.get(0)].getName();
	if (winners.size() > 1) {
	    for (int j = 0; j < winners.size(); j++) {
		outPut += (j == (winners.size() - 1)) ? "y " + players[j].getName() : ((j + 2) == winners.size()) ? players[j].getName() + " " : players[j].getName() + ", ";
	    }
	}
	int result = JOptionPane.showOptionDialog(null,
		outPut,
		"Fin del juego",
		JOptionPane.OK_CANCEL_OPTION,
		JOptionPane.INFORMATION_MESSAGE,
		null,
		new String[]{
		    "Nueva partida", "Salir"
		}, // this is the array
		"default");

	if (result == JOptionPane.YES_OPTION) {
	    System.out.println("reiniciando");
	    exitGame();

	}
	else {
	    System.out.println("saliendo");
	    System.exit(0);
	}
    }

    public void exitGame() {
	for (int i = 0; i < player_numb; i++) {
	    if (players[i].isHuman()) {
		players[i].form_window.dispose();
	    }
	    else {
		players[i].fwindow.dispose();
	    }
	}
	Main.main(null);
    }

    private boolean exitPause() {
	return (pause + stops) == player_numb;
    }

    private boolean allFinished() {
	return stops == player_numb;
    }

    public String[] stopThread(int player_number, double player_value) {
	String[] response = new String[2];
	System.out.println("pausas: " + pause);
	System.out.println("paradas: " + stops);
	players[player_number].playerAbandon();
	player_values[player_number] = player_value;
	stops++;
	if (player_value == MAX) {
	    response[0] = "Te has plantado en el momento justo";
	}
	else if (player_value > MAX) {
	    pause = (pause - 1 >= 0) ? pause : 0;
	    response[0] = "¡Vaya!, te has pasado";
	}
	else {
	    response[0] = "Te has quedado algo corto, pero aún podrías ganar";
	}
	if (gameWithIA && players[player_number].isHuman()) {
	    MakeIADeal();
	}
	if (allFinished()) {
	    endGame();
	}
	if (exitPause()) {
	    resumeGame();
	}

	return response;
    }

}
