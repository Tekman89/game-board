package org.academiadecodigo.game.utils.chess;

import org.academiadecodigo.game.utils.PieceType;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tekman on 30/12/2016.
 */
public enum ChessPieceType implements PieceType {

    ROOK(8),
    KNIGHT(0),
    BISHOP(8),
    KING(1),
    PAWN(0),
    QUEEN(8);

    public final int range;
    private List<Directions> directions;

    ChessPieceType(int range) {
        this.range = range;
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


    public List<Directions> getDirections() {
        return directions;
    }
}
