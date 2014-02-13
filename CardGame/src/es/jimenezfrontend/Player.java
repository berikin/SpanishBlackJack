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
public class Player implements Runnable
    {

    private String name;
    private int player_number;
    private Thread t;
    protected PlayerForm form_window;
    private boolean is_playing = true;

    public Player(String name, int player_number)
	{
	this.name = name;
	this.player_number = player_number;
	t = new Thread(this);
	t.start();
	}

    @Override
    public void run()
	{

	form_window = new PlayerForm(name, player_number);
	form_window.setSize(800, 500);
	form_window.setVisible(true);
	form_window.setTitle("Juego de las Siete y Media");
	form_window.setLocationRelativeTo(null);
	}

    public String getName()
	{
	return name;
	}

    protected void playerAbandon()
	{
	is_playing = false;
	}

    protected boolean isPlaying()
	{
	return is_playing;
	}

    }
