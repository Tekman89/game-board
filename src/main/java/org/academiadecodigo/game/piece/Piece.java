package org.academiadecodigo.game.piece;

import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.chess.PieceColorType;

/**
 * Created by tekman on 24/12/2016.
 */
public abstract class Piece {

    private Position position;
    private boolean eaten;

    public Piece(Position pos) {
        this.position = pos;
        eaten = false;
    }

    public Position getPos() {
        return position;
    }

    public void setPos(Position pos) {
        this.position = pos;
    }

    public void setEaten(boolean eaten) {
        this.eaten = eaten;
    }

    public boolean getEaten() {
        return eaten;
    }


    //needs to be overwritten
    public abstract void move(Position position);
}
