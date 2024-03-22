package chess;

public record Position(
        Column column,
        Row row
) {
    public Position(final Row row, final Column column) {
        this(column, row);
    }

    public boolean canMoveUp() {
        return row.canMoveUp(1);
    }

    public boolean canMoveUp(final int step) {
        return row.canMoveUp(step);
    }

    public Position moveUp() {
        return moveUp(1);
    }

    public Position moveUp(final int step) {
        return new Position(row.moveUp(step), column);
    }

    public boolean canMoveDown() {
        return canMoveDown(1);
    }

    public boolean canMoveDown(final int step) {
        return row.canMoveDown(step);
    }

    public Position moveDown() {
        return moveDown(1);
    }

    public Position moveDown(final int step) {
        return new Position(row.moveDown(step), column);
    }

    public boolean canMoveLeft() {
        return canMoveLeft(1);
    }

    public boolean canMoveLeft(final int step) {
        return column.canMoveLeft(step);
    }

    public Position moveLeft() {
        return moveLeft(1);
    }

    public Position moveLeft(final int step) {
        return new Position(row, column.moveLeft(step));
    }

    public boolean canMoveRight() {
        return canMoveRight(1);
    }

    public boolean canMoveRight(final int step) {
        return column.canMoveRight(step);
    }

    public Position moveRight() {
        return moveRight(1);
    }

    public Position moveRight(final int step) {
        return new Position(row, column.moveRight(step));
    }

    public Position moveLeftUp() {
        return moveLeft().moveUp();
    }

    public Position moveLeftDown() {
        return moveLeft().moveDown();
    }

    public Position moveRightUp() {
        return moveRight().moveUp();
    }

    public Position moveRightDown() {
        return moveRight().moveDown();
    }

    public boolean isTop() {
        return row.isTop();
    }

    public boolean isBottom() {
        return row.isBottom();
    }

    public boolean isFarLeft() {
        return column.isFarLeft();
    }

    public boolean isFarRight() {
        return column.isFarRight();
    }
}
