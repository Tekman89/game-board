package org.academiadecodigo.game.validator;

import org.academiadecodigo.game.player.Player;
import org.academiadecodigo.game.Game;
import org.academiadecodigo.game.board.GameBoard;
import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.Move;

/**
 * Created by tekman on 24/12/2016.
 */
public interface MoveValidator<T extends Player, E extends Game, K extends Move> {

    boolean isMoveValid(K move, T player);

    void setChessGame(E chessGame);

    void beginGame(GameBoard board, T player);

    void recalculatePlayerMoves(T player, K move, Position previousPos);
}
