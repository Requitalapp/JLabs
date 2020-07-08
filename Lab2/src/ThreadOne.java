import java.text.DecimalFormat;
import java.text.NumberFormat;

import static java.lang.Math.log;
import static java.lang.Math.sqrt;

public class ThreadOne extends Thread {
    private NumberFormat formatter = new DecimalFormat("#0.000");
    private double x0 = 10;
    private double delta = 0.0000001;

    public ThreadOne(String name) {
        super(name);
    }

    @Override
    public void run() {
        int intensity = 0;
        while (true) {
            getFunc(x0);

            if (intensity++ > Math.pow(16, 6)) {
                intensity = 0;
                System.out.println("Thread: " + this.getName() + "\n" +
                        "Function at " + formatter.format(x0) + " equals " + formatter.format(getFunc(x0)));
            }
            x0 = x0 + delta;
        }
    }

    public double getFunc(double x0) {
        return (10) / Math.sin((sqrt(x0 + log(x0))));
    }
}