package cat.mvm.modular.entities;

public class Space<T> {
    private T minX, maxX, minY, maxY;

    public Space(T minX, T maxX, T minY, T maxY) {
        this.setMinX(minX);
        this.setMaxX(maxX);
        this.setMinY(minY);
        this.setMaxY(maxY);
    }

    public T getMinX() {
        return minX;
    }

    public void setMinX(T minX) {
        this.minX = minX;
    }

    public T getMaxX() {
        return maxX;
    }

    public void setMaxX(T maxX) {
        this.maxX = maxX;
    }

    public T getMinY() {
        return minY;
    }

    public void setMinY(T minY) {
        this.minY = minY;
    }

    public T getMaxY() {
        return maxY;
    }

    public void setMaxY(T maxY) {
        this.maxY = maxY;
    }

    @Override
    public String toString() {
        return "(" +
                "minX=" + minX +
                ", maxX=" + maxX +
                ", minY=" + minY +
                ", maxY=" + maxY +
                ')';
    }
}
