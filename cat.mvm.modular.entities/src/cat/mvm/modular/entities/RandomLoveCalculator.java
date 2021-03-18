package cat.mvm.modular.entities;

import cat.mvm.modular.contracts.LoveCalculator;
import java.util.Random;//a java.base

public class RandomLoveCalculator implements LoveCalculator {
    @Override
    public int getCompatibilityBetween(String name1, String name2) {
        var rnd = new Random();
        return rnd.nextInt(LoveCalculator.MAX_VALUE + 1);
    }
}
