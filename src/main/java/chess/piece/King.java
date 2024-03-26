package chess.piece;

import chess.Color;
import chess.Movement;
import chess.Position;

import java.util.Set;

import static chess.Movement.DOWN;
import static chess.Movement.LEFT;
import static chess.Movement.LEFT_DOWN;
import static chess.Movement.LEFT_UP;
import static chess.Movement.RIGHT;
import static chess.Movement.RIGHT_DOWN;
import static chess.Movement.RIGHT_UP;
import static chess.Movement.UP;

/*
- 내가 맨 위면 위로 이동하지 못함
- 위, 아래, 오른쪽, 왼쪽, 왼쪽위, 오른쪽위, 왼쪽아래, 오른쪽아래
- 움직일 위치에 비어있거나 상대방의 기물이 있으면 움직일 수 있음 -> 내 기물 있으면 움직일 수 없음
 */
public final class King extends JumpingPiece {

    public King(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    protected Set<Movement> movements() {
        return Set.of(UP, DOWN, LEFT, RIGHT, LEFT_UP, LEFT_DOWN, RIGHT_UP, RIGHT_DOWN);
    }

    @Override
    protected Piece update(final Position destination) {
        return new King(color(), destination);
    }
}
