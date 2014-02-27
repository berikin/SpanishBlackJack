package es.jimenezfrontend.objects;

import es.jimenezfrontend.gui.IAForm;
import es.jimenezfrontend.gui.PlayerForm;

/**
* DAM, IES Ribera de Castilla
* @author José Antonio
*/
public class Player implements Runnable {

    private String name;
    private int player_number;
    private Thread t;
    protected PlayerForm form_window;
    protected IAForm fwindow;
    private boolean is_playing = true;
    private boolean is_human;

    public Player(String name, int player_number, boolean human) {
	this.name = name;
	this.is_human = human;
	this.player_number = player_number;
	t = new Thread(this);
	t.start();
    }

    @Override
    public void run() {
	if (is_human) {
	    form_window = new PlayerForm(name, player_number);
	    form_window.setSize(800, 500);
	    form_window.setVisible(true);
	    form_window.setTitle("Juego de las Siete y Media");
	    form_window.setLocationRelativeTo(null);
	}
	else {
	    System.out.println("IAAA");
	    fwindow = new IAForm(name, player_number);
	    fwindow.setSize(800, 500);
	    fwindow.setVisible(true);
	    fwindow.setTitle("Juego de las Siete y Media");
	    fwindow.setLocationRelativeTo(null);
	}
    }

    public String getName() {
	return name;
    }

    protected void playerAbandon() {
	is_playing = false;
    }

    protected boolean isPlaying() {
	return is_playing;
    }

    protected boolean isHuman() {
	return is_human;
    }

}
