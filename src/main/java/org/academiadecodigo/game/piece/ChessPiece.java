package org.academiadecodigo.game.piece;

import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.chess.PieceColorType;

/**
 * Created by tekman on 24/12/2016.
 */
public abstract class ChessPiece extends Piece {

    private PieceColorType color;


    public ChessPiece(Position pos, PieceColorType color) {
        super(pos);
        this.color = color;

    }

    private PieceColorType getColor() {
        return color;
    }

}
