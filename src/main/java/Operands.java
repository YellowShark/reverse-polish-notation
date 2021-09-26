import java.util.Objects;

public class Operands {
    private final float first;
    private final float second;

    public Operands(float first, float second) {
        this.first = first;
        this.second = second;
    }

    public float getFirst() {
        return first;
    }

    public float getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operands operands = (Operands) o;
        return Float.compare(operands.first, first) == 0 && Float.compare(operands.second, second) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
