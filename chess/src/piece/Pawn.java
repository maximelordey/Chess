package piece;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

import chess.Case;
import chess.Couleur;
import chess.Echiquier;
import move.Move;
import move.Move_Front2;
import move.Move_Kill_Diagonal;
import move.Move_Forward;

public class Pawn extends Piece{
	

	private static BufferedImage IMAGE_WHITE;
	private static BufferedImage IMAGE_BLACK;

	public Pawn(Couleur couleur, Case case_courante,Echiquier echiquier) {
		super(couleur, case_courante);
		// TODO Auto-generated constructor stub
		this.m_moves.add(new Move_Forward(echiquier,this));
		this.m_moves.add(new Move_Front2(echiquier,this));
		this.m_moves.add(new Move_Kill_Diagonal(echiquier,this));
		
		try {
			IMAGE_WHITE = ImageIO.read(new File("./DATA/pawn_white.png"));
			IMAGE_BLACK = ImageIO.read(new File("./DATA/pawn_black.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g, int x_abs, int y_abs) {
		// TODO Auto-generated method stub
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
		return "Pion";
	}

}