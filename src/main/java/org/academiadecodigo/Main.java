package org.academiadecodigo;

import org.academiadecodigo.game.player.chess.ChessPlayer;
import org.academiadecodigo.game.ChessGame;
import org.academiadecodigo.game.board.chess.ChessGameBoard;
import org.academiadecodigo.game.mover.chess.ChessMover;
import org.academiadecodigo.game.validator.chess.ChessValidator;

/**
 * Created by tekman on 24/12/2016.
 */
public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {


        ChessPlayer p1 = new ChessPlayer();
        ChessPlayer p2 = new ChessPlayer();


        ChessGame chessGame = new ChessGame.GameBuilderImpl()
                .addPlayer(p1)
                .addPlayer(p2)
                .setGameBoard(new ChessGameBoard())
                .setValidator(new ChessValidator())
                .setMover(new ChessMover())
                .build();


        chessGame.start();
    }
}
