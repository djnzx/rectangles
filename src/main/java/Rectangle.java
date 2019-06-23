import java.util.ArrayList;
import java.util.Collection;

public class Rectangle {
    private final Point p1;
    private final Point p2;

    static Rectangle random() {
        return new Rectangle(Point.random(), Point.random());
    }

    Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point p1() {
        return p1;
    }

    public Point p2() {
        return p2;
    }

    public Collection<Point> points() {
        int minx = Math.min(p1.x(), p2.x());
        int maxx = Math.max(p1.x(), p2.x());
        int miny = Math.min(p1.y(), p2.y());
        int maxy = Math.max(p1.y(), p2.y());
        int width  = maxx - minx + 1;
        int height = maxy - miny + 1;
        ArrayList<Point> points = new ArrayList<>(width * height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                points.add(new Point(minx + x , miny + y));
            }
        }
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        if (p1 != null ? !p1.equals(rectangle.p1) : rectangle.p1 != null) return false;
        return p2 != null ? p2.equals(rectangle.p2) : rectangle.p2 == null;
    }

    @Override
    public int hashCode() {
        int result = p1 != null ? p1.hashCode() : 0;
        result = 31 * result + (p2 != null ? p2.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Rectangle{p1=%s, p2=%s}", p1, p2);
    }
}
