package org.academiadecodigo.game.piece.chess;

import org.academiadecodigo.game.piece.ChessPiece;
import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.PieceColorType;

/**
 * Created by tekman on 24/12/2016.
 */
public class King extends ChessPiece {

    public King(Position pos, PieceColorType color) {
        super(pos, color, 1);
    }

    public King(int col, int row, PieceColorType color) {
        super(new Position(col, row), color, 1);
    }

}