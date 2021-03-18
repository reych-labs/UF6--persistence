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
    }
}
