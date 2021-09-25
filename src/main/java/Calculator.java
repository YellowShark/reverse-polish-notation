import org.apache.commons.lang3.tuple.Pair;

public interface Calculator<T> {
    float execute(Operator operator, Pair<T, T> operands);
}
