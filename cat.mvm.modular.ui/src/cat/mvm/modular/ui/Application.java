package cat.mvm.modular.ui;

import cat.mvm.modular.contracts.LoveCalculator;
import cat.mvm.modular.entities.BasicLoveCalculator;
import cat.mvm.modular.entities.RandomLoveCalculator;
import cat.mvm.modular.entities.Space;

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

        Space<Integer> spaceInt = new Space<Integer>(0,0,1920, 1280);
        Space<Double> spaceDoub = new Space<Double>(0.0,0.0,50.0, 75.5);
        System.out.println(spaceInt);
        System.out.println(spaceDoub);
    }
}
