package org.academiadecodigo.game;

/**
 * Created by tekman on 24/12/2016.
 */
public class Position {

    private int col;
    private int row;
    private Piece piece;

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void removePiece() {
        piece = null;
    }
}
