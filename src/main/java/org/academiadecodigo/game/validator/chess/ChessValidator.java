package org.academiadecodigo.game.validator.chess;

import org.academiadecodigo.game.player.Player;
import org.academiadecodigo.game.player.chess.ChessPlayer;
import org.academiadecodigo.game.ChessGame;
import org.academiadecodigo.game.board.GameBoard;
import org.academiadecodigo.game.piece.Piece;
import org.academiadecodigo.game.piece.chess.ChessPiece;
import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.chess.ChessMove;
import org.academiadecodigo.game.utils.chess.ChessPieceType;
import org.academiadecodigo.game.utils.chess.Direction;
import org.academiadecodigo.game.validator.MoveValidator;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;


/**
 * Created by tekman on 24/12/2016.
 */
public class ChessValidator implements MoveValidator<ChessPlayer, ChessGame, ChessMove> {

    private ChessGame chessGame;

    @Override
    public boolean isMoveValid(ChessMove move, ChessPlayer player) {
        return chessGame.getPlayerMoves(player).contains(move) && checkIfKingIsNotEndangered(move, player);
    }

    private boolean checkIfKingIsNotEndangered(ChessMove move, ChessPlayer player) {

        ChessPiece playerKing = player.getKing();
        boolean toReturn = false;

        if (playerKing.isInDanger()) {
            toReturn = checkIfMoveProtects(move, player);
        } else {
            toReturn = checkIfMoveCompromises(move, player);
        }

        return toReturn;
    }


    // TODO: 30/12/2016
    private boolean checkIfMoveCompromises(ChessMove move, Player player) {
        throw new NotImplementedException();
    }

    // TODO: 30/12/2016
    private boolean checkIfMoveProtects(ChessMove move, ChessPlayer player) {
        List<ChessPiece> threats = player.getKing().getThreats();
        Position kingPos = player.getKing().getPos();

        for (ChessPiece p : threats) {

        }

        /*
            Logic of this method:

            1 - Check if the move will block all the routes to the check
            2 -
         */

        throw new NotImplementedException();

    }


    @Override
    public void beginGame(GameBoard board, ChessPlayer player) {

        for (ChessPiece p : player.getPieces()) {

            if (p.getType().equals(ChessPieceType.PAWN) || p.getType().equals(ChessPieceType.KNIGHT)) {
                evaluateSpecialPiece(p, board, player);
            }

            evaluatePiece(p, board, player);

        }


    }

    // TODO: 30/12/2016 make the verification in one place only and act accordingly
    private void evaluateSpecialPiece(ChessPiece p, GameBoard board, ChessPlayer player) {
        if (p.getType().equals(ChessPieceType.PAWN)) {
            evaluatePawn(p, board, player);
        } else {
            evaluateKnight(p, board, player);
        }
    }

    private void evaluateKnight(ChessPiece knight, GameBoard board, ChessPlayer player) {
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

                chessGame.addPlayerMove(player, new ChessMove(knight, temp));


            }


        }


    }

    private void evaluatePawn(ChessPiece p, GameBoard board, ChessPlayer player) {
        int col = p.getCol();
        int row = p.getRow();

        for (int i = 1; i <= p.getMaxDistance(); i++) {
            Position pos = board.getPos(col, row + (p.getColor().getModifier() * i));
            Direction direction = Direction.getDirection(col, p.getColor().getModifier());

            if (pos.getPiece() == null) {
                chessGame.addPlayerMove(player, new ChessMove(p, pos, direction));
            }

            Position first = board.getPos(col + 1, row + p.getColor().getModifier());
            Position second = board.getPos(col - 1, row + p.getColor().getModifier());


            //not sure if this works
            if (first != null && first.getPiece() != null && first.getPiece().getColor() != p.getColor()) {
                chessGame.addPlayerMove(player, new ChessMove(p, first, Direction.getDirection(1, p.getColor().getModifier())));
            }

            //not sure if this works...
            if (second != null && second.getPiece() != null && second.getPiece().getColor() != p.getColor()) {
                chessGame.addPlayerMove(player, new ChessMove(p, first, Direction.getDirection(-1, p.getColor().getModifier())));
            }


        }
    }

    private void evaluatePiece(ChessPiece p, GameBoard board, ChessPlayer player) {
        for (Direction d : p.getDirections()) {
            evaluateDirection(p, board, d, player);
        }
    }

    private void evaluateDirection(Piece p, GameBoard board, Direction d, ChessPlayer player) {
        int col = p.getCol();
        int row = p.getRow();

        for (int i = 1; i <= p.getMaxDistance(); i++) {
            Position temp = board.getPos(col + d.moves[0] * i, row + d.moves[1] * i);

            if (temp == null) {
                break;
            }


            if (temp.getPiece() == null || (temp.getPiece().getColor() != p.getColor())) {
                chessGame.addPlayerMove(player, new ChessMove(p, temp, d));
                break;
            }

        }
    }


    @Override
    public void setChessGame(ChessGame chessGame) {
        this.chessGame = chessGame;
    }


    // TODO: 30/12/2016 finish this method
    @Override
    public void recalculatePlayerMoves(ChessPlayer player, ChessMove move, Position previousPos) {
        throw new NotImplementedException();
    }
}
