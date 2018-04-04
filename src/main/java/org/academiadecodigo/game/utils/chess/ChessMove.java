package org.academiadecodigo.game.utils.chess;

import org.academiadecodigo.game.piece.Piece;
import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.Move;

/**
 * Created by tekman on 25/12/2016.
 */
public class ChessMove extends Move {

    private Direction direction;

    public ChessMove(Piece p, Position pos, Direction direction) {
        super(p, pos);
        this.direction = direction;
    }

    public ChessMove(Piece p, Position pos) {
        super(p, pos);
        System.out.println("The piece " + p + " should not invoke if not a horse!!!");
    }

    public Direction getDirection() {
        return direction;
    }
}
