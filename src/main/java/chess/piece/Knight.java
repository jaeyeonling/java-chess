package chess.piece;

import chess.Color;
import chess.Movement;
import chess.Position;

import java.util.Set;

import static chess.Movement.DOWN_DOWN_LEFT;
import static chess.Movement.DOWN_DOWN_RIGHT;
import static chess.Movement.LEFT_LEFT_DOWN;
import static chess.Movement.LEFT_LEFT_UP;
import static chess.Movement.RIGHT_RIGHT_DOWN;
import static chess.Movement.RIGHT_RIGHT_UP;
import static chess.Movement.UP_UP_LEFT;
import static chess.Movement.UP_UP_RIGHT;

/*
- 왼쪽 왼쪽 위, 왼쪽 왼쪽 아래
- 오른쪽 오른쪽 위, 오른쪽 오른쪽 아래
- 위 위 왼쪽, 위 위 오른쪽
- 아래 아래 왼쪽, 아래 아래 오른쪽
- 이동 가능하면 이동함
- 움직일 위치에 비어있거나 상대방의 기물이 있으면 움직일 수 있음 -> 내 기물 있으면 움직일 수 없음
 */
public final class Knight extends JumpingPiece {

    public Knight(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    protected Set<Movement> movements() {
        return Set.of(
                UP_UP_LEFT,
                UP_UP_RIGHT,
                LEFT_LEFT_UP,
                LEFT_LEFT_DOWN,
                RIGHT_RIGHT_UP,
                RIGHT_RIGHT_DOWN,
                DOWN_DOWN_LEFT,
                DOWN_DOWN_RIGHT
        );
    }

    @Override
    protected Piece update(final Position destination) {
        return new Knight(color(), destination);
    }
}
