import java.util.Random;

public class Samolot {
    int id;
    boolean spadl = false;
    boolean isRunning = true;
    int obecnyStanPaliwa;
    int maxStanPaliwa;
    int predkosc;
    Lotnisko destination;
    int odlegloscDoLotniska;

    public Samolot(int id) {
        this.id = id;
        System.out.println("tworze samolot " + id);
        maxStanPaliwa = new Random().nextInt(1000) + 1000;
        obecnyStanPaliwa = maxStanPaliwa;
        predkosc = new Random().nextInt(100) + 100;
        Raport.addSamolotToRaport(this);


    }


    public void dzialaj() throws InterruptedException {
        okreslDestynacje();
        startuj(destination);
        boolean dolecial = false;
        while (!dolecial) {
            if (obecnyStanPaliwa > 0) {
                if (lec() > 0) {
                    System.out.println("samolot id: " + getID() + " lece " + "do " + destination.name + " pozostalo mi " + odlegloscDoLotniska);

                } else {
                    dolecial = true;
                    System.out.println("samolot id: " + getID() + " dolecialem");
                }

            } else if (obecnyStanPaliwa <= 0) {
                rozbij();
                 break;
            }
        }
        if (dolecial) {
            laduj(destination);
            Thread.sleep(500);

        }
    }

    public void rozbij() {
        System.out.println("Kraksa **********************************************");
       System.out.println("samolot id: " + getID() + " rozbił sie z braku paliwa");
        spadl = true;
        setRunning(false);
        Thread.currentThread().stop();
    }

    public void okreslDestynacje() {
        Lotnisko nowaDestynacja = Lotnisko.getRandomLotnisko();
        while (destination == nowaDestynacja) {
            nowaDestynacja = Lotnisko.getRandomLotnisko();
        }
        destination = nowaDestynacja;
        odlegloscDoLotniska = destination.getOdlegloscDoLotniska();
        System.out.println("Destnacja: " + destination.name);
       System.out.println("Odleglosc: " + destination.getOdlegloscDoLotniska());
    }

    public int lec() {
        try {
            Thread.sleep(1000);
            obecnyStanPaliwa = obecnyStanPaliwa - predkosc;
            odlegloscDoLotniska = odlegloscDoLotniska - (predkosc);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return odlegloscDoLotniska;
    }

    public void koluj() {
        System.out.println("Kołuje ********************************************");
        obecnyStanPaliwa = obecnyStanPaliwa - predkosc;

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (obecnyStanPaliwa <= 0) {
            rozbij();
        }

    }

    public void zatankuj() {
        System.out.println("samolot id : " + getID() + " Tankuje");
        setObecnyStanPaliwa(getMaxStanPaliwa());
    }

    public void laduj(Lotnisko lotnisko) {
        System.out.println("LADUJE ********************************************");
        while (lotnisko.isPasZajety) {
            koluj();
        }

        lotnisko.isPasZajety = true;
        zatankuj();
    }

    public void startuj(Lotnisko lotnisko) {
        lotnisko.isPasZajety = false;
    }


    ///////////////////////////////////////////////////////////
    public int getID() {
        return id;
    }


    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }


    public int getObecnyStanPaliwa() {
        return obecnyStanPaliwa;
    }

    public void setObecnyStanPaliwa(int obecnyStanPaliwa) {
        this.obecnyStanPaliwa = obecnyStanPaliwa;
    }

    public int getMaxStanPaliwa() {
        return maxStanPaliwa;
    }

    public void setMaxStanPaliwa(int maxStanPaliwa) {
        this.maxStanPaliwa = maxStanPaliwa;
    }

    public int getPredkosc() {
        return predkosc;
    }

    public void setPredkosc(int predkosc) {
        this.predkosc = predkosc;
    }
}
