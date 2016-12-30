package org.academiadecodigo.game;

import org.academiadecodigo.client.Player;
import org.academiadecodigo.game.board.GameBoard;
import org.academiadecodigo.game.mover.Mover;
import org.academiadecodigo.game.validator.MoveValidator;

/**
 * Created by tekman on 24/12/2016.
 */
public interface GameBuilder<E extends Player, T extends GameBoard, K extends MoveValidator, J extends Mover> {


    GameBuilder addPlayer(E player);

    GameBuilder setGameBoard(T gameBoard);

    ChessGame build();

    GameBuilder setValidator(K validator);

    GameBuilder setMover(J mover);
}
