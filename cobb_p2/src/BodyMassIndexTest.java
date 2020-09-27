/*
Purpose: Test case for BodyMassIndex class
Name: Anthony Cobb
Date Created: 9/26/2020
Date Modified: 9/26/2020
*/
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest
{
    @Test
    public void testGetHeight()
    {
        final double height = 70;
        final double weight = 20;
        BodyMassIndex bmi = new BodyMassIndex(height, weight);

        assertEquals(height, bmi.getHeight());
    }

    @Test
    public void testGetWeight()
    {
        final double height = 70;
        final double weight = 20;
        BodyMassIndex bmi = new BodyMassIndex(height, weight);

        assertEquals(height, bmi.getHeight());
    }

    @Test
    public void testGetScore()
    {
        final double height = 70;
        final double weight = 20;
        double bmiCalculate = 703 * weight / (height * height);
        BodyMassIndex bmi = new BodyMassIndex(height, weight);

        assertEquals(bmiCalculate, bmi.getScore());
    }

    @Test
    public void testGetCategoryUnderweight()
    {
        final double height = 70;
        final double weight = 50;
        double bmiCalculate = 703 * weight / (height * height);
        BodyMassIndex bmi = new BodyMassIndex(height, weight);

        assertEquals("Underweight", bmi.getCategory());
        assertEquals(bmiCalculate, bmi.getScore());
        assertEquals(height, bmi.getHeight());
        assertEquals(weight, bmi.getWeight());
    }

    @Test
    public void testGetCategoryNormalWeight()
    {
        final double height = 70;
        final double weight = 150;
        double bmiCalculate = 703 * weight / (height * height);
        BodyMassIndex bmi = new BodyMassIndex(height, weight);

        assertEquals("Normal weight", bmi.getCategory());
        assertEquals(bmiCalculate, bmi.getScore());
        assertEquals(height, bmi.getHeight());
        assertEquals(weight, bmi.getWeight());
    }

    @Test
    public void testGetCategoryOverweight()
    {
        final double height = 70;
        final double weight = 200;
        double bmiCalculate = 703 * weight / (height * height);
        BodyMassIndex bmi = new BodyMassIndex(height, weight);

        assertEquals("Overweight", bmi.getCategory());
        assertEquals(bmiCalculate, bmi.getScore());
        assertEquals(height, bmi.getHeight());
        assertEquals(weight, bmi.getWeight());
    }

    @Test
    public void testGetCategoryObesity()
    {
        final double height = 70;
        final double weight = 250;
        double bmiCalculate = 703 * weight / (height * height);
        BodyMassIndex bmi = new BodyMassIndex(height, weight);

        assertEquals("Obesity", bmi.getCategory());
        assertEquals(bmiCalculate, bmi.getScore());
        assertEquals(height, bmi.getHeight());
        assertEquals(weight, bmi.getWeight());
    }

}
