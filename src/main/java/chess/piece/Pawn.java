package chess.piece;

import chess.Color;
import chess.Position;
import chess.Row;

import java.util.HashSet;
import java.util.Set;

/*
1. 처음 움직일 때는 두 칸 전진 가능
    -> 현재 위치로
    -> 필드로
2. 흑백 움직임이 다르다
3-1. 직선 -> 움직일 위치에 비어있으면 움직일 수 있음
3-2. 대각선 -> 잡을 때 대각선 전진가능
4. 뛰어넘을 수 없다 ->
 */
public final class Pawn extends Piece {

    private static final Row WHITE_START_LINE = Row.TWO;
    private static final Row BLACK_START_LINE = Row.SEVEN;

    Pawn(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    public Set<Position> legalMovePositions(final Pieces pieces) {
        final var legalMovePositions = new HashSet<Position>();
        if (color().isWhite()) {
            if (position().row().equals(WHITE_START_LINE) &&
                    pieces.isBlank(position().moveUp()) &&
                    pieces.isBlank(position().moveUp(2))) {
                legalMovePositions.add(position().moveUp(2));
            }
            if (position().canMoveUp() && pieces.isBlank(position().moveUp())) {
                legalMovePositions.add(position().moveUp());
            }
            if (position().canMoveLeftUp() && pieces.matchColor(position().moveLeftUp(), oppositeColor())) {
                legalMovePositions.add(position().moveLeftUp());
            }
            if (position().canMoveRightUp() && pieces.matchColor(position().moveRightUp(), oppositeColor())) {
                legalMovePositions.add(position().moveRightUp());
            }
        }
        if (color().isBlack()) {
            if (position().row().equals(BLACK_START_LINE) && pieces.isBlank(position().moveDown(2))) {
                legalMovePositions.add(position().moveDown(2));
            }
            if (position().canMoveDown() &&
                    pieces.isBlank(position().moveDown()) &&
                    pieces.isBlank(position().moveDown())) {
                legalMovePositions.add(position().moveDown());
            }
            if (position().canMoveLeftDown() && pieces.matchColor(position().moveLeftDown(), oppositeColor())) {
                legalMovePositions.add(position().moveLeftDown());
            }
            if (position().canMoveRightDown() && pieces.matchColor(position().moveRightDown(), oppositeColor())) {
                legalMovePositions.add(position().moveRightDown());
            }
        }

        return legalMovePositions;
    }

    @Override
    protected Piece update(final Position destination) {
        return new Pawn(color(), destination);
    }
}
