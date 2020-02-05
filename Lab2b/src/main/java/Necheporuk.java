public class Necheporuk extends Thread {

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            if(Main.packed.size() > 0) {
                int calculating;

                synchronized (Main.packed) {
                    calculating = Main.packed.get(0);
                    Main.packed.remove(0);
                }

                Main.calculated.add(calculating);

                System.out.println("Necheporuk calculated item " + calculating);
            }

            if (Main.calculated.size() == Main.amount) {
                break;
            }
        }
    }
}