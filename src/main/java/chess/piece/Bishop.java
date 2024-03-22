package chess.piece;

import chess.Color;
import chess.Position;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Bishop extends Piece {

    public Bishop(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    public Set<Position> legalMovePositions(final Pieces pieces) {
        final var legalMoveLeftUpPositions = legalMoveLeftUpPositions(pieces);
        final var legalMoveRightUpPositions = legalMoveRightUpPositions(pieces);
        final var legalMoveLeftDownPositions = legalMoveLeftDownPositions(pieces);
        final var legalMoveRightDownPositions = legalMoveRightDownPositions(pieces);

        return Stream.of(legalMoveLeftUpPositions, legalMoveRightUpPositions, legalMoveLeftDownPositions, legalMoveRightDownPositions)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    private Set<Position> legalMoveLeftUpPositions(final Pieces pieces) {
        final var legalMoveLeftUpPositions = new HashSet<Position>();
        var current = position();
        while (current.canMoveLeftUp()) {
            current = current.moveLeftUp();
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

    private Set<Position> legalMoveRightUpPositions(final Pieces pieces) {
        final var legalMoveRightUpPositions = new HashSet<Position>();
        var current = position();
        while (current.canMoveRightUp()) {
            current = current.moveRightUp();
            if (pieces.matchColor(current, color())) {
                break;
            }

            legalMoveRightUpPositions.add(current);

            if (pieces.matchColor(current, oppositeColor())) {
                break;
            }
        }

        return legalMoveRightUpPositions;
    }

    private Set<Position> legalMoveLeftDownPositions(final Pieces pieces) {
        final var legalMoveLeftDownPositions = new HashSet<Position>();
        var current = position();
        while (current.canMoveLeftDown()) {
            current = current.moveLeftDown();
            if (pieces.matchColor(current, color())) {
                break;
            }

            legalMoveLeftDownPositions.add(current);

            if (pieces.matchColor(current, oppositeColor())) {
                break;
            }
        }

        return legalMoveLeftDownPositions;
    }

    private Set<Position> legalMoveRightDownPositions(final Pieces pieces) {
        final var legalMoveRightDownPositions = new HashSet<Position>();
        var current = position();
        while (current.canMoveRightDown()) {
            current = current.moveRightDown();
            if (pieces.matchColor(current, color())) {
                break;
            }

            legalMoveRightDownPositions.add(current);

            if (pieces.matchColor(current, oppositeColor())) {
                break;
            }
        }

        return legalMoveRightDownPositions;
    }

    @Override
    protected Piece update(final Position destination) {
        return new Bishop(color(), destination);
    }
}
