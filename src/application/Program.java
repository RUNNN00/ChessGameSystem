package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList();

		while (!chessMatch.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printWelcome();
				
				UI.printMatch(chessMatch, captured);
				System.out.print("\nSource: ");
				ChessPosition source = UI.readChessPosition(scanner);
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				
				UI.clearScreen();
				UI.printWelcome();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				System.out.print("\ntarget: ");
				ChessPosition target = UI.readChessPosition(scanner);

				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				if (capturedPiece != null)
					captured.add(capturedPiece);
				
				if (chessMatch.getPromoted() != null) {
					System.out.print("Enter piece for promotion (B/K/R/Q): ");
					String type = scanner.nextLine().toUpperCase();
					while (!type.equals("B") && !type.equals("K") && !type.equals("R") && !type.equals("Q")) {
						System.out.print("Invalid value! Enter piece for promotion (B/K/R/Q): ");
						type = scanner.nextLine().toUpperCase();
					}
					chessMatch.replacePromotedPiece(type);
				}
				
			} catch (ChessException e) {
				System.out.println(e.getMessage());
				scanner.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				scanner.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
	}
}
