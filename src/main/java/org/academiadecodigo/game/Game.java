package org.academiadecodigo.game;

import org.academiadecodigo.client.Player;
import org.academiadecodigo.game.board.GameBoard;
import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.GameBuilder;
import org.academiadecodigo.game.utils.Move;
import org.academiadecodigo.game.validator.MoveValidator;
import org.academiadecodigo.game.mover.Mover;
import sun.plugin.dom.exception.InvalidStateException;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Game container, Built to be modular and only built through his builder, supports only 2 player board games
 * Contains the game flow.
 * <p>
 * Created by tekman on 24/12/2016.
 */
public class Game {

    //they will be received from the server later on.
    /**
     * Players to play the Game, needs 2 all the time
     */
    private List<Player> players;
    /**
     * Where the game will be played, logical gameBoard
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

    private Map<Player, List<Move>> playerMoves;

    private Game() {
        //empty constructor
    }

    /**
     * Method to prepare all dependencies for the start of the game
     */
    private void init() {
        //create MoveValidator
        //create each PlayersSetPieces

        mover.setPlayerMoves(playerMoves);

        //add all dependencies to the players (Game)
        for (Player p : players) {
            p.setGame(this);
        }

    }


    /**
     * Adds a player to the playerList
     *
     * @param player to add
     */
    private void add(Player player) {
        players.add(player);
    }


    /**
     * Game cycle
     */
    public void start() {
        //main game loop


        while (!isGameOver()) {

            for (Player p : players) {

                playRound(p);

            }

        }

        congratulateWinner();

    }

    private void congratulateWinner() {

        Player winner = null;

        for (Player p : players) {
            if (!p.hasLost()) {
                winner = p;
            }
        }
        System.out.println("Winner is: " + winner);
    }

    private boolean isGameOver() {

        for (Player p : players) {
            if (p.hasLost()) {
                return true;
            }
        }

        return false;
    }

    private void playRound(Player player) {

        Move move = null;

        do {

            move = player.playRound();

        } while (!validator.isMoveValid(move));

        Position previousPos = mover.commitMove(move);

        mover.recalculatePlayerMoves(player, move, previousPos);

    }


    /**
     * Start of the inner class, implementation of the builder
     */
    public static class GameBuilderImpl implements GameBuilder {

        private Game game;

        public GameBuilderImpl() {
            game = new Game();
            game.players = new LinkedList<Player>();
            game.playerMoves = new LinkedHashMap<Player, List<Move>>();
        }

        public GameBuilder addPlayer(Player player) {

            if (game.players.size() <= 1) {
                game.add(player);
            }
            return this;
        }

        public GameBuilder setGameBoard(GameBoard gameBoard) {
            game.setGameBoard(gameBoard);
            return this;
        }


        public GameBuilder setMover(Mover mover) {
            game.setMover(mover);
            return this;
        }

        public GameBuilder setValidator(MoveValidator validator) {
            game.setValidator(validator);
            return this;
        }


        /**
         * Method to build the Game, cannot build a game without this method
         *
         * @return the built Game ready to start.
         * @throws InvalidStateException if any of the needed fields is not filled:
         *                               Needs 2 players;
         *                               1 GameBoard;
         *                               1 Validator;
         *                               1 Mover.
         */
        public Game build() {

            if (game.players.size() != 2
                    || game.gameBoard == null
                    || game.validator == null
                    || game.mover == null) {
                throw new InvalidStateException("Invalid state");
            }

            game.init();

            return game;
        }

    }
    // End of the inner class


    /**
     * Setter for the move validator required for the game to function
     *
     * @param validator interface representing the Validator we are going to use to validate our moves
     */
    private void setValidator(MoveValidator validator) {
        this.validator = validator;
    }


    /**
     * Setter for the piece mover, required for the game to function
     *
     * @param mover interface representing the Mover that we are going to use to move our pieces
     */
    private void setMover(Mover mover) {
        this.mover = mover;
    }

    /**
     * Set's the game board where we are going to play
     *
     * @param gameBoard interface representing the Game Board that we are going to play on
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
    private void addPlayerMove(Player player, Move move) {
        playerMoves.get(player).add(move);
    }


}
