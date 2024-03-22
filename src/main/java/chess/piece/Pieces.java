package chess.piece;

import chess.Color;
import chess.Position;

import java.util.Map;
import java.util.Set;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public final class Pieces {

    private final Map<Position, Piece> values;

    public Pieces() {
        this(Map.of());
    }

    public Pieces(final Piece... values) {
        this(Set.of(values));
    }

    public Pieces(final Set<Piece> values) {
        this(values.stream().collect(toMap(Piece::position, identity())));
    }

    public Pieces(final Map<Position, Piece> values) {
        this.values = values;
    }

    public Piece get(final Position position) {
        return values.getOrDefault(position, new Blank(position));
    }

    public boolean nonMatchColor(final Position position, final Color color) {
        return get(position).nonMatchColor(color);
    }

    public boolean matchColor(final Position position, final Color color) {
        return get(position).matchColor(color);
    }

    public boolean isBlank(final Position position) {
        return !values.containsKey(position);
    }
}
