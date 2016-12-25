package org.academiadecodigo.game.mover;

import org.academiadecodigo.client.Player;
import org.academiadecodigo.game.Game;
import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.Move;

import java.util.List;
import java.util.Map;

/**
 * Interface for the movement of the pieces in whichever board
 * Created by tekman on 24/12/2016.
 */
public interface Mover {

    Position commitMove(Move move);

    void recalculatePlayerMoves(Player player, Move move, Position previousPos);

    void setGame(Game game);
}
