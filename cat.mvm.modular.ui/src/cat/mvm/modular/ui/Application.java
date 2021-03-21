package cat.mvm.modular.ui;

import cat.mvm.modular.contracts.LoveCalculator;
import cat.mvm.modular.entities.BasicLoveCalculator;
import cat.mvm.modular.entities.RandomLoveCalculator;

import java.util.Random;

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
    }
}
