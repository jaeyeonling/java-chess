package chess.piece;

import chess.Color;
import chess.Movement;
import chess.Position;

import java.util.Set;

import static chess.Movement.DOWN;
import static chess.Movement.LEFT;
import static chess.Movement.LEFT_DOWN;
import static chess.Movement.LEFT_UP;
import static chess.Movement.RIGHT;
import static chess.Movement.RIGHT_DOWN;
import static chess.Movement.RIGHT_UP;
import static chess.Movement.UP;

public final class Queen extends SlidingPiece {

    public Queen(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    protected Set<Movement> movements() {
        return Set.of(UP, DOWN, LEFT, RIGHT, LEFT_UP, LEFT_DOWN, RIGHT_UP, RIGHT_DOWN);
    }

    @Override
    protected Piece update(final Position destination) {
        return new Queen(color(), destination);
    }
}
