package org.academiadecodigo.game.player;

import org.academiadecodigo.game.ChessGame;
import org.academiadecodigo.game.piece.Piece;
import org.academiadecodigo.game.utils.Move;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * Created by tekman on 24/12/2016.
 */
public abstract class Player<T extends Piece> {

    private ChessGame chessGame;

    private List<T> pieces;

    public Player() {

    }

    public void setChessGame(ChessGame chessGame) {
        this.chessGame = chessGame;
    }

    public Move playRound() {

        throw new NotImplementedException();
    }

    public boolean hasLost() {
        throw new NotImplementedException();
    }

    public List<T> getPieces() {
        return pieces;
    }

}
