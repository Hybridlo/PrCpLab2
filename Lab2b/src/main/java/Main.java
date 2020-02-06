import java.util.ArrayList;

public class Main {

    public static void main(String args[]) throws InterruptedException {

        ArrayList<Integer> storage = new ArrayList<>();

        int amount = 20;

        for (int i = 0; i < amount; i++) {
            storage.add(i);
        }

        TransferPoint tp1 = new TransferPoint(amount, storage);
        TransferPoint tp2 = new TransferPoint(amount);
        TransferPoint tp3 = new TransferPoint(amount);
        TransferPoint tp4 = new TransferPoint(amount);

        Ivanov ivanov = new Ivanov(tp1, tp2);
        Petrov petrov = new Petrov(tp2, tp3);
        Necheporuk necheporuk = new Necheporuk(tp3, tp4);
        ivanov.start();
        petrov.start();
        necheporuk.start();

        necheporuk.join();
        ivanov.interrupt();
        petrov.interrupt();
    }
}
