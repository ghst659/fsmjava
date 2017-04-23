package tc.fsm;
public class TestStateB extends State<String,String> {
    @Override
    public ProcessResult<String> process(String input) {
        return new ProcessResult<String>(TestStateC.class, "B:" + input);
    }
}