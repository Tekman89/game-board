package org.academiadecodigo.game.mover.chess;

import org.academiadecodigo.game.player.chess.ChessPlayer;
import org.academiadecodigo.game.ChessGame;
import org.academiadecodigo.game.piece.Piece;
import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.mover.Mover;
import org.academiadecodigo.game.utils.Move;

/**
 * Class responsible for moving pieces in the ChessBoard
 * Created by tekman on 24/12/2016.
 */
public class ChessMover implements Mover<ChessPlayer, ChessGame> {

    private ChessGame chessGame;

    /**
     * Method to commit Moves made by the player
     * will call different methods depending on whether there is a piece on the target position
     *
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
     *
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
     *
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

    public void setChessGame(ChessGame chessGame) {
        this.chessGame = chessGame;
    }
}
