import java.util.ArrayList;

public class BeesThread extends Thread {

    Manager manager;

    BeesThread(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            int y;
            ArrayList<Integer> check;

            synchronized (manager.done) {
                if (manager.done >= manager.array.size())
                    break;

                y = manager.done;
                check = manager.array.get(y);
            }

            boolean found = false;

            for (int i = 0; i < check.size(); i++)
                if (check.get(i) == 1) {
                    found = true;
                    System.out.println("Vinnie found at y: " + (y + 1) + " x: " + (i + 1));
                    synchronized (manager.done) {
                        manager.done = manager.array.size();
                    }
                }

            if (!found) {
                System.out.println("Vinnie not found at row " + (y + 1));
                synchronized (manager.done) {
                    manager.done++;
                }
            }
        }
    }
}