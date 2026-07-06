package com.lld.behavioral.TicTacToe.model;

public class Board {
    private int size;
    private PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public int getSize() {
        return size;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print((board[i][j] == null ? "-" : board[i][j].pieceType) + " ");
            }
            System.out.println();
        }
    }

    public void addPiece(int row, int col, PlayingPiece playingPiece) {
        board[row][col] = playingPiece;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBoardEmpty() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBoardValid(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && board[row][col] == null;
    }
    public boolean isWinner(PlayingPiece playingPiece) {
        PieceType type = playingPiece.pieceType;

        for (int i = 0; i < size; i++) {
            if (lineMatches(type, i, 0, 0, 1)) {
                return true;
            }
            if (lineMatches(type, 0, i, 1, 0)) {
                return true;
            }
        }

        return lineMatches(type, 0, 0, 1, 1)
                || lineMatches(type, 0, size - 1, 1, -1);
    }

    private boolean lineMatches(PieceType type, int startRow, int startCol, int dRow, int dCol) {
        for (int step = 0; step < size; step++) {
            PlayingPiece cell = board[startRow + step * dRow][startCol + step * dCol];
            if (cell == null || cell.pieceType != type) {
                return false;
            }
        }
        return true;
    }
}
