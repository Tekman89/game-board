package org.academiadecodigo.game.utils.chess;

import java.util.LinkedList;
import java.util.List;

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

    public static List<Directions> getList() {
        List<Directions> directionsList = new LinkedList<Directions>();
        for (int i = 0; i < Directions.values().length; i++) {
            directionsList.add(Directions.values()[i]);
        }
        return directionsList;
    }
}
