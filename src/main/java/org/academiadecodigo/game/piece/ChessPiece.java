package org.academiadecodigo.game.piece;

import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.PieceColorType;

import java.util.List;


/**
 * Created by tekman on 24/12/2016.
 */
public abstract class ChessPiece extends Piece {


    private boolean danger;


    public ChessPiece(Position pos, PieceColorType color, int maxDistance, Class subclass) {
        super(pos, maxDistance, color, subclass);

    }

    public void move(Position position) {
        setPos(position);
    }


    public boolean isInDanger() {
        return danger;
    }

    public void setDanger(boolean danger) {
        this.danger = danger;
    }



}
