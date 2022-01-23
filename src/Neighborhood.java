public class Neighborhood {
    private final double[] first;
    private final double[] second;
    private final double[] third;
    private final double[] fourth;
    private final String name;

    public Neighborhood(double[] first, double[] second, double[] third, double[] fourth, String name) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.name = name;
    }

    public double[] getFirst() {
        return first;
    }

    public double[] getSecond() {
        return second;
    }

    public double[] getThird() {
        return third;
    }

    public double[] getFourth() {
        return fourth;
    }

    public String getName() {
        return name;
    }
}