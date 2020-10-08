import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Pyramid extends Shape3D
{
    private final double length;
    private final double width;
    private final double height;

    public Pyramid(double length, double width, double height)
    {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public String getName()
    {
        return "pyramid";
    }

    @Override
    public double getArea()
    {
        return (length * width) +
                (length * sqrt(pow(width / 2, 2) + pow(height, 2))) +
                (width * sqrt(pow(length / 2, 2) + pow(height, 2)));
    }

    @Override
    public double getVolume()
    {
        return (length * width * height) / 3;
    }
}
