public class RaportRunable implements Runnable {

    private int id;
Thread thread;

    public RaportRunable(int id) {
        this.id = id;
        thread = new Thread(this, String.valueOf(id));
        thread.start();

    }


    @Override
    public void run() {
        while (true) {
            Raport.getRaport();
        }

    }


}
