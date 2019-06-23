import java.util.ArrayList;
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

    static long count(Collection<Rectangle> rectangles) {
        return rectangles.stream()
                .map(Rectangle::points)
                .flatMap(Collection::stream)
                .distinct()
                .count();
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(new Point(0, 0), new Point(4, 4));
        Rectangle r2 = new Rectangle(new Point(5, 5), new Point(9, 9));
        Rectangle r3 = new Rectangle(new Point(2, 2), new Point(7, 7));
        ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>() {{
            add(r1);
            add(r2);
            add(r3);
        }};
        System.out.println(count(rectangles));
    }


    public static void main1(String[] args) {
        Application app = new Application();
        Collection<Rectangle> rectangles = app.create_rectangles(20);
        long square = count(rectangles);
        System.out.printf("The square of all the rectangles is: %d\n", square);
    }
}
