package org.academiadecodigo.game.piece.chess;

import org.academiadecodigo.game.piece.ChessPiece;
import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.PieceColorType;
import org.academiadecodigo.game.utils.chess.Directions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tekman on 25/12/2016.
 */
public class Queen extends ChessPiece {

    public Queen(Position pos, PieceColorType color) {
        super(pos, color, 8, Queen.class);
    }

    public Queen(int col, int row, PieceColorType color) {
        super(new Position(col, row), color, 8, Queen.class);
        setDirections(Directions.getList());
    }
}
