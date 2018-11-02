package main;
import chess.Couleur;
import chess.Echiquier;
import java.awt.Graphics;

public class Game {

	private Echiquier m_echiquier;
	private Couleur m_current_player;
	
	public Game() {
		m_echiquier = new Echiquier();
		m_current_player= Couleur.WHITE;
	}
	
	public void changePlayer() {
		if (m_current_player == Couleur.WHITE) {
			m_current_player = Couleur.BLACK;
		}else {
			m_current_player = Couleur.WHITE;
		}
	}

	public Couleur getPlayer() {
		return m_current_player;
	}
	
	public Echiquier getEchiquier() {
		return m_echiquier;
	}

	
	public void paint(Graphics g){
		m_echiquier.paint(g);
	}

	public void init() {
		// TODO Auto-generated method stub
		m_current_player= Couleur.WHITE;
		m_echiquier.init();		
	}
	
}
