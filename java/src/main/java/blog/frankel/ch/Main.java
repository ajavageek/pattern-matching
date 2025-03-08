package blog.frankel.ch;

interface Shape { }
record Rectangle(double length, double width) implements Shape { }
record Circle(double radius) implements Shape { }

public class Main {
    static double getPerimeter(Shape s) throws IllegalArgumentException {
        return switch (s) {
            case Rectangle r when r.length() == r.width() -> {
                System.out.println("Square detected");
                    yield 4 * r.length();
            }
            case Rectangle r ->
                    2 * r.length() + 2 * r.width();
            case Circle c ->
                    2 * c.radius() * Math.PI;
            default ->
                    throw new IllegalArgumentException("Unrecognized shape");
        };
    }

    public static void main(String[] args) {
        System.out.println(getPerimeter(new Rectangle(2.0, 3.0)));
        System.out.println(getPerimeter(new Rectangle(3.0, 3.0)));
        System.out.println(getPerimeter(new Circle(3.0)));
    }
}
