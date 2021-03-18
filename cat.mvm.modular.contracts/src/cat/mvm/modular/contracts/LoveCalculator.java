package cat.mvm.modular.contracts;

import java.util.Random;
import java.text.Normalizer;

@FunctionalInterface
public interface LoveCalculator {
    public static final int MAX_VALUE = 100;
    public static final int MIN_VALUE = 0;

    public abstract int getCompatibilityBetween(String name1, String name2); //interface funcional (SAM - Single Abstract Method)

    /**
     * els tipus fills no estan obligats a sobreescriure'ls
     */
    public default int getIncompatibilityBetween(String name1, String name2) {
        return nextInt(LoveCalculator.MAX_VALUE);
    }

    private int nextInt(int bound){
        var rnd = new Random();
        return rnd.nextInt(bound + 1);
    }

    /**
     * Utility method
     * @param name
     * @return String
     */
    public static String normalize(String name){
        return normalizeNFD(name).replaceAll("\\p{Mn}", "");
    }

    private static String normalizeNFD(String name){
        return Normalizer.normalize(name, Normalizer.Form.NFD);//NFD: Forma Normal Disyuntiva
    }
}
