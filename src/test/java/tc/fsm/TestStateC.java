package tc.fsm;
public class TestStateC extends State<String,String> {
    @Override
    public ProcessResult<String> process(String input) {
        return new ProcessResult<String>(TestStateA.class, "C:" + input);
    }
}