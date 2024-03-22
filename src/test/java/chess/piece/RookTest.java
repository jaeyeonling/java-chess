package chess.piece;

import chess.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static chess.Fixtures.A1;
import static chess.Fixtures.A2;
import static chess.Fixtures.A3;
import static chess.Fixtures.A4;
import static chess.Fixtures.A5;
import static chess.Fixtures.A7;
import static chess.Fixtures.A8;
import static chess.Fixtures.B1;
import static chess.Fixtures.B2;
import static chess.Fixtures.B3;
import static chess.Fixtures.B4;
import static chess.Fixtures.B6;
import static chess.Fixtures.B7;
import static chess.Fixtures.B8;
import static chess.Fixtures.C2;
import static chess.Fixtures.C3;
import static chess.Fixtures.C4;
import static chess.Fixtures.C5;
import static chess.Fixtures.C7;
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
import static chess.Fixtures.F2;
import static chess.Fixtures.F7;
import static chess.Fixtures.G2;
import static chess.Fixtures.G3;
import static chess.Fixtures.G6;
import static chess.Fixtures.G7;
import static chess.Fixtures.H1;
import static chess.Fixtures.H2;
import static chess.Fixtures.H3;
import static chess.Fixtures.H4;
import static chess.Fixtures.H5;
import static chess.Fixtures.H7;
import static chess.Fixtures.H8;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("룩")
class RookTest {

    /*
    *.......
    *.......
    *.......
    *.......
    *.......
    *.......
    *.......
    r*******
     */
    @DisplayName("A1에 있을 경우 움직임을 검증한다.")
    @Test
    void legalMovePositions_a1() {
        final var rook = new Rook(Color.WHITE, A1);

        final var legalMovePositions = rook.legalMovePositions(EMPTY_PIECES);

        final var upPositions = List.of(A2, A5, A8);
        final var rightPositions = List.of(B1, D1, H1);
        final var cannotMovePositions = List.of(B2, B3, C2);

        assertThat(legalMovePositions)
                .containsAll(upPositions)
                .containsAll(rightPositions)
                .doesNotContainSequence(cannotMovePositions);
    }

    /*
    .......*
    .......*
    .......*
    .......*
    .......*
    .......*
    .......*
    *******r
     */
    @DisplayName("H1에 있을 경우 움직임을 검증한다.")
    @Test
    void legalMovePositions_h1() {
        final var rook = new Rook(Color.WHITE, H1);

        final var legalMovePositions = rook.legalMovePositions(EMPTY_PIECES);

        final var upPositions = List.of(H2, H5, H8);
        final var leftPositions = List.of(B1, D1, A1);
        final var cannotMovePositions = List.of(G2, G3, F2);

        assertThat(legalMovePositions)
                .containsAll(upPositions)
                .containsAll(leftPositions)
                .doesNotContainSequence(cannotMovePositions);
    }

    /*
    r*******
    *.......
    *.......
    *.......
    *.......
    *.......
    *.......
    *.......
     */
    @DisplayName("A8에 있을 경우 움직임을 검증한다.")
    @Test
    void legalMovePositions_a8() {
        final var rook = new Rook(Color.WHITE, A8);

        final var legalMovePositions = rook.legalMovePositions(EMPTY_PIECES);

        final var downPositions = List.of(A7, A3, A1);
        final var rightPositions = List.of(B8, D8, H8);
        final var cannotMovePositions = List.of(B7, B6, C7);

        assertThat(legalMovePositions)
                .containsAll(downPositions)
                .containsAll(rightPositions)
                .doesNotContainSequence(cannotMovePositions);
    }

    /*
    *******r
    .......*
    .......*
    .......*
    .......*
    .......*
    .......*
    .......*
     */
    @DisplayName("H8에 있을 경우 움직임을 검증한다.")
    @Test
    void legalMovePositions_h8() {
        final var rook = new Rook(Color.WHITE, H8);

        final var legalMovePositions = rook.legalMovePositions(EMPTY_PIECES);

        final var downPositions = List.of(H7, H3, H1);
        final var leftPositions = List.of(B8, D8, A8);
        final var cannotMovePositions = List.of(G7, G6, F7);

        assertThat(legalMovePositions)
                .containsAll(downPositions)
                .containsAll(leftPositions)
                .doesNotContainSequence(cannotMovePositions);
    }

    /*
    ...*....
    ...*....
    ...*....
    ...*....
    ***r****
    ...*....
    ...*....
    ...*....
     */
    @DisplayName("D4에 있을 경우 움직임을 검증한다.")
    @Test
    void legalMovePositions_d4() {
        final var rook = new Rook(Color.WHITE, D4);

        final var legalMovePositions = rook.legalMovePositions(EMPTY_PIECES);

        final var upPositions = List.of(D5, D8);
        final var downPositions = List.of(D3, D1);
        final var leftPositions = List.of(C4, A4);
        final var rightPositions = List.of(E4, H4);
        final var cannotMovePositions = List.of(C3, E3, C5, E5);

        assertThat(legalMovePositions)
                .containsAll(upPositions)
                .containsAll(downPositions)
                .containsAll(leftPositions)
                .containsAll(rightPositions)
                .doesNotContainSequence(cannotMovePositions);
    }

    /*
    ........
    ...R....
    ...*....
    ...*....
    .r*r****
    ...*....
    ...r....
    ........
     */
    @DisplayName("D4에 있을 때 움직이는 막혀있는 경우 움직임을 검증한다.")
    @Test
    void legalMovePositions_d4_blocked() {
        final var rook = new Rook(Color.WHITE, D4);

        final var legalMovePositions = rook.legalMovePositions(new Pieces(
                new Rook(Color.WHITE, B4),
                new Rook(Color.WHITE, D2),
                new Rook(Color.BLACK, D7)
        ));

        final var upPositions = List.of(D5, D6, D7);
        final var downPositions = List.of(D3);
        final var leftPositions = List.of(C4);
        final var rightPositions = List.of(E4, H4);
        final var cannotMovePositions = List.of(B4, D2);

        assertThat(legalMovePositions)
                .containsAll(upPositions)
                .containsAll(downPositions)
                .containsAll(leftPositions)
                .containsAll(rightPositions)
                .doesNotContainSequence(cannotMovePositions);
    }
}
