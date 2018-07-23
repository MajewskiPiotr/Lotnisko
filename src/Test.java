import java.util.Date;
import java.util.Random;

public class Test {


    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
        Lotnisko.setLotniska();
        int iloscWatkow = 11;
        Runnable[] latanie = new Runnable[iloscWatkow];

        for (int i = 0; i < iloscWatkow; i++) {
            latanie[i] = new Latanie(i);
        }

    }
}


