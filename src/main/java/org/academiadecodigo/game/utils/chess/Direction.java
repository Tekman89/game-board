package org.academiadecodigo.game.utils.chess;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tekman on 24/12/2016.
 */
public enum Direction {

    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0),
    UPLEFT(-1, -1),
    UPRIGHT(1, -1),
    DOWNRIGHT(1, 1),
    DOWNLEFT(-1, 1);

    public final int[] moves;

    Direction(int x, int y) {
        moves = new int[]{x, y};
    }

    public static List<Direction> getList() {
        List<Direction> directionList = new LinkedList<>();
        Collections.addAll(directionList, Direction.values());

        return directionList;
    }

    public static Direction getDirection(int x, int y) {
        Direction direction = null;

        for (Direction d : values()) {
            if (d.moves[0] == x && d.moves[1] == y) {
                direction = d;
                break;
            }
        }

        if (direction == null) {
            System.out.println("Something went really wrong in here...");
        }

        return direction;
    }
}
