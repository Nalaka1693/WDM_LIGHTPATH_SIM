public class Fiber {
    private String name;
    private final int noOfWavLens = 2;
    private int direction;
    private int[] wavLens;
    private int consumedWavLens = 0;
    private final int capacityPerWavLen = 40;

    public Fiber(String name, int direction) {
        this.name = name;
        this.direction = direction;
        wavLens = new int[noOfWavLens];
    }

    public int getDirection() {
        return direction;
    }

    public int getCapacityPerWavLen() {
        return capacityPerWavLen;
    }

    public boolean consumeWavLen() {
        if (this.consumedWavLens < this.noOfWavLens) {
            if (this.wavLens[this.consumedWavLens + 1] == 0) {
                this.wavLens[this.consumedWavLens + 1] = 1;
                this.consumedWavLens++;

                return true;
            }
        }

        return false;
    }
}
