package move;

import chess.Case;
import chess.Echiquier;
import chess.Position;
import piece.Piece;

public class Move_Horse extends Move{

	
	public Move_Horse(Echiquier echiquier,Piece piece) {
		super(echiquier,piece);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canmove(Case next_case) {
		// TODO Auto-generated method stub
		
		Position current_pos = m_piece.m_case_courante.getPosition();
		
		int diff_ligne= Math.abs(next_case.getPosition().m_ligne-current_pos.m_ligne);
		int diff_colonne=Math.abs(next_case.getPosition().m_colonne-current_pos.m_colonne);
		
		Piece case_piece = next_case.getPion();
		
		
		boolean condition_1 = !(case_piece != null && case_piece.getCouleur() == m_piece.getCouleur());
		boolean condition_2 = (diff_ligne==1  && diff_colonne==2) || (diff_ligne==2  && diff_colonne==1);
		

		if (condition_1 && condition_2){
			return true;
		}else {
			return false;
		}
	}

}
