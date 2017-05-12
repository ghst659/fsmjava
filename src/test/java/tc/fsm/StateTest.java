package tc.fsm;

import org.junit.Assert;
import org.junit.Test;

public class StateTest {
    @Test
    public void testStateName() {
        TestStateA a = new TestStateA();
        String name = a.name();
        Assert.assertTrue(String.format("got name %s", name), name.endsWith("TestStateA"));
    }
    @Test
    public void testStateProcessing() {
        TestStateA a = new TestStateA();
        TestStateB b = new TestStateB();
        TestStateC c = new TestStateC();
        ProcessResult<String> pr;
        pr = a.process("foo");
        Assert.assertEquals("tc.fsm.TestStateB", pr.next);
        Assert.assertEquals("A:foo", pr.data);
        pr = b.process("bar");
        Assert.assertEquals("tc.fsm.TestStateC", pr.next);
        Assert.assertEquals("B:bar", pr.data);
        pr = c.process("baz");
        Assert.assertEquals("tc.fsm.TestStateA", pr.next);
        Assert.assertEquals("C:baz", pr.data);
    }
}
