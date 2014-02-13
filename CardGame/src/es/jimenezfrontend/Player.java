/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.jimenezfrontend;

import es.jimenezfrontend.gui.PlayerForm;

/**
 *
 * @author berik
 */
public class Player implements Runnable {

    private String name;
    private int player_number;
    private Thread t;

    public Player(String name, int player_number) {
	this.name = name;
	this.player_number = player_number;
	t = new Thread(this);
	t.start();
    }
    
    
    
    @Override
    public void run() {

	PlayerForm prueba = new PlayerForm(name, player_number);
	prueba.setSize(800, 500);
	prueba.setVisible(true);
	prueba.setTitle("Juego de las Siete y Media");
	prueba.setLocationRelativeTo(null);
    }

}
