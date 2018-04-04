package org.academiadecodigo.game.piece.chess;

import org.academiadecodigo.game.piece.Piece;
import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.PieceColorType;
import org.academiadecodigo.game.utils.PieceType;
import org.academiadecodigo.game.utils.chess.ChessPieceType;


/**
 * Created by tekman on 24/12/2016.
 */
public class ChessPiece extends Piece<ChessPiece> {


    private boolean danger;
    private PieceType type;


    public ChessPiece(Position pos, PieceColorType color, ChessPieceType type) {
        super(pos, type.getRange(), color);
        this.type = type;

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
