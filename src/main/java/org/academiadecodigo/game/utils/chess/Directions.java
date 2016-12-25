package org.academiadecodigo.game.utils.chess;

/**
 * Created by tekman on 24/12/2016.
 */
public enum Directions {

    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0),
    UPLEFT(-1, -1),
    UPRIGHT(1, -1),
    DOWNRIGHT(1, 1),
    DOWNLEFT(-1, 1);

    public final int[] moves;

    Directions(int x, int y) {
        moves = new int[] {x, y};
    }

}
