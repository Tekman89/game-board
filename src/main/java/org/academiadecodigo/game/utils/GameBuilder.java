package org.academiadecodigo.game.utils;

import org.academiadecodigo.client.Player;
import org.academiadecodigo.game.Game;
import org.academiadecodigo.game.board.GameBoard;
import org.academiadecodigo.game.mover.Mover;
import org.academiadecodigo.game.validator.MoveValidator;

/**
 * Created by tekman on 24/12/2016.
 */
public interface GameBuilder {

    GameBuilder addPlayer(Player player);

    GameBuilder setGameBoard(GameBoard gameBoard);

    Game build();

    GameBuilder setValidator(MoveValidator validator);

    GameBuilder setMover(Mover mover);
}
