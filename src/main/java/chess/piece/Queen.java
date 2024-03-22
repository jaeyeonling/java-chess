package chess.piece;

import chess.Color;
import chess.Position;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Queen extends Piece {

    public Queen(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    public Set<Position> legalMovePositions(final Pieces pieces) {
        final var legalMoveLeftUpPositions = legalMoveLeftUpPositions(pieces);
        final var legalMoveRightUpPositions = legalMoveRightUpPositions(pieces);
        final var legalMoveLeftDownPositions = legalMoveLeftDownPositions(pieces);
        final var legalMoveRightDownPositions = legalMoveRightDownPositions(pieces);
        final var legalMoveLeftPositions = legalMoveLeftPositions(pieces);
        final var legalMoveRightPositions = legalMoveRightPositions(pieces);
        final var legalMoveUpPositions = legalMoveUpPositions(pieces);
        final var legalMoveDownPositions = legalMoveDownPositions(pieces);

        return Stream.of(legalMoveLeftUpPositions, legalMoveRightUpPositions, legalMoveLeftDownPositions, legalMoveRightDownPositions,
                        legalMoveLeftPositions, legalMoveRightPositions, legalMoveUpPositions, legalMoveDownPositions)
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

    private Set<Position> legalMoveLeftPositions(final Pieces pieces) {
        final var legalMoveLeftPositions = new HashSet<Position>();
        var current = position();
        while (current.canMoveLeft()) {
            current = current.moveLeft();
            if (pieces.matchColor(current, color())) {
                break;
            }

            legalMoveLeftPositions.add(current);

            if (pieces.matchColor(current, oppositeColor())) {
                break;
            }
        }

        return legalMoveLeftPositions;
    }

    private Set<Position> legalMoveRightPositions(final Pieces pieces) {
        final var legalMoveRightPositions = new HashSet<Position>();
        var current = position();
        while (current.canMoveRight()) {
            current = current.moveRight();
            if (pieces.matchColor(current, color())) {
                break;
            }

            legalMoveRightPositions.add(current);

            if (pieces.matchColor(current, oppositeColor())) {
                break;
            }
        }

        return legalMoveRightPositions;
    }

    private Set<Position> legalMoveUpPositions(final Pieces pieces) {
        final var legalMoveUpPositions = new HashSet<Position>();
        var current = position();
        while (current.canMoveUp()) {
            current = current.moveUp();
            if (pieces.matchColor(current, color())) {
                break;
            }

            legalMoveUpPositions.add(current);

            if (pieces.matchColor(current, oppositeColor())) {
                break;
            }
        }

        return legalMoveUpPositions;
    }

    private Set<Position> legalMoveDownPositions(final Pieces pieces) {
        final var legalMoveDownPositions = new HashSet<Position>();
        var current = position();
        while (current.canMoveDown()) {
            current = current.moveDown();
            if (pieces.matchColor(current, color())) {
                break;
            }

            legalMoveDownPositions.add(current);

            if (pieces.matchColor(current, oppositeColor())) {
                break;
            }
        }

        return legalMoveDownPositions;
    }

    @Override
    protected Piece update(final Position destination) {
        return new Queen(color(), destination);
    }
}
