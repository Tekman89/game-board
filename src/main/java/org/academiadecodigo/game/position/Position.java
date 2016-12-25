package org.academiadecodigo.game.position;

import org.academiadecodigo.game.piece.Piece;

/**
 * Created by tekman on 24/12/2016.
 */
public class Position {

    private int col;
    private int row;
    private Piece piece;

    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void removePiece() {
        piece = null;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
