package org.academiadecodigo.game.piece;

import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.PieceColorType;


/**
 * Created by tekman on 24/12/2016.
 */
public abstract class ChessPiece extends Piece {



    public ChessPiece(Position pos, PieceColorType color, int maxDistance) {
        super(pos, maxDistance, color);

    }

    public void move(Position position) {
        setPos(position);
    }



}
