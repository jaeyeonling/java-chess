package chess.piece;

import chess.Color;
import chess.Position;

import java.util.HashSet;
import java.util.Set;

/*
- 내가 맨 위면 위로 이동하지 못함
- 위, 아래, 오른쪽, 왼쪽, 왼쪽위, 오른쪽위, 왼쪽아래, 오른쪽아래
- 움직일 위치에 비어있거나 상대방의 기물이 있으면 움직일 수 있음 -> 내 기물 있으면 움직일 수 없음
 */
public final class King extends Piece {

    public King(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    public Set<Position> legalMovePositions(final Pieces pieces) {
        final var movePositions = new HashSet<Position>();
        if (position().canMoveUp() && pieces.nonMatchColor(position().moveUp(), color())) {
            movePositions.add(position().moveUp());
        }
        if (position().canMoveDown() && pieces.nonMatchColor(position().moveDown(), color())) {
            movePositions.add(position().moveDown());
        }
        if (position().canMoveLeft() && pieces.nonMatchColor(position().moveLeft(), color())) {
            movePositions.add(position().moveLeft());
        }
        if (position().canMoveRight() && pieces.nonMatchColor(position().moveRight(), color())) {
            movePositions.add(position().moveRight());
        }
        if (position().canMoveLeftUp() && pieces.nonMatchColor(position().moveLeftUp(), color())) {
            movePositions.add(position().moveLeftUp());
        }
        if (position().canMoveRightUp() && pieces.nonMatchColor(position().moveRightUp(), color())) {
            movePositions.add(position().moveRightUp());
        }
        if (position().canMoveLeftDown() && pieces.nonMatchColor(position().moveLeftDown(), color())) {
            movePositions.add(position().moveLeftDown());
        }
        if (position().canMoveRightDown() && pieces.nonMatchColor(position().moveRightDown(), color())) {
            movePositions.add(position().moveRightDown());
        }
        return movePositions;
    }

    @Override
    protected Piece update(final Position destination) {
        return new King(color(), destination);
    }
}
