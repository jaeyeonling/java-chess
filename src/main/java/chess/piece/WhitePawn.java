package chess.piece;

import chess.Color;
import chess.Movement;
import chess.Position;

import java.util.Set;

import static chess.Movement.LEFT_UP;
import static chess.Movement.RIGHT_UP;
import static chess.Movement.UP;

/*
1. 처음 움직일 때는 두 칸 전진 가능
    -> 현재 위치로
    -> 필드로
2. 흑백 움직임이 다르다
3-1. 직선 -> 움직일 위치에 비어있으면 움직일 수 있음
3-2. 대각선 -> 잡을 때 대각선 전진가능
4. 뛰어넘을 수 없다 ->
 */
public final class WhitePawn extends Pawn {

    WhitePawn(final Position position) {
        super(Color.WHITE, position);
    }

    @Override
    protected Set<Movement> movements() {
        return Set.of(UP, LEFT_UP, RIGHT_UP);
    }

    @Override
    protected Piece update(final Position destination) {
        return new WhitePawn(destination);
    }
}
