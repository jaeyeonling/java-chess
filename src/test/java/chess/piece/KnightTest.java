package chess.piece;

import chess.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static chess.Fixtures.A3;
import static chess.Fixtures.B1;
import static chess.Fixtures.B3;
import static chess.Fixtures.B5;
import static chess.Fixtures.C2;
import static chess.Fixtures.C3;
import static chess.Fixtures.C6;
import static chess.Fixtures.D2;
import static chess.Fixtures.D3;
import static chess.Fixtures.D4;
import static chess.Fixtures.D5;
import static chess.Fixtures.E2;
import static chess.Fixtures.E3;
import static chess.Fixtures.E6;
import static chess.Fixtures.EMPTY_PIECES;
import static chess.Fixtures.F3;
import static chess.Fixtures.F5;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("나이트")
class KnightTest {

    /*
    ........
    ........
    ........
    ........
    ........
    *.*.....
    ...*....
    .n......
     */
    @DisplayName("B1에 있을 경우 움직임을 검증한다.")
    @Test
    void legalMovePositions_b1() {
        final var knight = new Knight(Color.WHITE, B1);

        final var legalMovePositions = knight.legalMovePositions(EMPTY_PIECES);

        final var allPositions = List.of(A3, C3, D2);

        assertThat(legalMovePositions)
                .containsExactlyInAnyOrderElementsOf(allPositions);
    }

    /*
    ........
    ........
    ..*.N...
    .*.N.*..
    ...n....
    .*...n..
    ..*.*...
    ........
     */
    @DisplayName("D4에 있을 경우 움직임을 검증한다.")
    @Test
    void legalMovePositions_d4() {
        final var knight = new Knight(Color.WHITE, D4);

        final var legalMovePositions = knight.legalMovePositions(new Pieces(
                new Knight(Color.WHITE, F3),
                new Knight(Color.BLACK, D5),
                new Knight(Color.BLACK, E6)
        ));

        final var upPositions = List.of(C6, E6);
        final var downPositions = List.of(C2, E2);
        final var leftPositions = List.of(B3, B5);
        final var rightPositions = List.of(F5);
        final var cannotMovePositions = List.of(D2, D3, E3, F3);

        assertThat(legalMovePositions)
                .containsAll(upPositions)
                .containsAll(downPositions)
                .containsAll(leftPositions)
                .containsAll(rightPositions)
                .doesNotContainAnyElementsOf(cannotMovePositions);
    }
}
