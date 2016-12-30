package org.academiadecodigo.game.mover;

import org.academiadecodigo.client.Player;
import org.academiadecodigo.game.Game;
import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.Move;

/**
 * Interface for the movement of the pieces in whichever board
 * Created by tekman on 24/12/2016.
 */
public interface Mover<E extends Player, T extends Game> {

    Position commitMove(Move move);

    void setChessGame(T chessGame);
}
