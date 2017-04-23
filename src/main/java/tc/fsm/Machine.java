package tc.fsm;

import java.util.HashMap;
import java.util.Map;

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
    public Machine(State<I,V>... states) {
        if (states != null && states.length > 0) {
            for (State<I, V> s : states) {
                this.registerState(s);
            }
            this.setState(states[0].getClass());
        }
    }
    /**
     * Registers state S into this machine.
     * @param s a State object.
     * @return the string name of the state.
     */
    public synchronized String registerState(State<I,V> s) {
        this.states.put(s.name, s);
        return s.name;
    }
    /**
     * Get the current state as a string.
     * @return
     */
    public synchronized String getState() {
        if (this.currentState != null) {
            return this.currentState.name;
        } else {
            throw new NullPointerException("null current state");
        }
    }
    /**
     * Set the current state to be the registered instance of CLASS.
     * @param cls class of state to be set to.
     */
    public synchronized void setState(Class cls) {
        String stateName = cls.getName();
        if (this.states.containsKey(stateName)) {
            this.currentState = this.states.get(stateName);
        }
    }
    /**
     * Delegate processing tot he current state
     * @param input input vector to be processed.
     * @return the data result of the current state's processing.
     */
    public synchronized V process(I input) {
        V result = null;
        if (this.currentState != null) {
            ProcessResult<V> stateResult = this.currentState.process(input);
            result = stateResult.data;
            this.setState(stateResult.next);
        } else {
            throw new NullPointerException("null current state");
        }
        return result;
    }
}
