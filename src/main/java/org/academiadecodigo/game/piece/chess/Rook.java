package org.academiadecodigo.game.piece.chess;

import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.PieceColorType;
import org.academiadecodigo.game.utils.chess.Directions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tekman on 24/12/2016.
 */
public class Rook extends ChessPiece {


    public Rook(Position pos, PieceColorType color) {
        super(pos, color, 8, Rook.class);
        List<Directions> directions = new LinkedList<Directions>();
        directions.add(Directions.DOWN);
        directions.add(Directions.LEFT);
        directions.add(Directions.RIGHT);
        directions.add(Directions.UP);
        setDirections(directions);
    }



    public Rook(int col, int row, PieceColorType color) {
        super(new Position(col, row), color, 8, Rook.class);
    }




}
