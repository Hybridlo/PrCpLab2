import java.util.ArrayList;

public class TransferPoint {

    int amount;
    ArrayList<Integer> array = new ArrayList<>();

    TransferPoint(int amount) {
        this.amount = amount;
    };

    TransferPoint(int amount, ArrayList<Integer> array) {
        this.amount = amount;
        this.array = array;
    }

    int take() {
        int taking;
        synchronized (array) {
            taking = array.get(0);
            array.remove(0);
        }
        return taking;
    }

    void give(int given) {
        synchronized (array) {
            array.add(given);
        }
    }

    int size() {
        return array.size();
    }
}
