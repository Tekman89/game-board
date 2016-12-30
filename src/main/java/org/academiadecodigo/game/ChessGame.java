package org.academiadecodigo.game;

import org.academiadecodigo.game.player.chess.ChessPlayer;
import org.academiadecodigo.game.board.GameBoard;
import org.academiadecodigo.game.board.chess.ChessGameBoard;
import org.academiadecodigo.game.mover.chess.ChessMover;
import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.Move;
import org.academiadecodigo.game.validator.MoveValidator;
import org.academiadecodigo.game.mover.Mover;
import org.academiadecodigo.game.validator.chess.ChessValidator;
import sun.plugin.dom.exception.InvalidStateException;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * ChessGame container, Built to be modular and only built through his builder, supports only 2 player board games
 * Contains the chessGame flow.
 * <p>
 * Created by tekman on 24/12/2016.
 */
public class ChessGame extends Game {

    //they will be received from the server later on.
    /**
     * Players to play the ChessGame, needs 2 all the time
     */
    private List<ChessPlayer> players;
    /**
     * Where the chessGame will be played, logical gameBoard
     */
    private GameBoard gameBoard;

    /**
     * Object to validate every player move
     */
    private MoveValidator validator;

    /**
     * Object to commit every player move
     */
    private Mover mover;

    /**
     * Map containing all moves the players can make
     */
    private Map<ChessPlayer, List<Move>> playerMoves;

    private ChessGame() {
        //empty constructor
    }

    /**
     * Method to prepare all dependencies for the start of the chessGame
     */
    private void init() {
        //create MoveValidator
        //create each PlayersSetPieces

        mover.setChessGame(this);
        validator.setChessGame(this);

        //add all dependencies to the players (ChessGame)
        for (ChessPlayer p : players) {
            p.setChessGame(this);
            validator.beginGame(gameBoard, p);
        }


    }


    /**
     * Adds a player to the playerList
     *
     * @param player to add
     */
    private void add(ChessPlayer player) {
        players.add(player);
    }


    /**
     * ChessGame cycle
     */
    public void start() {
        //main chessGame loop

        while (!isGameOver()) {

            for (ChessPlayer p : players) {

                playRound(p);

            }

        }

        congratulateWinner();

    }

    private void congratulateWinner() {

        ChessPlayer winner = null;

        for (ChessPlayer p : players) {
            if (!p.hasLost()) {
                winner = p;
            }
        }
        System.out.println("Winner is: " + winner);
    }

    private boolean isGameOver() {

        for (ChessPlayer p : players) {
            if (p.hasLost()) {
                return true;
            }
        }

        return false;
    }

    private void playRound(ChessPlayer player) {

        Move move = null;

        do {

            move = player.playRound();

        } while (!validator.isMoveValid(move, player));

        Position previousPos = mover.commitMove(move);

        // TODO: 25/12/2016 See if it's the mover that makes sense to do this and implement it.
        validator.recalculatePlayerMoves(player, move, previousPos);

    }


    /**
     * Start of the inner class, implementation of the builder
     */
    public static class GameBuilderImpl implements GameBuilder<ChessPlayer, ChessGameBoard, ChessValidator, ChessMover> {

        private ChessGame chessGame;

        public GameBuilderImpl() {
            chessGame = new ChessGame();
            chessGame.players = new LinkedList<ChessPlayer>();
            chessGame.playerMoves = new LinkedHashMap<ChessPlayer, List<Move>>();
        }

        public GameBuilder addPlayer(ChessPlayer player) {

            if (chessGame.players.size() <= 1) {
                chessGame.add(player);
            }
            return this;
        }

        public GameBuilder setGameBoard(ChessGameBoard gameBoard) {
            chessGame.setGameBoard(gameBoard);
            return this;
        }


        public GameBuilder setMover(ChessMover mover) {
            chessGame.setMover(mover);
            return this;
        }

        public GameBuilder setValidator(ChessValidator validator) {
            chessGame.setValidator(validator);
            return this;
        }


        /**
         * Method to build the ChessGame, cannot build a chessGame without this method
         *
         * @return the built ChessGame ready to start.
         * @throws InvalidStateException if any of the needed fields is not filled:
         *                               Needs 2 players;
         *                               1 GameBoard;
         *                               1 Validator;
         *                               1 Mover.
         */
        public ChessGame build() {

            if (chessGame.players.size() != 2
                    || chessGame.gameBoard == null
                    || chessGame.validator == null
                    || chessGame.mover == null) {
                throw new InvalidStateException("Invalid state");
            }

            chessGame.init();

            return chessGame;
        }

    }
    // End of the inner class


    /**
     * Setter for the move validator required for the chessGame to function
     *
     * @param validator interface representing the Validator we are going to use to validate our moves
     */
    private void setValidator(MoveValidator validator) {
        this.validator = validator;
    }


    /**
     * Setter for the piece mover, required for the chessGame to function
     *
     * @param mover interface representing the Mover that we are going to use to move our pieces
     */
    private void setMover(Mover mover) {
        this.mover = mover;
    }

    /**
     * Set's the chessGame board where we are going to play
     *
     * @param gameBoard interface representing the ChessGame Board that we are going to play on
     */
    private void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }


    /**
     * Method to add all player moves to a Map of Players, List<Moves>
     *
     * @param player to which the moves belongs to
     * @param move   to add to the list
     */
    public void addPlayerMove(ChessPlayer player, Move move) {
        playerMoves.get(player).add(move);
    }

    public List<Move> getPlayerMoves(ChessPlayer player) {
        return playerMoves.get(player);
    }


}
