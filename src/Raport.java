import java.util.ArrayList;

public class Raport {

    private static ArrayList<Samolot> listaSamolotwo = new ArrayList<>();

    public static void addSamolotToRaport(Samolot s) {
        listaSamolotwo.add(s);
    }

    public static ArrayList<Samolot> getListaSamolotwo() {
        if (listaSamolotwo == null) {
            System.out.println("Brak samolotow w liscie");
            return null;
        } else return listaSamolotwo;
    }

    public static void getRaport() {
        for (Samolot lista : listaSamolotwo) {
            System.out.println("///////////////////////////////////");
            System.out.println(lista.id);
            System.out.println(lista.destination);
            System.out.println(lista.obecnyStanPaliwa);
            System.out.println("///////////////////////////////////");
        }

    }

}
