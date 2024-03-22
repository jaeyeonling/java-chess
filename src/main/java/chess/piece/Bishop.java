package chess.piece;

import chess.Color;
import chess.Position;

import java.util.Set;

public final class Bishop extends Piece {

    public Bishop(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    public Set<Position> legalMovePositions(final Pieces pieces) {
        return Set.of();
    }

    @Override
    protected Piece update(final Position destination) {
        return new Bishop(color(), destination);
    }
}
