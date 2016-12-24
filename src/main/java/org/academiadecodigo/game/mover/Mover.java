package org.academiadecodigo.game.mover;

import org.academiadecodigo.game.utils.Move;

/**
 * Interface for the movement of the pieces in whichever board
 * Created by tekman on 24/12/2016.
 */
public interface Mover {

    void commitMove(Move move);

}
