package chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static chess.Fixtures.A2;
import static chess.Fixtures.A3;
import static chess.Fixtures.A4;
import static chess.Fixtures.B3;
import static chess.Fixtures.C3;
import static chess.Fixtures.C4;
import static chess.Fixtures.D4;
import static chess.Fixtures.H2;
import static chess.Fixtures.H3;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("폰")
class PawnTest {
    /*
    ........
    ........
    ........
    ........
    *.......
    *P......
    p.......
    ........
     */
    @DisplayName("A2에 있을 경우 움직임을 검증한다.")
    @Test
    void legalMovePositions_a2() {
        final var pawn = new WhiteFirstPawn(A2);

        final var legalMovePositions = pawn.legalMovePositions(new Pieces(
                new BlackPawn(B3)
        ));

        final var upPositions = List.of(A3, A4, B3);

        assertThat(legalMovePositions)
                .containsExactlyInAnyOrderElementsOf(upPositions);
    }

    /*
    ........
    ........
    ........
    ........
    ..*P....
    ..p.....
    ........
    ........
     */
    @DisplayName("C3에 있을 경우 움직임을 검증한다.")
    @Test
    void legalMovePositions_c3() {
        final var pawn = new WhitePawn(C3);

        final var legalMovePositions = pawn.legalMovePositions(new Pieces(
                new BlackPawn(D4)
        ));

        final var upPositions = List.of(C4, D4);

        assertThat(legalMovePositions)
                .containsExactlyInAnyOrderElementsOf(upPositions);
    }

    /*
    ........
    ........
    ........
    ........
    ........
    .......P
    .......p
    ........
     */
    @DisplayName("H2에 있을 경우 움직임을 검증한다.")
    @Test
    void legalMovePositions_H2() {
        final var pawn = new WhitePawn(H2);

        final var legalMovePositions = pawn.legalMovePositions(new Pieces(
                new BlackPawn(H3)
        ));

        assertThat(legalMovePositions).isEmpty();
    }
}
