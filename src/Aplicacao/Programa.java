package Aplicacao;

import boardgame.Board;
import boardgame.Position;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try {
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.println("Origem/Source: ");
                ChessPosition source = UI.readChessPosition(entrada);
                
                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.println("Destino/Target: ");
                ChessPosition target = UI.readChessPosition(entrada);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            } 
            catch (ChessException e) {
                System.out.println(e.getMessage());
                entrada.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                entrada.nextLine();
               }
            }
        }
    }
