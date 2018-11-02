package move;

import chess.Case;
import chess.Couleur;
import chess.Echiquier;
import chess.Position;
import piece.Piece;

public class Move_Diagonal extends Move{

	public Move_Diagonal(Echiquier echiquier,Piece piece) {
		super(echiquier,piece);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canmove(Case next_case) {
		// TODO Auto-generated method stub
		boolean canmove = false;
		Position current_pos = m_piece.m_case_courante.getPosition();
		
		int diff_ligne= next_case.getPosition().m_ligne-current_pos.m_ligne;
		int diff_colonne=next_case.getPosition().m_colonne-current_pos.m_colonne;
		
		
		boolean condition_1=Math.abs(diff_ligne) == Math.abs(diff_colonne);
		boolean condition_2= !next_case.isUsed() || (next_case.isUsed() && next_case.getPion().getCouleur() != m_piece.getCouleur());
		
		int i; // ligne
		int j; // colonne
		if (condition_1 && condition_2) {
			if (diff_ligne > 0) {
				if (diff_colonne > 0) {
					i=current_pos.m_ligne+1;
					j=current_pos.m_colonne+1;
					while(i<next_case.getPosition().m_ligne && j<next_case.getPosition().m_colonne && !this.m_echiquier.getCase(i, j).isUsed()) {
						i++;
						j++;
					}			
				} else {
					i=current_pos.m_ligne+1;
					j=current_pos.m_colonne-1;
					while(i<next_case.getPosition().m_ligne && j>next_case.getPosition().m_colonne && !this.m_echiquier.getCase(i, j).isUsed()) {
						i++;
						j--;
					}
				}
			} else {
				if (diff_colonne > 0) {
					i=current_pos.m_ligne-1;
					j=current_pos.m_colonne+1;
					while(i>next_case.getPosition().m_ligne && j<next_case.getPosition().m_colonne && !this.m_echiquier.getCase(i, j).isUsed()) {
						i--;
						j++;
					}
				} else {
					i=current_pos.m_ligne-1;
					j=current_pos.m_colonne-1;
					while(i>next_case.getPosition().m_ligne && j>next_case.getPosition().m_colonne && !this.m_echiquier.getCase(i, j).isUsed()) {
						i--;
						j--;
					}
				}
			}			
			return i==next_case.getPosition().m_ligne && j==next_case.getPosition().m_colonne;
		}else {
			return false;
		}

	}

}
