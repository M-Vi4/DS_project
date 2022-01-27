public class Neighborhood {
    private double min_X;
    private double max_X;
    private double min_Y;
    private double max_Y;
    private String name;

    public Neighborhood(double min_X, double max_X, double min_Y, double max_Y, String name) {
        this.min_X = min_X;
        this.max_X = max_X;
        this.min_Y = min_Y;
        this.max_Y = max_Y;
        this.name = name;
    }

    public double getMin_X() {
        return min_X;
    }

    public double getMax_X() {
        return max_X;
    }

    public double getMin_Y() {
        return min_Y;
    }

    public double getMax_Y() {
        return max_Y;
    }

    public String getName() {
        return name;
    }

    public void setMin_X(double min_X) {
        this.min_X = min_X;
    }

    public void setMax_X(double max_X) {
        this.max_X = max_X;
    }

    public void setMin_Y(double min_Y) {
        this.min_Y = min_Y;
    }

    public void setMax_Y(double max_Y) {
        this.max_Y = max_Y;
    }

    public void setName(String name) {
        this.name = name;
    }
}