public class Oven {
    private int temp;
    public int getTemp() {
        return this.temp;
    }

    public void preheatTo(int n) {
        this.temp = n;
    }
}