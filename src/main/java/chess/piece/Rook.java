package chess.piece;

import chess.Color;
import chess.Movement;
import chess.Position;

import java.util.Set;

import static chess.Movement.DOWN;
import static chess.Movement.LEFT;
import static chess.Movement.RIGHT;
import static chess.Movement.UP;

/*
- 위 아래 왼쪽 오른쪽 해당 방향으로 쭉 움직인다.
- 해당 위치에 상대방의 기물이 있으면 뒤로 이동하지 못함.
- 해당 위치에 내 기물이 있으면 직전에 멈춤.
 */
public final class Rook extends SlidingPiece {

    public Rook(final Color color, final Position position) {
        super(color, position);
    }


    @Override
    protected Set<Movement> movements() {
        return Set.of(UP, DOWN, LEFT, RIGHT);
    }

    @Override
    protected Piece update(final Position destination) {
        return new Rook(color(), destination);
    }
}
