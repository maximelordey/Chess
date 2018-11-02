package move;

import chess.Case;
import chess.Couleur;
import chess.Echiquier;
import chess.Position;
import piece.Piece;

public class Move_Front2 extends Move {

	public Move_Front2(Echiquier echiquier,Piece piece) {
		super(echiquier,piece);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canmove(Case next_case) {
		// TODO Auto-generated method stub
		if (m_piece.asMoved()) {
			return false;
		}

		Position current_pos = m_piece.m_case_courante.getPosition();

		int diff_ligne = next_case.getPosition().m_ligne - current_pos.m_ligne;
		int diff_colonne = next_case.getPosition().m_colonne - current_pos.m_colonne;

		boolean condition_1 = !next_case.isUsed()
				|| (next_case.isUsed() && next_case.getPion().getCouleur() != m_piece.getCouleur());
		boolean condition_2 = m_piece.getCouleur() == Couleur.WHITE;
		boolean condition_3;
		boolean condition_4;

		if (condition_1) {
			int ligne;
			int ajout;
			if (condition_2) {
				ligne = -2;
				ajout = 1;
			} else {
				ligne = 2;
				ajout = -1;

			}
			condition_3 = (diff_ligne == ligne && diff_colonne == 0 && !next_case.isUsed());
			Case case1 = this.m_echiquier.getCase(next_case.getPosition().m_ligne + ajout,next_case.getPosition().m_colonne);
			if (case1 == null) {
				condition_4 = false;
			} else {
				condition_4 = !case1.isUsed();
			}
			return condition_3 && condition_4;
		} else {
			return false;
		}
	}

}
