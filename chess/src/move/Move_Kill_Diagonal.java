package move;

import chess.Case;
import chess.Couleur;
import chess.Echiquier;
import chess.Position;
import piece.Piece;

public class Move_Kill_Diagonal extends Move{

	public Move_Kill_Diagonal(Echiquier echiquier,Piece piece) {
		super(echiquier,piece);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canmove(Case next_case) {
		// TODO Auto-generated method stub
		Position current_pos = m_piece.m_case_courante.getPosition();
		
		int diff_ligne= next_case.getPosition().m_ligne-current_pos.m_ligne;
		int diff_colonne=Math.abs(next_case.getPosition().m_colonne-current_pos.m_colonne);
			
		
		if(next_case.isUsed()) {
			if(m_piece.getCouleur() == Couleur.WHITE) {
				return diff_ligne==-1 && diff_colonne==1 && next_case.getPion().getCouleur() == Couleur.BLACK;
			}else {
				return diff_ligne==1 && diff_colonne==1 && next_case.getPion().getCouleur() == Couleur.WHITE;
			}
		}else {
			return false;
		}
		
	}

}
