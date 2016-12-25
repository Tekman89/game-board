package org.academiadecodigo.client;

import org.academiadecodigo.game.Game;
import org.academiadecodigo.game.piece.Piece;
import org.academiadecodigo.game.piece.chess.King;
import org.academiadecodigo.game.utils.Move;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * Created by tekman on 24/12/2016.
 */
public abstract class Player {

    private Game game;

    private List<Piece> pieces;

    private King king;

    public Player() {

    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Move playRound() {

        throw new NotImplementedException();
    }

    public boolean hasLost() {
        throw new NotImplementedException();
    }

    public List<Piece> getPieces() {
        return pieces;
    }
}
