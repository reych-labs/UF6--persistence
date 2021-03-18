package cat.mvm.modular.contracts;

@FunctionalInterface
public interface LoveCalculator {
    public static final int MAX_VALUE = 100;
    public static final int MIN_VALUE = 0;

    public abstract int getCompatibilityBetween(String name1, String name2); //interface funcional (SAM - Single Abstract Method)


}
