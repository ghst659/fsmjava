package tc.fsm;
public class TestStateA extends BaseTestingState implements State<String,String> {
    public ProcessResult<String> process(String input) {
        return new ProcessResult<>(tag(TestStateB.class), "A:" + input);
    }
}
