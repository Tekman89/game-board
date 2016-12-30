package org.academiadecodigo.client.chess;

import org.academiadecodigo.client.Player;
import org.academiadecodigo.game.piece.Piece;
import org.academiadecodigo.game.piece.chess.ChessPiece;
import org.academiadecodigo.game.utils.chess.ChessPieceType;

/**
 * Created by tekman on 24/12/2016.
 */
public class ChessPlayer extends Player<ChessPiece> {



    public ChessPiece getKing() {

        ChessPiece piece = null;

        for (Piece c: getPieces()) {
            if(c.getType().equals(ChessPieceType.KING)) {
                piece = (ChessPiece) c;
            }
        }

        return piece;

    }
}
