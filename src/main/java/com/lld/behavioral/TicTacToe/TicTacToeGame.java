package com.lld.behavioral.TicTacToe;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.lld.behavioral.TicTacToe.model.Board;
import com.lld.behavioral.TicTacToe.model.Player;
import com.lld.behavioral.TicTacToe.model.PlayingPieceO;
import com.lld.behavioral.TicTacToe.model.PlayingPieceX;

public class TicTacToeGame {
    private final Board board;
    private final Deque<Player> players;
    private final Scanner scanner;

    public TicTacToeGame(int size, List<Player> players) {
        this.board = new Board(size);
        this.players = new ArrayDeque<>(players);
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        while (!board.isBoardFull()) {
            board.printBoard();

            Player currentPlayer = players.pollFirst();
            System.out.println(currentPlayer.getName() + "'s turn ("
                    + currentPlayer.getPlayingPiece().pieceType
                    + "). Enter row and col (0 to " + (board.getSize() - 1) + "): ");

            int row;
            int col;
            try {
                row = scanner.nextInt();
                col = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter two integers.");
                scanner.nextLine();
                players.addFirst(currentPlayer);
                continue;
            }

            if (!board.isBoardValid(row, col)) {
                System.out.println("That cell is out of range or already taken. Try again.");
                players.addFirst(currentPlayer);
                continue;
            }

            board.addPiece(row, col, currentPlayer.getPlayingPiece());

            if (board.isWinner(currentPlayer.getPlayingPiece())) {
                board.printBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                return;
            }

            players.addLast(currentPlayer);
        }

        board.printBoard();
        System.out.println("It's a draw!");
    }

    public static void main(String[] args) {
        List<Player> players = List.of(
                new Player("Player 1", new PlayingPieceX()),
                new Player("Player 2", new PlayingPieceO()));
        TicTacToeGame game = new TicTacToeGame(3, players);
        game.startGame();
    }
}
