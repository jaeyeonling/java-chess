package chess.piece;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.Fixtures.A1;
import static chess.Fixtures.A2;
import static chess.Fixtures.EMPTY_PIECES;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("빈 칸")
class BlankTest {

    @DisplayName("움직일 수 있는 위치가 없다.")
    @Test
    void legalMovePositions() {
        final var blank = new Blank(A1);

        final var legalMovePositions = blank.legalMovePositions(EMPTY_PIECES);

        assertThat(legalMovePositions).isEmpty();
    }

    @DisplayName("움직일 수 없다.")
    @Test
    void update() {
        final var blank = new Blank(A1);

        Assertions.assertThatThrownBy(() -> blank.update(A2))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
