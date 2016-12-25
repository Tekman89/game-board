package org.academiadecodigo.game.piece;

import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.Move;
import org.academiadecodigo.game.utils.PieceColorType;
import org.academiadecodigo.game.utils.chess.Directions;

import java.util.List;

/**
 * Created by tekman on 24/12/2016.
 */
public abstract class Piece {

    private Position position;
    private boolean eaten;
    private List<Directions> directions;
    private int maxDistance;
    private PieceColorType color;


    public Piece(Position pos, int maxDistance, PieceColorType color) {
        this.position = pos;
        this.maxDistance = maxDistance;
        this.color = color;
        eaten = false;
    }

    public Position getPos() {
        return position;
    }

    public void setPos(Position pos) {
        this.position = pos;
    }

    public void setEaten(boolean eaten) {
        this.eaten = eaten;
    }

    public boolean getEaten() {
        return eaten;
    }


    //needs to be overwritten
    public abstract void move(Position position);

    public void setDirections(List<Directions> directions) {
        this.directions = directions;
    }

    public List<Directions> getDirections() {
        return directions;
    }

    public int getRow() {
        return position.getRow();
    }

    public int getCol() {
        return position.getCol();
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public PieceColorType getColor() {
        return color;
    }

}
