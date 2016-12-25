package org.academiadecodigo.game.validator.chess;

import org.academiadecodigo.client.Player;
import org.academiadecodigo.game.Game;
import org.academiadecodigo.game.board.GameBoard;
import org.academiadecodigo.game.piece.Piece;
import org.academiadecodigo.game.piece.chess.Knight;
import org.academiadecodigo.game.piece.chess.Pawn;
import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.Move;
import org.academiadecodigo.game.utils.chess.ChessMove;
import org.academiadecodigo.game.utils.chess.Directions;
import org.academiadecodigo.game.validator.MoveValidator;


/**
 * Created by tekman on 24/12/2016.
 */
public class ChessValidator implements MoveValidator {


    private Game game;

    public boolean isMoveValid(Move move, Player player) {
        return game.getPlayerMoves(player).contains(move);
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void beginGame(GameBoard board, Player player) {

        for (Piece p : player.getPieces()) {

            if (p instanceof Pawn || p instanceof Knight) {
                evaluateSpecialPiece(p, board, player);
            }

            evaluatePiece(p, board, player);

        }


    }

    private void evaluateSpecialPiece(Piece p, GameBoard board, Player player) {
        if (p instanceof Pawn) {
            evaluatePawn((Pawn) p, board, player);
        } else {
            evaluateKnight((Knight) p, board, player);
        }
    }

    private void evaluateKnight(Knight knight, GameBoard board, Player player) {
        int col = knight.getCol();
        int row = knight.getRow();

        int[][] possibleOffSets = {
                {-2, 1},
                {2, 1},
                {2, -1},
                {-2, -1},
                {1, 2},
                {1, -2},
                {-1, -2},
                {-1, 2}
        };


        for (int[] o : possibleOffSets) {
            Position temp = board.getPos(col + o[0], row + o[1]);

           /* temp null break
            if the position has a piece it need's to be of different color
            or the position cannot have a piece */
            if (temp != null &&
                    ((temp.getPiece() != null && temp.getPiece().getColor() != knight.getColor()) ||
                            temp.getPiece() == null)) {

                game.addPlayerMove(player, new ChessMove(knight, temp));
            }


        }


    }

    private void evaluatePawn(Pawn p, GameBoard board, Player player) {
        int col = p.getCol();
        int row = p.getRow();

        for (int i = 1; i <= p.getMaxDistance(); i++) {
            Position pos = board.getPos(col, row + (p.getColor().getModifier() * i));

            if (pos.getPiece() == null) {
                game.addPlayerMove(player, new ChessMove(p, pos));
            }

            Position first = board.getPos(col + 1, row + p.getColor().getModifier());
            Position second = board.getPos(col - 1, row + p.getColor().getModifier());

            if (first != null && first.getPiece() != null && first.getPiece().getColor() != p.getColor()) {
                game.addPlayerMove(player, new ChessMove(p, first));
            }

            if (second != null && second.getPiece() != null && second.getPiece().getColor() != p.getColor()) {
                game.addPlayerMove(player, new ChessMove(p, first));
            }


        }
    }

    private void evaluatePiece(Piece p, GameBoard board, Player player) {
        for (Directions d : p.getDirections()) {
            evaluateDirection(p, board, d, player);
        }
    }

    private void evaluateDirection(Piece p, GameBoard board, Directions d, Player player) {
        int col = p.getCol();
        int row = p.getRow();

        for (int i = 0; i < p.getMaxDistance(); i++) {
            Position temp = board.getPos(col + d.moves[0] * i, row + d.moves[-1] * i);

            if (temp == null) {
                break;
            }


            if (temp.getPiece() == null || (temp.getPiece().getColor() != p.getColor())) {
                game.addPlayerMove(player, new ChessMove(p, temp));
            }

        }
    }
}
