public class Necheporuk extends Thread {

    TransferPoint takePoint;
    TransferPoint givePoint;

    Necheporuk(TransferPoint takePoint, TransferPoint givePoint) {
        this.takePoint = takePoint;
        this.givePoint = givePoint;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            if(takePoint.size() > 0) {
                int calculating = takePoint.take();

                givePoint.give(calculating);

                System.out.println("Necheporuk calculated item " + calculating);
            }

            if (givePoint.size() == givePoint.amount) {
                break;
            }
        }
    }
}