package chess.piece;

import chess.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static chess.Fixtures.A1;
import static chess.Fixtures.A4;
import static chess.Fixtures.A7;
import static chess.Fixtures.A8;
import static chess.Fixtures.B4;
import static chess.Fixtures.B6;
import static chess.Fixtures.C3;
import static chess.Fixtures.C4;
import static chess.Fixtures.C5;
import static chess.Fixtures.D1;
import static chess.Fixtures.D2;
import static chess.Fixtures.D3;
import static chess.Fixtures.D4;
import static chess.Fixtures.D5;
import static chess.Fixtures.D6;
import static chess.Fixtures.D7;
import static chess.Fixtures.D8;
import static chess.Fixtures.E3;
import static chess.Fixtures.E4;
import static chess.Fixtures.E5;
import static chess.Fixtures.EMPTY_PIECES;
import static chess.Fixtures.G1;
import static chess.Fixtures.G2;
import static chess.Fixtures.G7;
import static chess.Fixtures.H1;
import static chess.Fixtures.H4;
import static chess.Fixtures.H8;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("퀸")
public class QueenTest {

    /*
    ...*...*
    *..*..*.
    .*.*.*..
    ..***...
    ***q****
    ..***...
    .*.*.*..
    *..*..*.
     */
    @DisplayName("D4에 있을 경우 움직임을 검증한다.")
    @Test
    void legalMovePositions_d4() {
        final var queen = new Queen(Color.WHITE, D4);

        final var legalMovePositions = queen.legalMovePositions(EMPTY_PIECES);

        final var upPositions = List.of(D5, D8);
        final var downPositions = List.of(D3, D1);
        final var leftPositions = List.of(C4, A4);
        final var rightPositions = List.of(E4, H4);
        final var upLeftPositions = List.of(C5, A7);
        final var downLeftPositions = List.of(C3, A1);
        final var upRightPositions = List.of(D5, H8);
        final var downRightPositions = List.of(E3, G1);
        final var cannotMovePositions = List.of(C3, E3, C5, E5);

        assertThat(legalMovePositions)
                .containsAll(upPositions)
                .containsAll(downPositions)
                .containsAll(leftPositions)
                .containsAll(rightPositions)
                .containsAll(upLeftPositions)
                .containsAll(downLeftPositions)
                .containsAll(upRightPositions)
                .containsAll(downRightPositions)
                .doesNotContainSequence(cannotMovePositions);
    }

    /*
    ........
    ...Q..Q.
    .Q.*.*..
    ..***...
    .q*q****
    ..***...
    .*.q.q..
    *.......
     */
    @DisplayName("D4에 있을 때 움직이는 막혀있는 경우 움직임을 검증한다.")
    @Test
    void legalMovePositions_d4_blocked() {
        final var queen = new Queen(Color.WHITE, D4);

        final var legalMovePositions = queen.legalMovePositions(new Pieces(
                new Queen(Color.BLACK, B6),
                new Queen(Color.BLACK, G7),
                new Queen(Color.WHITE, G2),
                new Queen(Color.WHITE, B4),
                new Queen(Color.WHITE, D2),
                new Queen(Color.BLACK, D7)
        ));

        final var upPositions = List.of(D5, D6, D7);
        final var downPositions = List.of(D3);
        final var leftPositions = List.of(C4);
        final var rightPositions = List.of(E4, H4);
        final var leftUpPositions = List.of(C5, B6);
        final var leftDownPositions = List.of(C3, A1);
        final var rightUpPositions = List.of(E5, G7);
        final var rightDownPositions = List.of(E3);
        final var cannotMovePositions = List.of(A8, H8, G2, H1, B4, D2);

        assertThat(legalMovePositions)
                .containsAll(upPositions)
                .containsAll(downPositions)
                .containsAll(leftPositions)
                .containsAll(rightPositions)
                .containsAll(leftUpPositions)
                .containsAll(leftDownPositions)
                .containsAll(rightUpPositions)
                .containsAll(rightDownPositions)
                .doesNotContainSequence(cannotMovePositions);
    }
}
