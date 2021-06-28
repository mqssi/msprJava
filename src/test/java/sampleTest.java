import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class sampleTest {

    @Test
    public void testGood(){
        int a = 1;
        int b = 2;
        assertTrue(a + b == 3);


    }

    @Test
    public void testFail(){
        int a = 1;
        int b = 2;
        assertTrue(a + b == 3);

    }


    // @Test
    // public void testSetAgentObject(){

        // HashMap<Integer, Agent> agentList = new HashMap<>();
        // agentList.get(0).getListObject().get(0).setHasObject(true);
        // agentList.get(0).getListObject().get(6).setHasObject(true);
        // agentList.get(0).getListObject().get(4).setHasObject(true);

        assertTrue(agent.getListObject() =="test" );


    // }

}
