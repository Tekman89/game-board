package org.academiadecodigo.game.utils.chess;

/**
 * Created by tekman on 24/12/2016.
 */
public enum PieceColorType {

    WHITE(1),
    BLACK(-1);

    private int modifier;

    PieceColorType(int modifier) {
        this.modifier = modifier;
    }

    public int getModifier() {
        return modifier;
    }
}
