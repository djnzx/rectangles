import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    Collection<Rectangle> create_rectangles(int qty) {
        return Stream
                .generate(Rectangle::random)
                .limit(qty)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Application app = new Application();
        Collection<Rectangle> rectangles = app.create_rectangles(20);
        // do the task
        long square = rectangles.stream()
                .map(Rectangle::points) // Stream<Collection<Point>>
                .flatMap(Collection::stream)
                .distinct()
                .count();
        System.out.printf("The square of all the rectangles is: %d\n", square);
    }
}
