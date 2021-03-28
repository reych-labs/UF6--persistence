package cat.mvm.modular.ui;

import cat.mvm.modular.contracts.LoveCalculator;
import cat.mvm.modular.entities.BasicLoveCalculator;
import cat.mvm.modular.entities.Player;
import cat.mvm.modular.entities.RandomLoveCalculator;
import cat.mvm.modular.entities.Space;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static java.util.Collections.*;

public class Application {
    public static void main(String[] args){
        var lc1 = new RandomLoveCalculator();
        System.out.println(LoveCalculator.normalize("Alamán"));
        System.out.println(LoveCalculator.normalize("García"));
        System.out.println(lc1.getCompatibilityBetween("Josep", "Maria"));

        var lc2 = new BasicLoveCalculator();
        System.out.println(lc2.getCompatibilityBetween("Josep", "Maria"));

        LoveCalculator lc = (name1, name2) -> String.format("Hola %s i %s", name1, name2);
        var lc3 = new LoveCalculator() {
            @Override
            public String sayHello(String name1, String name2) {
                return String.format("Hola %s i %s", name1, name2);
            }
        };
        System.out.println(lc.sayHello("Josep", "Maria"));
        System.out.println(lc3.sayHello("Josep", "Maria"));

        Space<Integer> spaceInt = new Space<Integer>(0,0,1920, 1280);
        Space<Double> spaceDoub = new Space<Double>(0.0,0.0,50.0, 75.5);
        System.out.println(spaceInt);
        System.out.println(spaceDoub);

        List<String> names = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<5; i++) {
            System.out.println("Introdueix un nom");
            names.add(sc.next());
        }
        Collections.sort(names);
        //fem una crida al mètode de la Helper Class Collections - Amb classe anònima
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        Collections.sort(names, (o1, o2) ->  o1.length() - o2.length());
        for (var n: names) {
            System.out.println(n);
        }
        names.forEach(e -> System.out.println(e));
        names.forEach(System.out::println);
        names.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        });
        names.replaceAll(s -> s.toUpperCase());

        names.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() <= 3;
            }
        });
        names.removeIf( s -> s.length() <= 3);
        names.forEach(System.out::println);

        List<Player> players = new ArrayList<>();
        players.add(new Player("Maria", "Delgado", 1.98, 85, 20000, LocalDate.of(1985, Month.MARCH, 23)));
        players.add(new Player("Sergio", "Garcia", 1.50, 91, 40000, LocalDate.of(1992, Month.APRIL, 3)));
        players.add(new Player("Pedro", "Sanchez", 1.80, 91, 32000, LocalDate.of(1985, Month.AUGUST, 21)));
        players.add(new Player("Mariano", "Aznar", 1.85, 92, 16000, LocalDate.of(1991, Month.NOVEMBER, 15)));
        players.add(new Player("Laura", "Madrid", 1.75, 75, 35000, LocalDate.of(1985, Month.DECEMBER, 10)));
        players.add(new Player("Vanessa", "Romero", 1.92, 80, 28500, LocalDate.of(1995, Month.SEPTEMBER, 5)));
        players.add(new Player("Jesus", "Quintero", 1.91, 85, 21000, LocalDate.of(1985, Month.OCTOBER, 5)));
        players.add(new Player("Alba", "Garcia", 1.91, 85, 21000, LocalDate.of(1974, Month.JANUARY, 9)));

        //filtrem els jugadors > 18
        //no s'està executant, sinó que preparem les operacions
        players.stream().filter(new Predicate<Player>() {
            @Override
            public boolean test(Player player) {
                return player.getAge() > 18;
            }
        });
        //map: indiquem què volem retornar
        players.stream().filter(player -> player.getAge() > 18)
                .map(p -> p.getSalary())
                .sorted((player1,player2) -> player1 - player2) //els ordena tenint en compte el seu salari
                .count();//amb aquest mètode, es quan s'executa tot el fluxe de crides

        System.out.printf("%nInfo sobre l'edat dels jugadors:%n");
        System.out.printf("------------------------------------------%n");
        double avgAge = players.stream()
                .mapToInt(e -> e.getAge())
                .average()
                .getAsDouble();
        int maxAge = players.stream()
                .mapToInt(e -> e.getAge())
                .max()
                .getAsInt();
        int minAge = players.stream()
                .mapToInt(e -> e.getAge())
                .min()
                .getAsInt();

        System.out.printf("- Mitjana d'edat': %.2f anys %n", avgAge);
        System.out.printf("- Màxima d'edat: %d anys %n", maxAge);
        System.out.printf("- Mínima d'edat: %d anys %n", minAge);

        System.out.printf("%nInfo sobre l'alçada dels jugadors:%n");
        System.out.printf("------------------------------------------%n");
        double avgHeight = players.stream()
                .mapToDouble(e -> e.getHeight())
                .average()
                .getAsDouble();
        double maxHeight = players.stream()
                .mapToDouble(e -> e.getHeight())
                .max()
                .getAsDouble();
        double minHeight = players.stream()
                .mapToDouble(e -> e.getHeight())
                .min()
                .getAsDouble();
        System.out.printf("- Mitjana d'alçada: %.2f m %n", avgHeight);
        System.out.printf("- Màxima d'alçada: %.2f m %n", maxHeight);
        System.out.printf("- Mínima d'alçada: %.2f m %n", minHeight);

        System.out.printf("%nInfo sobre el pes dels jugadors:%n");
        System.out.printf("------------------------------------------%n");
        double avgWeight = players.stream()
                .mapToInt(e -> e.getWeight())
                .average()
                .getAsDouble();
        int maxWeight = players.stream()
                .mapToInt(e -> e.getWeight())
                .max()
                .getAsInt();
        int minWeight = players.stream()
                .mapToInt(e -> e.getWeight())
                .min()
                .getAsInt();
        System.out.printf("- Mitjana de pes: %.2f Kg %n", avgWeight);
        System.out.printf("- Màxima de pes: %d kg %n", maxWeight);
        System.out.printf("- Mínima de pes: %d kg %n", minWeight);

        System.out.printf("%nInfo sobre el salari dels jugadors:%n");
        System.out.printf("------------------------------------------%n");
        double avgSalary = players.stream()
                .mapToInt(e -> e.getSalary())
                .average()
                .getAsDouble();
        int maxSalary = players.stream()
                .mapToInt(e -> e.getSalary())
                .max()
                .getAsInt();
        int minSalary = players.stream()
                .mapToInt(e -> e.getSalary())
                .min()
                .getAsInt();
        int sumSalary = players.stream()
                .mapToInt(e -> e.getSalary())
                .sum();
        System.out.printf("- Mitjana de salari: %.2f euros %n", avgSalary);
        System.out.printf("- Màxima de salari: %d euros %n", maxSalary);
        System.out.printf("- Mínima de salari: %d euros %n", minSalary);
        System.out.printf("- Suma de salaris: %d euros %n", sumSalary);

        System.out.printf("%nInfo sobre els noms dels jugadors:%n");
        System.out.printf("-----------------------------------------------%n");
        IntSummaryStatistics letterStats = players.stream()
                .mapToInt(e -> e.getFirstname().length())
                .summaryStatistics();

        System.out.printf("- Mitjana de lletres en nom: %.2f lletres %n", letterStats.getAverage());
        System.out.printf("- Màxima de lletres en nom: %d lletres %n", letterStats.getMax());
        System.out.printf("- Mínima de lletres en nom: %d lletres %n", letterStats.getMin());

    }
}
