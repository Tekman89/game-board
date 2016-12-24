package org.academiadecodigo.game.utils;


import org.academiadecodigo.game.piece.Piece;
import org.academiadecodigo.game.position.Position;

/**
 * Created by tekman on 24/12/2016.
 */
public abstract class Move {


    private Position pos;

    private Piece piece;

    public void setPosition(Position position) {
        this.pos = position;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Position getPosition() {
        return pos;
    }

    public Piece getPiece() {
        return piece;
    }

    public void reset() {
        piece = null;
        pos = null;
    }

}
