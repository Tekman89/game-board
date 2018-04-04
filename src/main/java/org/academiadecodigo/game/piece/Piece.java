package org.academiadecodigo.game.piece;

import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.PieceColorType;
import org.academiadecodigo.game.utils.PieceType;
import org.academiadecodigo.game.utils.chess.Direction;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tekman on 24/12/2016.
 */
public abstract class Piece<P extends Piece> {

    private Position position;
    private boolean eaten;
    private List<Direction> directions;
    private int maxDistance;
    private PieceColorType color;


    private List<P> whoThreatens;


    public Piece(Position pos, int maxDistance, PieceColorType color) {
        this.position = pos;
        this.maxDistance = maxDistance;
        this.color = color;
        eaten = false;
        whoThreatens = new LinkedList<>();
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

    public abstract PieceType getType();

    protected void setDirections(List<Direction> directions) {
        this.directions = directions;
    }

    public List<Direction> getDirections() {
        return Collections.unmodifiableList(directions);
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

    public void addThreat(P piece) {
        whoThreatens.add(piece);
    }

    public List<P> getThreats() {
        return Collections.unmodifiableList(whoThreatens);
    }
}
