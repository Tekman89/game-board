package org.academiadecodigo.game;

import org.academiadecodigo.game.utils.chess.PieceColorType;

/**
 * Created by tekman on 24/12/2016.
 */
public abstract class Piece {

    private Position position;
    private PieceColorType color;

    public Position getPos() {
        return position;
    }

    public void setPos(Position pos) {
        this.position = pos;
    }
}
