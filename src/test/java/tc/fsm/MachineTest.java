package tc.fsm;

import org.junit.Assert;
import org.junit.Test;

public class MachineTest {
    @Test(expected=NullPointerException.class)
    public void testMachineGetNullState() {
        Machine<String, String> dut = new Machine<>();
        dut.registerState(new TestStateA());
        dut.registerState(new TestStateB());
        dut.registerState(new TestStateC());
        String unused = dut.getState();
    }
    @Test(expected=NullPointerException.class)
    public void testMachineProcessNullState() {
        Machine<String, String> dut = new Machine<>();
        dut.registerState(new TestStateA());
        dut.registerState(new TestStateB());
        dut.registerState(new TestStateC());
        String unused = dut.process("foo");
    }
    @Test
    public void testMachineSetState() {
        Machine<String, String> dut = new Machine<>();
        State<String, String> a = new TestStateA();
        dut.registerState(a);
        dut.registerState(new TestStateB());
        dut.registerState(new TestStateC());
        dut.setState(a.name());
        Assert.assertEquals("TestStateA", dut.getState());
    }
    @Test
    public void testMachineTransitions() {
        Machine<String, String> dut = new Machine<>(new TestStateA(), new TestStateB(), new TestStateC());
        Assert.assertTrue(dut.getState().endsWith("TestStateA"));
        String rA = dut.process("foo");
        Assert.assertEquals("A:foo", rA);
        Assert.assertTrue(dut.getState().endsWith("TestStateB"));
        String rB = dut.process("bar");
        Assert.assertEquals("B:bar", rB);
        Assert.assertTrue(dut.getState().endsWith("TestStateC"));
        String rC = dut.process("baz");
        Assert.assertEquals("C:baz", rC);
        Assert.assertTrue(dut.getState().endsWith("TestStateA"));
    }
    @Test
    public void testMachineString() {
        Machine<String, String> dut = new Machine<>(new TestStateA(), new TestStateB(), new TestStateC());
        String mText = dut.toString();
        Assert.assertEquals("{[TestStateA],TestStateB,TestStateC}", mText);
    }
}
