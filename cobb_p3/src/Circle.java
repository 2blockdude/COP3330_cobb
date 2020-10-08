public class Circle extends Shape2D
{
    private final double radius;
    private final double pi = 3.14159;

    public Circle(double radius)
    {
        this.radius = radius;
    }

    @Override
    public String getName()
    {
        return "circle";
    }

    @Override
    public double getArea()
    {
        return pi * (radius * radius);
    }
}
