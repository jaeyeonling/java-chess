package chess.piece;

import chess.Color;
import chess.Position;

import java.util.Set;

public final class Blank extends Piece {

    public Blank(final Position position) {
        super(Color.EMPTY, position);
    }

    @Override
    public Set<Position> legalMovePositions(final Pieces pieces) {
        return Set.of();
    }

    @Override
    protected Piece update(final Position destination) {
        throw new UnsupportedOperationException();
    }
}
