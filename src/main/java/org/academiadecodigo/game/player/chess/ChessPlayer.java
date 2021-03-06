package org.academiadecodigo.game.player.chess;

import org.academiadecodigo.game.player.Player;
import org.academiadecodigo.game.piece.Piece;
import org.academiadecodigo.game.piece.chess.ChessPiece;
import org.academiadecodigo.game.utils.chess.ChessMove;
import org.academiadecodigo.game.utils.chess.ChessPieceType;

/**
 * Created by tekman on 24/12/2016.
 */
public class ChessPlayer extends Player<ChessPiece, ChessMove> {


    public ChessPiece getKing() {

        ChessPiece piece = null;

        for (Piece c : getPieces()) {
            if (c.getType().equals(ChessPieceType.KING)) {
                piece = (ChessPiece) c;
            }
        }

        return piece;

    }
}
