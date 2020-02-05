public class Ivanov extends Thread {

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            while(Main.storage.size() > 0) {
                int taking = Main.storage.get(0);

                Main.storage.remove(0);

                synchronized (Main.broughtOut) {
                    Main.broughtOut.add(taking);
                }

                System.out.println("Ivanov brought out item " + taking);
            }
        }
    }
}