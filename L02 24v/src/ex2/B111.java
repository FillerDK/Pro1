package ex2;

public class B111 {
    public static void main(String[] args) {
        //Information given
        int birth = 7;
        int death = 13;
        int immigrant = 45;
        double popu = 312_032_486;
        int yDays = 365;

        double secPerYear = 60 * 60 * 24 * yDays;
        double birthPerYear = secPerYear / birth;
        double deathPerYear = secPerYear / death;
        double immigrantPerYear = secPerYear / immigrant;

        //Printing "year", "population", births per year
        System.out.println("year   population");
        for (int i = 1; i <= 5; i++) {
            popu = popu + birthPerYear - deathPerYear + immigrantPerYear;
            System.out.println(" " + i + "     " + popu);
        }

        System.out.println("Births per year: " + birthPerYear);
        System.out.println("Deaths per year: " + deathPerYear);
        System.out.println("Immigrants per year: " + immigrantPerYear);
    }
}
