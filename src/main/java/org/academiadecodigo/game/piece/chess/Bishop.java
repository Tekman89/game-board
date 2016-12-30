package org.academiadecodigo.game.piece.chess;

import org.academiadecodigo.game.piece.ChessPiece;
import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.PieceColorType;
import org.academiadecodigo.game.utils.chess.Directions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tekman on 25/12/2016.
 */
public class Bishop extends ChessPiece {


    public Bishop(Position pos, PieceColorType color) {
        super(pos, color, 8, Bishop.class);
        List<Directions> directions = new LinkedList<Directions>();
        directions.add(Directions.DOWNLEFT);
        directions.add(Directions.DOWNRIGHT);
        directions.add(Directions.UPLEFT);
        directions.add(Directions.UPRIGHT);
        setDirections(directions);
    }

    public Bishop(int col, int row, PieceColorType color) {
        super(new Position(col, row), color, 8, Bishop.class);
        List<Directions> directions = new LinkedList<Directions>();
        directions.add(Directions.DOWNLEFT);
        directions.add(Directions.DOWNRIGHT);
        directions.add(Directions.UPLEFT);
        directions.add(Directions.UPRIGHT);
        setDirections(directions);
    }
}
