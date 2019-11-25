import java.util.stream.IntStream;
import java.util.stream.Stream;

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

  private Stream<Integer> x_range() {
    return IntStream.rangeClosed(left(), right()).boxed();
  }

  private Stream<Integer> y_range() {
    return IntStream.rangeClosed(top(), bottom()).boxed();
  }

  Stream<Point> points() {
    return x_range().flatMap(x -> y_range().map(y -> new Point(x, y)));
  }

}
