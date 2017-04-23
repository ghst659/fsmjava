package tc.fsm;

/**
 * The result of a state's processing of an input vector.
 * @param <V> The type of the data result of processing.
 */
public final class ProcessResult<V> {
    public final Class next;
    public final V data;
    public ProcessResult(Class nextState, V data) {
        this.next = nextState;
        this.data = data;
    }
}
