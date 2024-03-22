package chess.piece;

import chess.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static chess.Fixtures.A1;
import static chess.Fixtures.A2;
import static chess.Fixtures.B1;
import static chess.Fixtures.B2;
import static chess.Fixtures.C3;
import static chess.Fixtures.C4;
import static chess.Fixtures.C5;
import static chess.Fixtures.D3;
import static chess.Fixtures.D4;
import static chess.Fixtures.D5;
import static chess.Fixtures.E3;
import static chess.Fixtures.E4;
import static chess.Fixtures.E5;
import static chess.Fixtures.EMPTY_PIECES;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("킹")
class KingTest {

    /*
    ........
    ........
    ........
    ........
    ........
    ........
    **......
    k*......
     */
    @DisplayName("A4에 있을 경우 움직임을 검증한다.")
    @Test
    void legalMovePositions_a1() {
        final var king = new King(Color.WHITE, A1);

        final var legalMovePositions = king.legalMovePositions(EMPTY_PIECES);

        final var allPositions = List.of(A2, B2, B1);

        assertThat(legalMovePositions)
                .containsExactlyInAnyOrderElementsOf(allPositions);
    }

    /*
    ........
    ........
    ........
    ..K**...
    ..*k*...
    ..*n*...
    ........
    ........
     */
    @DisplayName("D4에 있을 경우 움직임을 검증한다.")
    @Test
    void legalMovePositions_d4() {
        final var king = new King(Color.WHITE, D4);

        final var legalMovePositions = king.legalMovePositions(new Pieces(
                new King(Color.BLACK, C5),
                new Knight(Color.WHITE, D3)
        ));

        final var upPositions = List.of(C5, D5, E5);
        final var downPositions = List.of(C3, E3);
        final var sidePositions = List.of(C4, E4);
        final var cannotMovePositions = List.of(D3);

        assertThat(legalMovePositions)
                .containsAll(upPositions)
                .containsAll(downPositions)
                .containsAll(sidePositions)
                .doesNotContainSequence(cannotMovePositions);
    }
}
