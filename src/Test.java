import java.util.Date;
import java.util.Random;

public class Test {


    public static void main(String[] args) throws ClassNotFoundException {

        Lotnisko.setLotniska();
        int iloscWatkow = 10;
        Runnable[] latanie = new Runnable[iloscWatkow];
        //  Thread[] threads = new Thread[iloscWatkow];

        for (int i = 0; i < iloscWatkow; i++) {
            latanie[i] = new Latanie(i);


            //     threads[i] = new Thread(latanie[i]);
            //   threads[i].start();
        }

        while (true) {
            for (int i = 0; i < iloscWatkow; i++) {
                latanie[i] = new Latanie(i);
                Latanie lat = (Latanie) latanie[i];
                System.out.println("RAPORT --------- " + lat.samolot.getID());
            }
        }
    }


}
