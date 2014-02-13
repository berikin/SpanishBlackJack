/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.jimenezfrontend;

/**
 *
 * @author berik
 */
public class Main {
    public static void main(String[] args){
	Game myGame = Game.getInstance();
	myGame.makeGame(4);
    }
}
