package tc.fsm;
public class TestStateA extends State<String,String> {
    @Override
    public ProcessResult<String> process(String input) {
        return new ProcessResult<String>(TestStateB.class, "A:" + input);
    }
}
