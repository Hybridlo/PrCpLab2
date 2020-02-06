public class Petrov extends Thread {

    TransferPoint takePoint;
    TransferPoint givePoint;

    Petrov(TransferPoint takePoint, TransferPoint givePoint) {
        this.takePoint = takePoint;
        this.givePoint = givePoint;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            if(takePoint.size() > 0) {
                int packing = takePoint.take();

                givePoint.give(packing);

                System.out.println("Petrov packed item " + packing);
            }
        }
    }
}