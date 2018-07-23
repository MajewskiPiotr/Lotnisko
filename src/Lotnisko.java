import java.util.ArrayList;
import java.util.Random;

public class Lotnisko {

    public static ArrayList<Lotnisko> lotniska = new ArrayList<>();


    public static String[] nazwy = {"Warszawa", "Modlin", "Radom", "Krakow"};
    String name;
    boolean isPasZajety = false;
    int odlegloscDoLotniska;

    public Lotnisko(String name) {
        // System.out.println("utworzylem lotnisko " + name);
        isPasZajety = false;
        this.name = name;
    }

    public static void setLotniska() {

        for (int i = 0; i < nazwy.length; i++) {
            lotniska.add(new Lotnisko(nazwy[i]));
        }
        System.out.println(lotniska.toString());
    }

    public static Lotnisko getRandomLotnisko() {
        Lotnisko lotnisko = lotniska.get(new Random().nextInt(lotniska.size() - 1));
        lotnisko.setOdlegloscDoLotniska(new Random().nextInt(1000) + 1000);
        return lotnisko;
    }

    public void setOdlegloscDoLotniska(int odlegloscDoLotniska) {
        this.odlegloscDoLotniska = odlegloscDoLotniska;
    }

    public int getOdlegloscDoLotniska() {
        return odlegloscDoLotniska;
    }

}
