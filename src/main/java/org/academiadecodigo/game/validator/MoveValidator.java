package org.academiadecodigo.game.validator;

import org.academiadecodigo.client.Player;
import org.academiadecodigo.game.Game;
import org.academiadecodigo.game.board.GameBoard;
import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.Move;

/**
 * Created by tekman on 24/12/2016.
 */
public interface MoveValidator {

    boolean isMoveValid(Move move, Player player);

    void setGame(Game game);

    void beginGame(GameBoard board, Player player);

    void recalculatePlayerMoves(Player player, Move move, Position previousPos);
}
