package tc.fsm;
public class TestStateC extends BaseTestingState implements State<String,String> {
    public ProcessResult<String> process(String input) {
        return new ProcessResult<>(TestStateA.class.getName(), "C:" + input);
    }
}