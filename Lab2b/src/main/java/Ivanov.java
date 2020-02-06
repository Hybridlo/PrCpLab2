public class Ivanov extends Thread {

    TransferPoint takePoint;
    TransferPoint givePoint;

    Ivanov(TransferPoint takePoint, TransferPoint givePoint) {
        this.takePoint = takePoint;
        this.givePoint = givePoint;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            while(takePoint.size() > 0) {
                int taking = takePoint.take();

                givePoint.give(taking);

                System.out.println("Ivanov brought out item " + taking);
            }
        }
    }
}