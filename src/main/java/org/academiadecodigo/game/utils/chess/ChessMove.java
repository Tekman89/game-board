package org.academiadecodigo.game.utils.chess;

import org.academiadecodigo.client.Player;
import org.academiadecodigo.game.piece.Piece;
import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.Move;

import java.util.LinkedList;

/**
 * Created by tekman on 25/12/2016.
 */
public class ChessMove extends Move {
    public ChessMove(Piece p, Position pos) {
        super(p, pos);
    }
}
