package tc.fsm;

public interface State<I, V> {
    /**
     * Registration key.
     * @return String reg key.
     */
    String name();
    /**
     * Process inputs.
     * @param input the input vector into the state machine.
     * @return The ProcessResult that expresses the next state and data result.
     */
    ProcessResult<V> process(I input);
}
