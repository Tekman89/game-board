package org.academiadecodigo.game.mover.chess;

import org.academiadecodigo.game.Position;
import org.academiadecodigo.game.mover.Mover;
import org.academiadecodigo.game.utils.Move;

/**
 * Created by tekman on 24/12/2016.
 */
public class ChessMover implements Mover {

    public void commitMove(Move move) {
        Position previousPos = move.getPiece().getPos();
        move.getPiece().setPos(move.getPosition());
        previousPos.setPiece(null);
        move.getPosition().setPiece(move.getPiece());
    }

}
