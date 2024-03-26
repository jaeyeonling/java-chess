package chess.piece;

import chess.Color;
import chess.Movement;
import chess.Position;

import java.util.HashSet;
import java.util.Set;

public sealed abstract class SlidingPiece
        extends Piece
        permits Bishop, Rook, Queen {
    SlidingPiece(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    protected Set<Position> legalMovePositions(final Movement movement, final Pieces pieces) {
        final var legalMoveLeftUpPositions = new HashSet<Position>();
        var current = position();
        while (current.canMove(movement)) {
            current = current.move(movement);
            if (pieces.matchColor(current, color())) {
                break;
            }

            legalMoveLeftUpPositions.add(current);

            if (pieces.matchColor(current, oppositeColor())) {
                break;
            }
        }

        return legalMoveLeftUpPositions;
    }
}
