package tc.fsm;

public class State<I, V> {
    /**
     * Public constant property for this state, its registration key.
     */
    public final String name = this.getClass().getName();
    // private static final Pattern PAT = Pattern.compile(".*\\b(?<last>\\w+)$");
    /**
     * Constructor to set core name property.
     */
//    public State() {
//        String fullName = this.getClass().getName();
//        Matcher m = PAT.matcher(fullName);
//        this.name = m.matches() ? m.group("last") : fullName;
//    }
    /**
     * Virtual method that gets overridden by derived classes
     * @param input the input vector into the state machine.
     * @return The ProcessResult that expresses the next state and data result.
     */
    public ProcessResult<V> process(I input) {
        ProcessResult<V> result = new ProcessResult<V>(this.getClass(), null);
        return result;
    }
}
