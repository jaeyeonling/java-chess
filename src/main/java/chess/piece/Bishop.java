package chess.piece;

import chess.Color;
import chess.Movement;
import chess.Position;

import java.util.Set;

import static chess.Movement.LEFT_DOWN;
import static chess.Movement.LEFT_UP;
import static chess.Movement.RIGHT_DOWN;
import static chess.Movement.RIGHT_UP;

public final class Bishop extends SlidingPiece {

    public Bishop(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    protected Set<Movement> movements() {
        return Set.of(LEFT_UP, LEFT_DOWN, RIGHT_UP, RIGHT_DOWN);
    }

    @Override
    protected Piece update(final Position destination) {
        return new Bishop(color(), destination);
    }
}
