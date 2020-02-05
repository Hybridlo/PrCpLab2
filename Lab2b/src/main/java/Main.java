import java.util.ArrayList;

public class Main {

    static ArrayList<Integer> storage = new ArrayList<>();
    static ArrayList<Integer> broughtOut = new ArrayList<>();
    static ArrayList<Integer> packed = new ArrayList<>();
    static ArrayList<Integer> calculated = new ArrayList<>();
    static int amount = 20;

    public static void main(String args[]) throws InterruptedException {

        for (int i = 0; i < amount; i++) {
            storage.add(i);
        }

        Ivanov ivanov = new Ivanov();
        Petrov petrov = new Petrov();
        Necheporuk necheporuk = new Necheporuk();
        ivanov.start();
        petrov.start();
        necheporuk.start();

        necheporuk.join();
        ivanov.interrupt();
        petrov.interrupt();
    }
}
