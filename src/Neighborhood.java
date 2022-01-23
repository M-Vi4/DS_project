public class Neighborhood {
    private final int[] first;
    private final int[] second;
    private final int[] third;
    private final int[] fourth;
    private final String name;

    public Neighborhood(int[] first, int[] second, int[] third, int[] fourth, String name) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.name = name;
    }

    public int[] getFirst() {
        return first;
    }

    public int[] getSecond() {
        return second;
    }

    public int[] getThird() {
        return third;
    }

    public int[] getFourth() {
        return fourth;
    }

    public String getName() {
        return name;
    }
}