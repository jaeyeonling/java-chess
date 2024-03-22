package chess.piece;

import chess.Color;
import chess.Position;

import java.util.Set;

public final class Rook extends Piece {

    public Rook(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    public Set<Position> legalMovePositions(final Pieces pieces) {
        return Set.of();
    }

    @Override
    protected Piece update(final Position destination) {
        return new Rook(color(), destination);
    }
}
