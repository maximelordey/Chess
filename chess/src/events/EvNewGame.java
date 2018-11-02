package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Game;

public class EvNewGame implements ActionListener{

	public Game m_game;
	
	public EvNewGame(Game game){
		m_game=game;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		m_game.init();
	}

}
