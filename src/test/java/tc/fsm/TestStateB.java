package tc.fsm;
public class TestStateB extends BaseTestingState implements State<String,String> {
    public ProcessResult<String> process(String input) {
        return new ProcessResult<>(tag(TestStateC.class), "B:" + input);
    }
}