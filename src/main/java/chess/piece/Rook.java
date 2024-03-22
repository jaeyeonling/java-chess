package chess.piece;

import chess.Color;
import chess.Position;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
- 위 아래 왼쪽 오른쪽 해당 방향으로 쭉 움직인다.
- 해당 위치에 상대방의 기물이 있으면 뒤로 이동하지 못함.
- 해당 위치에 내 기물이 있으면 직전에 멈춤.
 */
public final class Rook extends Piece {

    public Rook(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    public Set<Position> legalMovePositions(final Pieces pieces) {
        final var legalMoveLeftPositions = legalMoveLeftPositions(pieces);
        final var legalMoveRightPositions = legalMoveRightPositions(pieces);
        final var legalMoveUpPositions = legalMoveUpPositions(pieces);
        final var legalMoveDownPositions = legalMoveDownPositions(pieces);

        return Stream.of(legalMoveLeftPositions, legalMoveRightPositions, legalMoveUpPositions, legalMoveDownPositions)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
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
        return new Rook(color(), destination);
    }
}
