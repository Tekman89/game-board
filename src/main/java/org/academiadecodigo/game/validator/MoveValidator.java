package org.academiadecodigo.game.validator;

import org.academiadecodigo.client.Player;
import org.academiadecodigo.game.ChessGame;
import org.academiadecodigo.game.Game;
import org.academiadecodigo.game.board.GameBoard;
import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.Move;

/**
 * Created by tekman on 24/12/2016.
 */
public interface MoveValidator <E extends Game, T extends Player> {

    boolean isMoveValid(Move move, T player);

    void setChessGame(E chessGame);

    void beginGame(GameBoard board, T player);

    void recalculatePlayerMoves(T player, Move move, Position previousPos);
}
