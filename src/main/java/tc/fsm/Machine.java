package tc.fsm;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * A state machine transition controller.
 * @param <I>
 * @param <V>
 */
public final class Machine<I, V> {
    private State<I,V> currentState = null;
    private Map<String, State<I,V>> states = new HashMap<>();
    /**
     * Constructor with optional set of initial states to register.
     * @param states repeated states, of which the first is the initial state.
     */
    @SafeVarargs
    public Machine(State<I,V>... states) {
        if (states != null && states.length > 0) {
            for (State<I, V> s : states) {
                this.registerState(s);
            }
            this.setState(states[0].name());
        }
    }
    /**
     * Registers state S into this machine.
     * @param s a State object.
     */
    public synchronized void registerState(State<I,V> s) {
        this.states.put(s.name(), s);
    }
    /**
     * Get the current state as a string.
     * @return String key of the current state.
     */
    public synchronized String getState() {
        if (this.currentState != null) {
            return this.currentState.name();
        } else {
            throw new NullPointerException("null current state");
        }
    }
    /**
     * Set the current state to be the registered instance of CLASS.
     * @param stateName name of state to be set to.
     */
    public synchronized void setState(String stateName) {
        if (this.states.containsKey(stateName)) {
            this.currentState = this.states.get(stateName);
        }
    }
    /**
     * Delegate processing to the current state
     * @param input input vector to be processed.
     * @return the data result of the current state's processing.
     */
    public synchronized V process(I input) {
        V result;
        if (this.currentState != null) {
            ProcessResult<V> stateResult = this.currentState.process(input);
            result = stateResult.data;
            this.setState(stateResult.next);
        } else {
            throw new NullPointerException("null current state");
        }
        return result;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        SortedSet<String> allKeys = new TreeSet<>(this.states.keySet());
        boolean rest = false;
        for (String key: allKeys) {
            if (rest) {
                result.append(",");
            }
            boolean current = (this.currentState != null && this.currentState.name().equals(key));
            if (current) {
                result.append("[");
            }
            result.append(key);
            if (current) {
                result.append("]");
            }
            rest = true;
        }
        result.append("}");
        return result.toString();
    }
}
