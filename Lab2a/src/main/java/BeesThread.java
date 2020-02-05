import java.util.ArrayList;

public class BeesThread extends Thread {

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            int y;
            ArrayList<Integer> check;

            synchronized (Main.done) {
                if (Main.done >= Main.a.size())
                    break;

                y = Main.done;
                check = Main.a.get(y);
            }

            boolean found = false;

            for (int i = 0; i < check.size(); i++)
                if (check.get(i) == 1) {
                    found = true;
                    System.out.println("Vinnie found at y: " + (y + 1) + " x: " + (i + 1));
                    synchronized (Main.done) {
                        Main.done = Main.a.size();
                    }
                }

            if (!found) {
                System.out.println("Vinnie not found at row " + (y + 1));
                synchronized (Main.done) {
                    Main.done++;
                }
            }
        }
    }
}