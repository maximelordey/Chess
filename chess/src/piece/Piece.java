package piece;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Vector;
import chess.Case;
import chess.Couleur;
import move.Move;

public abstract class Piece {
	
	
	
	
	public static final int IMGSIZE=21;

	protected Vector<Move> m_moves;
	protected Couleur m_couleur;
	protected BufferedImage m_image;
	private Boolean m_first_move;
	public Case m_case_courante;

	public Piece(Couleur couleur, Case case_courante) {
		m_moves = new Vector<Move>();
		m_couleur = couleur;
		if(case_courante.addPion(this)) {
			m_case_courante=case_courante;
		}
		m_first_move = false;
	}

	public Couleur getCouleur() {
		return m_couleur;
	}

	public boolean move(Case nextCase) {
		boolean move = canmove(nextCase);
		if (move && nextCase.addPion(this)) {
			m_case_courante.removePion();
			m_case_courante = nextCase;
			m_first_move=true;
			return true;
		} else {
			return false;
		}
	}

	public boolean canmove(Case nextCase) {
		boolean canmove = false;
		for (Move move : m_moves) {
			canmove = canmove || move.canmove(nextCase);
		}
		return canmove;
	}

	public abstract void paint(Graphics g, int x_abs, int y_abs);
	
	public abstract String toString() ;

	public boolean asMoved() {
		return m_first_move;
	}
}
