import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Rectangle {
    private final Point p1;
    private final Point p2;

    static Rectangle random() {
        return new Rectangle(Point.random(), Point.random());
    }

    Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    int left() {
        return Math.min(p1.x(), p2.x());
    }

    int right() {
        return Math.max(p1.x(), p2.x());
    }

    int top() {
        return Math.min(p1.y(), p2.y());
    }

    int bottom() {
        return Math.max(p1.y(), p2.y());
    }

    Collection<Point> points() {
        return IntStream.rangeClosed(left(), right())
                .mapToObj(x -> IntStream
                        .rangeClosed(top(), bottom())
                        .mapToObj(y -> new Point(x, y))
                        .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

}
