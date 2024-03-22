package chess.piece;

import chess.Color;
import chess.Position;

import java.util.Set;

public sealed abstract class Piece
        permits Blank, King, Queen, Pawn, Rook, Knight, Bishop {

    private final Color color;

    private final Position position;

    protected Piece(final Color color, final Position position) {
        this.color = color;
        this.position = position;
    }

    public final Piece move(final Position destination, final Set<Piece> pieces) {
        if (position.equals(destination)) {
            throw new IllegalArgumentException("동일한 위치로 이동할 수 없습니다.");
        }
        final var movablePositions = legalMovePositions(new Pieces(pieces));
        if (!movablePositions.contains(destination)) {
            throw new IllegalArgumentException("말을 움직일 수 있는 위치가 아닙니다.");
        }

        return update(destination);
    }

    protected abstract Set<Position> legalMovePositions(Pieces pieces);

    protected abstract Piece update(Position destination);

    public final Color color() {
        return color;
    }

    public final Position position() {
        return position;
    }

    public final Color oppositeColor() {
        return color.opposite();
    }

    public final boolean matchColor(final Color other) {
        return color == other;
    }

    public final boolean nonMatchColor(final Color other) {
        return !matchColor(other);
    }
}
