import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Rectangles {
    private final Collection<Rectangle> rectangles;

    static Collection<Rectangle> random(int qty) {
        return Stream
                .generate(Rectangle::random)
                .limit(qty)
                .collect(Collectors.toList());
    }

    static long square(Collection<Rectangle> rectangles) {
        return rectangles.stream()
                .map(Rectangle::points)
                .flatMap(Collection::stream)
                .distinct()
                .count();
    }

    Rectangles() {
        this(C.RECTANGLES_COUNT);
    }

    Rectangles(int qty) {
        this.rectangles = Rectangles.random(qty);
    }

    long square() {
        return square(this.rectangles);
    }

}
