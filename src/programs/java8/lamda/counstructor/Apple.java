package programs.java8.lamda.counstructor;

public class Apple implements Fruit{
    private String color;
    private double weight;
    private int price;

    public Apple()
    {
        this.color = color;
    }

    public Apple(String color)
    {
        this.color = color;
    }

    public Apple(String color, double weight)
    {
        this.color = color;
        this.weight = weight;
    }

    public Apple(String color, double weight, int price)
    {
        this.color = color;
        this.weight = weight;
        this.price = price;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }
}
