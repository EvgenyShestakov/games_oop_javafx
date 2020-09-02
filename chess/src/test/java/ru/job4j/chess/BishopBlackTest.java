package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class BishopBlackTest {

    @Test
    public  void whenPosition() {
    BishopBlack bishopBlack = new BishopBlack(Cell.H3);
    assertThat(bishopBlack.position(), is(Cell.H3));
    }

    @Test
    public  void whenCopy() {
    BishopBlack bishopBlack = new BishopBlack(Cell.H6);
    assertThat(bishopBlack.copy(Cell.C1).position(), is(Cell.C1));
    }

    @Test
    public  void whenWay() {
    BishopBlack bishopBlack = new BishopBlack(Cell.C1);
    Cell[] values = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
    assertThat(bishopBlack.way(Cell.C1, Cell.G5), is(values));
    }

    @Test(expected = IllegalStateException.class)
    public  void whenErrWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A8);
        bishopBlack.way(Cell.A8,Cell.E5);
    }
}
