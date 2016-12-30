package org.academiadecodigo.game.piece.chess;

import org.academiadecodigo.game.piece.Piece;
import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.PieceColorType;
import org.academiadecodigo.game.utils.PieceType;


/**
 * Created by tekman on 24/12/2016.
 */
public class ChessPiece extends Piece {


    private boolean danger;
    private PieceType type;


    public ChessPiece(Position pos, PieceColorType color, int maxDistance, PieceType type) {
        super(pos, maxDistance, color);

    }

    public void move(Position position) {
        setPos(position);
    }

    public PieceType getType() {
        return type;
    }


    public boolean isInDanger() {
        return danger;
    }

    public void setDanger(boolean danger) {
        this.danger = danger;
    }


}
