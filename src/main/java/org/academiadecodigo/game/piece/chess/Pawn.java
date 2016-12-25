package org.academiadecodigo.game.piece.chess;

import org.academiadecodigo.game.piece.ChessPiece;
import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.PieceColorType;

/**
 * Created by tekman on 24/12/2016.
 */
public class Pawn extends ChessPiece {

    public Pawn(Position pos, PieceColorType color) {
        super(pos, color, 2);
    }

    public Pawn(int col, int row, PieceColorType color) {
        super(new Position(col, row), color, 2);
    }
}
