package sample;

public class Lab1 {
    private int x;
    private int y;
    private int c;

    public Lab1() {
        this.x = 1 + (int) (Math.random() * 9);
        this.y = 1 + (int) (Math.random() * 9);
        this.c = this.x * this.y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getC() {
        return this.c;
    }
}