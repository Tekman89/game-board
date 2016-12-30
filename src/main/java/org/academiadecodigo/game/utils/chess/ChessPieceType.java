package org.academiadecodigo.game.utils.chess;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tekman on 30/12/2016.
 */
public enum ChessPieceType {

    ROOK,
    KNIGHT,
    BISHOP,
    KING,
    PAWN,
    QUEEN;


    private List<Directions> directions;

    ChessPieceType() {
        directions = new LinkedList<Directions>();
        addDirections();
    }

    private void addDirections() {
        switch (this) {
            case BISHOP:
                directions.add(Directions.DOWNLEFT);
                directions.add(Directions.DOWNRIGHT);
                directions.add(Directions.UPLEFT);
                directions.add(Directions.UPRIGHT);
                break;
            case KING:
                directions.addAll(Directions.getList());
                break;
            case ROOK:
                directions.add(Directions.UP);
                directions.add(Directions.DOWN);
                directions.add(Directions.RIGHT);
                directions.add(Directions.LEFT);
                break;
            case QUEEN:
                directions.addAll(Directions.getList());
                break;
            default:
                System.out.println("should never enter here");
                break;
        }
    }
}
