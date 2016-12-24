package org.academiadecodigo.game.utils;


import org.academiadecodigo.game.Piece;
import org.academiadecodigo.game.Position;

/**
 * Created by tekman on 24/12/2016.
 */
public interface Move {

    void setPosition(Position position);

    void setPiece(Piece piece);

    Position getPosition();

    Piece getPiece();

}
