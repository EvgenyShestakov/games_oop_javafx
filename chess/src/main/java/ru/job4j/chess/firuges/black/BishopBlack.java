package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest));
        }
        int size = Math.abs(source.getY() - dest.getY());
        Cell[] steps = new Cell[size];
        int deltaX = source.getX() < dest.getX()  ? 1 : -1;
        int deltaY = source.getY() < dest.getY()  ? 1 : -1;
        int x = source.getX();
        int y = source.getY();
        for (int index = 0; index < size; index++) {
            x += deltaX;
            y += deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean diagonal = false;
        if (Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY())) {
            diagonal = true;
        }
        return diagonal;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
