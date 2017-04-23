package tc.fsm;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by tsc on 4/22/17.
 */
public class MachineTest {
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
}
