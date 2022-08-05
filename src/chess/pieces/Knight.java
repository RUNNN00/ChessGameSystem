package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

	public Knight(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] aux = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// above
		p.setValues(position.getRow() - 1, position.getColumn() - 2);
		if (getBoard().positionExists(p) && canMove(p))
			aux[p.getRow()][p.getColumn()] = true;

		// below
		p.setValues(position.getRow() - 2, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p))
			aux[p.getRow()][p.getColumn()] = true;

		// left
		p.setValues(position.getRow() - 2, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p))
			aux[p.getRow()][p.getColumn()] = true;

		// right
		p.setValues(position.getRow() - 1, position.getColumn() + 2);
		if (getBoard().positionExists(p) && canMove(p))
			aux[p.getRow()][p.getColumn()] = true;
		

		// nw
		p.setValues(position.getRow() + 1, position.getColumn() + 2);
		if (getBoard().positionExists(p) && canMove(p))
			aux[p.getRow()][p.getColumn()] = true;

		// ne
		p.setValues(position.getRow() + 2, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p))
			aux[p.getRow()][p.getColumn()] = true;

		// sw
		p.setValues(position.getRow() + 2, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p))
			aux[p.getRow()][p.getColumn()] = true;

		// se
		p.setValues(position.getRow() + 1, position.getColumn() - 2);
		if (getBoard().positionExists(p) && canMove(p))
			aux[p.getRow()][p.getColumn()] = true;

		return aux;
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().getPiece(position);
		return p == null || p.getColor() != getColor();
	}
	
	@Override
	public String toString() {
		return "H";
	}
}
