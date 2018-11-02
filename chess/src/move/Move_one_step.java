package move;

import chess.Case;
import chess.Echiquier;
import chess.Position;
import piece.Piece;
import piece.Pawn;

public class Move_one_step extends Move{

	public Move_one_step(Echiquier echiquier,Piece piece) {
		super(echiquier,piece);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canmove(Case next_case) {
		
		Piece pion = next_case.getPion();
		
		if (pion != null && pion.getCouleur() == m_piece.getCouleur()) {
			return false;
		}
		
		Position current_pos = m_piece.m_case_courante.getPosition();
		
		int diff_ligne= Math.abs(next_case.getPosition().m_ligne-current_pos.m_ligne);
		int diff_colonne=Math.abs(next_case.getPosition().m_colonne-current_pos.m_colonne);
		
		
		boolean condition_1 = !(pion != null && pion.getCouleur() == m_piece.getCouleur());
		boolean condition_2 = diff_ligne<=1  && diff_colonne<=1;
		
		
		if (condition_1  && condition_2) {
			return true;
		}else {
			return false;
		}
	}

}
