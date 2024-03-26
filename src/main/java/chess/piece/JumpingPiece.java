package chess.piece;

import chess.Color;
import chess.Movement;
import chess.Position;

import java.util.Set;

public sealed abstract class JumpingPiece
        extends Piece
        permits King, Knight {
    JumpingPiece(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    protected Set<Position> legalMovePositions(final Movement movement, final Pieces pieces) {
        final var moved = position().move(movement);
        if (pieces.nonMatchColor(moved, color())) {
            return Set.of(moved);
        }
        return Set.of();
    }

    protected abstract Set<Movement> movements();
}
