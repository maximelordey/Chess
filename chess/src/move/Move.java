package move;

import chess.Case;
import chess.Echiquier;
import chess.Position;
import piece.Piece;

public abstract class Move {
	
	protected Echiquier m_echiquier;
	protected Piece m_piece;
	
	public Move(Echiquier echiquier,Piece piece) {
		m_echiquier=echiquier;
		m_piece = piece;
	}

	public abstract boolean canmove(Case next_case);
}
