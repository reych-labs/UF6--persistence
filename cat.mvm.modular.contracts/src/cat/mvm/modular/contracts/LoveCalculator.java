package cat.mvm.modular.contracts;

import java.util.Random;
import java.text.Normalizer;

@FunctionalInterface
public interface LoveCalculator {
    public static final int MAX_VALUE = 100;
    public static final int MIN_VALUE = 0;

    public abstract int getCompatibilityBetween(String name1, String name2); //interface funcional (SAM - Single Abstract Method)

    /**
     * defender method
     * els tipus fills no estan obligats a sobreescriure'ls
     */
    public default int getIncompatibilityBetween(String name1, String name2) {
        return nextInt(LoveCalculator.MAX_VALUE);
    }

    /**
     * mètode auxiliar
     * @param bound
     * @return int
     */
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
        // expressions regulars amb grups unicode amb Non-spacing mark
        return normalizeNFD(name).replaceAll("\\p{Mn}", "");
    }

    private static String normalizeNFD(String name){
        //NFD: Forma Normal Disjuntiva, Form->tipus enumerat anidat
        return Normalizer.normalize(name, Normalizer.Form.NFD);
    }
}
