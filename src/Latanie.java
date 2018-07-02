
public class Latanie implements Runnable {

    private int id;
    boolean spadl;

    public Latanie(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        Samolot samolot = new Samolot(id);
        while (samolot.isRunning) {
            try {
                samolot.dzialaj();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


}
