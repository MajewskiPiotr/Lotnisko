import sun.awt.windows.ThemeReader;

public class Latanie implements Runnable {

    private int id;
    boolean spadl;
    Thread thread;
    Samolot samolot;

    public Latanie(int id) {
        this.id = id;
        thread = new Thread(this, String.valueOf(id));
        thread.start();
    }




    @Override
    public void run() {
        samolot = new Samolot(id);

        while (samolot.isRunning) {
            try {
                samolot.dzialaj();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
