package fortifiedid.bankidapi.collect;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CollectRequestTest {

    @Test
    public void test() throws Exception {

        CollectRequest r = new CollectRequest("123456");
        
        CollectRequest r2 = CollectRequest.parseJson(r.toByte());
        
        Assert.assertTrue(r2.orderRef().equalsIgnoreCase(r.orderRef()));
        
        
        

    }

}
