public class Sphere extends Shape3D
{
    private final double radius;
    private final double pi = 3.14159;

    public Sphere(double radius)
    {
        this.radius = radius;
    }

    @Override
    public String getName()
    {
        return "sphere";
    }

    @Override
    public double getArea()
    {
        return 4 * pi * radius * radius;
    }

    @Override
    public double getVolume()
    {
        return  (4 * pi * radius * radius * radius) / 3;
    }
}
