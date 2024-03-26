package chess.piece;

import chess.Color;
import chess.Movement;
import chess.Position;

import java.util.Set;

import static chess.Movement.DOWN;
import static chess.Movement.LEFT_DOWN;
import static chess.Movement.RIGHT_DOWN;

/*
1. 처음 움직일 때는 두 칸 전진 가능
    -> 현재 위치로
    -> 필드로
2. 흑백 움직임이 다르다
3-1. 직선 -> 움직일 위치에 비어있으면 움직일 수 있음
3-2. 대각선 -> 잡을 때 대각선 전진가능
4. 뛰어넘을 수 없다 ->
 */
public final class BlackPawn extends Pawn {

    BlackPawn(final Position position) {
        super(Color.BLACK, position);
    }

    @Override
    protected Set<Movement> movements() {
        return Set.of(DOWN, LEFT_DOWN, RIGHT_DOWN);
    }

    @Override
    protected Piece update(final Position destination) {
        return new BlackPawn(destination);
    }
}
