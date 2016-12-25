package org.academiadecodigo.game.mover.chess;

import org.academiadecodigo.client.Player;
import org.academiadecodigo.game.Game;
import org.academiadecodigo.game.piece.Piece;
import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.mover.Mover;
import org.academiadecodigo.game.utils.Move;

import java.util.List;

/**
 * Class responsible for moving pieces in the ChessBoard
 * Created by tekman on 24/12/2016.
 */
public class ChessMover implements Mover {

    private Game game;

    /**
     * Method to commit Moves made by the player
     * will call different methods depending on whether there is a piece on the target position
     * @param move Interface that abstracts the position and the piece to be moved
     * @return the previous position occupied by the piece
     */
    public Position commitMove(Move move) {

        Position previousPos = move.getPiece().getPos();

        if (move.getPosition().getPiece() != null) {
            eatPiece(move);
        } else {
            moveNormal(move);
        }

        return previousPos;
    }

    /**
     * Move called when there is no piece in the target position,
     * will move the piece and reset the previous position to not have a piece
     * @param move Interface that abstracts the position and the piece to be moved
     */
    private void moveNormal(Move move) {

        Piece piece = move.getPiece();
        Position position = move.getPosition();
        Position previousPosition = piece.getPos();

        previousPosition.removePiece();

        piece.move(position);
        position.setPiece(piece);
    }

    /**
     * Move called when there is a piece on the target position,
     * will set said piece to the eaten state and call moveNormal() to finish the move
     * @param move Interface that abstracts the position and the piece to be moved
     */
    private void eatPiece(Move move) {

        Position position = move.getPosition();
        Piece pieceToGetEaten = position.getPiece();

        //eat the piece
        pieceToGetEaten.setEaten(true);
        pieceToGetEaten.setPos(null);

        moveNormal(move);
    }


    /**
     * See @mover
     * @param player player to add into
     * @param move the move made
     * @param previousPos the previous piece position
     */
    public void recalculatePlayerMoves(Player player, Move move, Position previousPos) {

        List<Move> previousMoves = game.getPlayerMoves(player);
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
