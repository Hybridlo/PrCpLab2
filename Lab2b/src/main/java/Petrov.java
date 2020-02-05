public class Petrov extends Thread {

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            if(Main.broughtOut.size() > 0) {
                int packing;

                synchronized (Main.broughtOut) {
                    packing = Main.broughtOut.get(0);
                    Main.broughtOut.remove(0);
                }

                synchronized (Main.packed) {
                    Main.packed.add(packing);
                }

                System.out.println("Petrov packed item " + packing);
            }
        }
    }
}