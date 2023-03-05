package data;

public class Location {
    private final Double x;
    private final float y;
    private final String name;

    public Location(Double x, float y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public Double getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String getName() {
        return name;
    }
}