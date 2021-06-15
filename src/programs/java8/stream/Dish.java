package programs.java8.stream;

public class Dish {
    private int  calories;
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Dish(int calories)
    {
        this.calories = calories;
    }

    public int getCalories()
    {
        return calories;
    }

    public void setCalories(int calories)
    {
        this.calories = calories;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
