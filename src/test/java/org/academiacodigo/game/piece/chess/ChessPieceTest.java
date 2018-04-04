package org.academiacodigo.game.piece.chess;

import org.academiadecodigo.game.piece.chess.ChessPiece;
import org.academiadecodigo.game.position.Position;
import org.academiadecodigo.game.utils.PieceColorType;
import org.academiadecodigo.game.utils.PieceType;
import org.academiadecodigo.game.utils.chess.ChessPieceType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tekman on 20/04/2017.
 */
public class ChessPieceTest {

    private Map<PieceType, ChessPiece> pieces;

    @Before
    public void setup() {
        pieces = new HashMap<>();
        pieces.put(ChessPieceType.BISHOP,  new ChessPiece(Mockito.mock(Position.class), PieceColorType.BLACK, ChessPieceType.BISHOP));
        pieces.put(ChessPieceType.PAWN,  new ChessPiece(Mockito.mock(Position.class), PieceColorType.BLACK, ChessPieceType.PAWN));
        pieces.put(ChessPieceType.QUEEN,  new ChessPiece(Mockito.mock(Position.class), PieceColorType.BLACK, ChessPieceType.QUEEN));
        pieces.put(ChessPieceType.KING,  new ChessPiece(Mockito.mock(Position.class), PieceColorType.BLACK, ChessPieceType.KING));
        pieces.put(ChessPieceType.KNIGHT,  new ChessPiece(Mockito.mock(Position.class), PieceColorType.BLACK, ChessPieceType.KNIGHT));
    }

    @Test
    public void moveRook() {

        Position pos = Mockito.mock(Position.class);
        pieces.put(ChessPieceType.ROOK,  new ChessPiece(pos, PieceColorType.BLACK, ChessPieceType.ROOK));
        Mockito.when(pos.getPiece()).thenReturn(pieces.get(ChessPieceType.ROOK));

    }


}
