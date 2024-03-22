package chess.piece;

import chess.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static chess.Fixtures.A1;
import static chess.Fixtures.A7;
import static chess.Fixtures.A8;
import static chess.Fixtures.B6;
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
import static chess.Fixtures.G1;
import static chess.Fixtures.G2;
import static chess.Fixtures.G7;
import static chess.Fixtures.H1;
import static chess.Fixtures.H8;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("비숍")
class BishopTest {

    /*
    .......*
    *.....*.
    .*...*..
    ..*.*...
    ...b....
    ..*.*...
    .*...*..
    *.....*.
     */
    @DisplayName("D4에 있을 경우 움직임을 검증한다.")
    @Test
    void legalMovePositions_d4() {
        final var bishop = new Bishop(Color.WHITE, D4);

        final var legalMovePositions = bishop.legalMovePositions(EMPTY_PIECES);

        final var leftUpPositions = List.of(C5, A7);
        final var leftDownPositions = List.of(C3, A1);
        final var rightUpPositions = List.of(E5, H8);
        final var rightDownPositions = List.of(E3, G1);
        final var cannotMovePositions = List.of(D3, C4, E4, D5);

        assertThat(legalMovePositions)
                .containsAll(leftUpPositions)
                .containsAll(leftDownPositions)
                .containsAll(rightUpPositions)
                .containsAll(rightDownPositions)
                .doesNotContainSequence(cannotMovePositions);
    }

    /*
    ........
    ......B.
    .B...*..
    ..*.*...
    ...b....
    ..*.*...
    .*...b..
    *.......
     */
    @DisplayName("D4에 있을 때 움직이는 막혀있는 경우 움직임을 검증한다.")
    @Test
    void legalMovePositions_d4_blocked() {
        final var bishop = new Bishop(Color.WHITE, D4);

        final var legalMovePositions = bishop.legalMovePositions(new Pieces(
                new Bishop(Color.BLACK, B6),
                new Bishop(Color.BLACK, G7),
                new Bishop(Color.WHITE, G2)
        ));

        final var leftUpPositions = List.of(C5, B6);
        final var leftDownPositions = List.of(C3, A1);
        final var rightUpPositions = List.of(E5, G7);
        final var rightDownPositions = List.of(E3);
        final var cannotMovePositions = List.of(A8, H8, G2, H1);

        assertThat(legalMovePositions)
                .containsAll(leftUpPositions)
                .containsAll(leftDownPositions)
                .containsAll(rightUpPositions)
                .containsAll(rightDownPositions)
                .doesNotContainSequence(cannotMovePositions);
    }
}
