class Point {
    private final int x;
    private final int y;

    static Point random() {
        return new Point(
                Fn.random_val(C.POINT_MIN_X, C.POINT_MAX_X),
                Fn.random_val(C.POINT_MIN_Y, C.POINT_MAX_Y)
        );
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x() {
        return x;
    }

    int y() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
