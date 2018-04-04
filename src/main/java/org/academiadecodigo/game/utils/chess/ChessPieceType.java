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
    private List<Direction> directions;

    ChessPieceType(int range) {
        this.range = range;
        directions = new LinkedList<>();
        addDirections();
    }

    private void addDirections() {
        System.out.println(this);
        switch (this) {
            case BISHOP:
                directions.add(Direction.DOWNLEFT);
                directions.add(Direction.DOWNRIGHT);
                directions.add(Direction.UPLEFT);
                directions.add(Direction.UPRIGHT);
                break;
            case KING:
                directions.addAll(Direction.getList());
                break;
            case ROOK:
                directions.add(Direction.UP);
                directions.add(Direction.DOWN);
                directions.add(Direction.RIGHT);
                directions.add(Direction.LEFT);
                break;
            case QUEEN:
                directions.addAll(Direction.getList());
                break;
            default:
                System.out.println("should never enter here");
                break;
        }
    }


    public List<Direction> getDirections() {
        return directions;
    }


    public int getRange() {
        return range;
    }
}
