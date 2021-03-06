import java.text.DecimalFormat;
import java.text.NumberFormat;


public class ThreadTwo extends Thread {
    private NumberFormat formatter = new DecimalFormat("#0.000");
    private double x0 = 1;
    private double delta = 0.00001;

    public ThreadTwo(String name) {
        super(name);
    }

    @Override
    public void run() {
        int intensity = 0;
        while (true) {
            getFunc(x0);
            if (intensity++ > Math.pow(16, 6.5)) {
                intensity = 0;
                System.out.println("Thread: " + this.getName() + "\n" +
                        "Function at " + formatter.format(x0) + " equals " + formatter.format(getFunc(x0)));
            }
            x0 = x0 + delta;
        }
    }

    public double getFunc(double x0) {
        return 5 + x0 / Math.sqrt(x0);
    }
}