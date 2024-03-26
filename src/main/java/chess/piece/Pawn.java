package chess.piece;

import chess.Color;
import chess.Movement;
import chess.Position;

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
public sealed abstract class Pawn
        extends Piece
        permits WhitePawn, WhiteFirstPawn, BlackPawn, BlackFirstPawn {
    Pawn(final Color color, final Position position) {
        super(color, position);
    }

    protected abstract Set<Movement> movements();

    @Override
    protected Set<Position> legalMovePositions(final Movement movement, final Pieces pieces) {
        if (canMoveDiagonal(movement, pieces) || canMoveVertical(movement, pieces)) {
            return Set.of(position().move(movement));
        }
        return Set.of();
    }

    private boolean canMoveDiagonal(final Movement movement, final Pieces pieces) {
        return movement.isDiagonal() &&
                pieces.matchColor(position().move(movement), oppositeColor());
    }

    private boolean canMoveVertical(final Movement movement, final Pieces pieces) {
        if (!movement.isVertical()) {
            return false;
        }
        for (int i = 1; i <= movement.y(); i++) {
            if (!position().canMoveVertical(i) || !pieces.isBlank(position().moveVertical(i))) {
                return false;
            }
        }
        return true;
    }
}
