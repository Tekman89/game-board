package org.academiadecodigo.client;

import org.academiadecodigo.game.Game;
import org.academiadecodigo.game.utils.Move;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by tekman on 24/12/2016.
 */
public abstract class Player {

    private Game game;

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
}
