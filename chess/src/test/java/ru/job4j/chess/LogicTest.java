package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.QueenWhite;
import static ru.job4j.chess.firuges.Cell.*;


public class LogicTest {

    @Test(expected = FigureNotFoundException.class)
    public void whenMoveErrFindBy() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(C4));
        logic.move(F2, D4);
    }

    @Test(expected = IllegalStateException.class)
    public void whenMoveErrWay() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(H1));
        logic.move(H1, C5);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenMoveErrFree() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(C1));
        logic.add(new QueenWhite(E3));
        logic.move(C1, G5);
    }
}