package chess.piece;

import chess.Color;
import chess.Position;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
- 왼쪽 왼쪽 위, 왼쪽 왼쪽 아래
- 오른쪽 오른쪽 위, 오른쪽 오른쪽 아래
- 위 위 왼쪽, 위 위 오른쪽
- 아래 아래 왼쪽, 아래 아래 오른쪽
- 이동 가능하면 이동함
- 움직일 위치에 비어있거나 상대방의 기물이 있으면 움직일 수 있음 -> 내 기물 있으면 움직일 수 없음
 */
public final class Knight extends Piece {

    public Knight(final Color color, final Position position) {
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

    // - 왼쪽 왼쪽 위, 왼쪽 왼쪽 아래
    private Set<Position> legalMoveLeftPositions(final Pieces pieces) {
        final var legalMoveLeftPositions = new HashSet<Position>();
        if (position().canMoveLeft(2) && position().canMoveUp()
                && pieces.nonMatchColor(position().moveLeft(2).moveUp(), color())) {
            legalMoveLeftPositions.add(position().moveLeft(2).moveUp());
        }
        if (position().canMoveLeft(2) && position().canMoveDown()
                && pieces.nonMatchColor(position().moveLeft(2).moveDown(), color())) {
            legalMoveLeftPositions.add(position().moveLeft(2).moveDown());
        }
        return legalMoveLeftPositions;
    }

    // - 오른쪽 오른쪽 위, 오른쪽 오른쪽 아래
    private Set<Position> legalMoveRightPositions(final Pieces pieces) {
        final var legalMoveRightPositions = new HashSet<Position>();
        if (position().canMoveRight(2) && position().canMoveUp()
                && pieces.nonMatchColor(position().moveRight(2).moveUp(), color())) {
            legalMoveRightPositions.add(position().moveRight(2).moveUp());
        }
        if (position().canMoveRight(2) && position().canMoveDown()
                && pieces.nonMatchColor(position().moveRight(2).moveDown(), color())) {
            legalMoveRightPositions.add(position().moveRight(2).moveDown());
        }
        return legalMoveRightPositions;
    }

    // - 위 위 왼쪽, 위 위 오른쪽
    private Set<Position> legalMoveUpPositions(final Pieces pieces) {
        final var legalMoveUpPositions = new HashSet<Position>();
        if (position().canMoveUp(2) && position().canMoveLeft()
                && pieces.nonMatchColor(position().moveUp(2).moveLeft(), color())) {
            legalMoveUpPositions.add(position().moveUp(2).moveLeft());
        }
        if (position().canMoveUp(2) && position().canMoveRight()
                && pieces.nonMatchColor(position().moveUp(2).moveRight(), color())) {
            legalMoveUpPositions.add(position().moveUp(2).moveRight());
        }
        return legalMoveUpPositions;
    }

    // - 아래 아래 왼쪽, 아래 아래 오른쪽
    private Set<Position> legalMoveDownPositions(final Pieces pieces) {
        final var legalMoveDownPositions = new HashSet<Position>();
        if (position().canMoveDown(2) && position().canMoveLeft()
                && pieces.nonMatchColor(position().moveDown(2).moveLeft(), color())) {
            legalMoveDownPositions.add(position().moveDown(2).moveLeft());
        }
        if (position().canMoveDown(2) && position().canMoveRight()
                && pieces.nonMatchColor(position().moveDown(2).moveRight(), color())) {
            legalMoveDownPositions.add(position().moveDown(2).moveRight());
        }
        return legalMoveDownPositions;
    }

    @Override
    protected Piece update(final Position destination) {
        return new Knight(color(), destination);
    }
}
