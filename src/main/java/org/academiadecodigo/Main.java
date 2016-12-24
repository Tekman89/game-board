package org.academiadecodigo;

import org.academiadecodigo.client.Player;
import org.academiadecodigo.client.chess.ChessPlayer;
import org.academiadecodigo.game.Game;
import org.academiadecodigo.game.board.chess.ChessGameBoard;
import org.academiadecodigo.game.mover.chess.ChessMover;
import org.academiadecodigo.game.validator.chess.ChessValidator;

/**
 * Created by tekman on 24/12/2016.
 */
public class Main {

    public static void main(String[] args) {


        Player p1 = new ChessPlayer();
        Player p2 = new ChessPlayer();


        Game game = new Game.GameBuilderImpl()
                .addPlayer(p1)
                .addPlayer(p2)
                .setGameBoard(new ChessGameBoard())
                .setValidator(new ChessValidator())
                .setMover(new ChessMover())
                .build();


        game.start();
    }
}
