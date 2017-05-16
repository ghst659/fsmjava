package tc.fsm;
public class TestStateC extends BaseTestingState implements State<String,String> {
    public ProcessResult<String> process(String input) {
        return new ProcessResult<>(tag(TestStateA.class), "C:" + input);
    }
}