package org.academiadecodigo.game.board;

import org.academiadecodigo.game.position.Position;

/**
 * Created by tekman on 24/12/2016.
 */
public interface GameBoard {
    Position getPos(int col, int row);
}
