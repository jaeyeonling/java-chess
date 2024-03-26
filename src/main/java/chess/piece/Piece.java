package chess.piece;

import chess.Color;
import chess.Movement;
import chess.Position;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

/*
Bishop
Rook
Queen

Knight
King

Pawn
 */

public sealed abstract class Piece
        permits Blank, Pawn, SlidingPiece, JumpingPiece {

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

    public Set<Position> legalMovePositions(final Pieces pieces) {
        return movements().stream()
                .filter(movement -> position().canMove(movement))
                .flatMap(movement -> legalMovePositions(movement, pieces).stream())
                .collect(toSet());
    }

    protected abstract Set<Position> legalMovePositions(Movement movement, Pieces pieces);

    protected abstract Set<Movement> movements();

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
