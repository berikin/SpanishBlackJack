package es.jimenezfrontend;

import es.jimenezfrontend.objects.Game;
import javax.swing.JOptionPane;

/**
* DAM, IES Ribera de Castilla
* @author José Antonio
*/

public class Main {

    public static final String[] players
	    = {
		"2 jugadores", "3 jugadores", "4 jugadores", "5 jugadores", "1 jugador VS IA"
	    };

    public static void main(String[] args) {
	Game myGame = Game.getInstance();
	String player_response = (String) JOptionPane.showInputDialog(null, "Escoge el número de jugadores", "Siete y media", JOptionPane.QUESTION_MESSAGE, null, players, players[0]);
	int total_players = Integer.parseInt(player_response.substring(0, 1));
	int human_players = total_players;
	String[][] playerNames = new String[total_players][2];

	if (total_players == 1) {
	    total_players++;
	    playerNames = new String[total_players][2];
	}
	for (int i = 0; i < human_players; i++) {
	    player_response = (String) JOptionPane.showInputDialog(null, "Introduce el nombre del jugador " + (i + 1), "Nombre", JOptionPane.QUESTION_MESSAGE);
	    playerNames[i][0] = player_response;
	    playerNames[i][1] = "true";
	}
	if (human_players == 1) {
	    playerNames[1][0] = "IA";
	    playerNames[1][1] = "false";
	}
	myGame.makeGame(playerNames);
    }
}
