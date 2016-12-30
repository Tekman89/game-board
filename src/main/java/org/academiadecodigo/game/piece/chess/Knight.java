package org.academiadecodigo.game.piece.chess;

import org.academiadecodigo.game.piece.ChessPiece;
import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.PieceColorType;

/**
 * Created by tekman on 24/12/2016.
 */
public class Knight extends ChessPiece {

    public Knight(Position pos, PieceColorType color) {
        super(pos, color, 0, Knight.class);
    }

    public Knight(int col, int row, PieceColorType color) {
        super(new Position(col, row), color, 0, Knight.class);
    }
}
