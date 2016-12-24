package org.academiadecodigo.game.mover.chess;

import org.academiadecodigo.game.Piece;
import org.academiadecodigo.game.Position;
import org.academiadecodigo.game.mover.Mover;
import org.academiadecodigo.game.utils.Move;

/**
 * Created by tekman on 24/12/2016.
 */
public class ChessMover implements Mover {

    public void commitMove(Move move) {

        if (move.getPosition().getPiece() != null) {
            eatPiece(move);
        } else {
            moveNormal();
        }


        Position previousPos = move.getPiece().getPos();
        move.getPiece().setPos(move.getPosition());
        previousPos.setPiece(null);
        move.getPosition().setPiece(move.getPiece());
    }

    private void moveNormal() {
        
    }

    private void eatPiece(Move move) {

        Piece piece = move.getPiece();
        Position position = move.getPosition();

        Piece pieceToGetEaten = position.getPiece();
        //eat the piece
        pieceToGetEaten.setEaten(true);

        //move the piece to the target Position
        piece.move(position);

        position.setPiece(null);
    }

}
