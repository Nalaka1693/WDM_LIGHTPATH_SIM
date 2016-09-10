public class Fiber {
    private final int noOfWavLens = 2;
    private int direction;
    private int[] wavLens = new int[noOfWavLens];
    private final int capacityPerWavLen = 40;

    public Fiber(int direction) {
        this.direction = direction;
    }

}
