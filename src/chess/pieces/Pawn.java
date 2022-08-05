package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);

		if (getColor() == Color.WHITE) {
			p.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;

				// Rule for the first movement
				if (getMoveCount() == 0) {
					p.setValues(position.getRow() - 2, position.getColumn());
					if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
				}
			}

			// Diagonal left
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p))
				mat[p.getRow()][p.getColumn()] = true;

			// Diagonal right
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p))
				mat[p.getRow()][p.getColumn()] = true;
		} else {
			p.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;

				// Rule for the first movement
				if (getMoveCount() == 0) {
					p.setValues(position.getRow() + 2, position.getColumn());
					if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
				}
			}

			// Diagonal left
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p))
				mat[p.getRow()][p.getColumn()] = true;

			// Diagonal right
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p))
				mat[p.getRow()][p.getColumn()] = true;
		}

		return mat;
	}
	
	@Override
	public String toString() {
		return "p";
	}
}
