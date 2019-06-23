import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    int x_min() {
        return Math.min(p1.x(), p2.x());
    }

    int x_max() {
        return Math.max(p1.x(), p2.x());
    }

    int y_min() {
        return Math.min(p1.y(), p2.y());
    }

    int y_max() {
        return Math.max(p1.y(), p2.y());
    }

    Collection<Point> points() {
        return IntStream.rangeClosed(x_min(), x_max())
                .mapToObj(x -> IntStream
                        .rangeClosed(y_min(), y_max())
                        .mapToObj(y -> new Point(x, y))
                        .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
