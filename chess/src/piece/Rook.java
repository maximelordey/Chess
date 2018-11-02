package piece;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import chess.Case;
import chess.Couleur;
import chess.Echiquier;
import move.Move_Ligne;

public class Rook extends Piece{

	private static BufferedImage IMAGE_WHITE;
	private static BufferedImage IMAGE_BLACK;
	
	public Rook(Couleur couleur, Case case_courante,Echiquier echiquier) {
		super(couleur, case_courante);
		this.move(case_courante);
		// TODO Auto-generated constructor stub
		this.m_moves.add(new Move_Ligne(echiquier,this));
		
		try {
			IMAGE_WHITE = ImageIO.read(new File("./DATA/rook_white.png"));
			IMAGE_BLACK = ImageIO.read(new File("./DATA/rook_black.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g, int x_abs, int y_abs) {
		// TODO Auto-generated method stuff
		BufferedImage image;
		if (this.m_couleur == Couleur.WHITE) {
			image = IMAGE_WHITE;
		}else {
			image = IMAGE_BLACK;
		}
		g.drawImage(image, x_abs, y_abs, null);
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Tour";
	}

}