package fortifiedid.bankidapi.collect;

import fortifiedid.bankidapi.util.JsonParser;
import fortifiedid.bankidapi.util.JsonParserException;

public class CollectResponse
{
    public String orderRef;
    public String status;
    public String hintCode;
    public CompletionData completionData = new CompletionData();

    public static CollectResponse parseJson(byte[]jsonData) throws JsonParserException
    {
        return new JsonParser().parse(jsonData,CollectResponse.class);
    }

    public String toJson() throws JsonParserException
    {
        return new JsonParser().toJson(this);
    }

    public class CompletionData
    {
        public User user = new User();
        public Device device = new Device();
        public Cert cert = new Cert();

        public String signature = "";
        public String ocspResponse = "";

        public class User
        {
            public String personalNumber;
            public String name;
            public String givenName;
            public String surname;
        }

        public class Device
        {
            public String ipAddress;
        }

        public class Cert
        {
            public String notBefore;
            public String notAfter;
        }
    }
}
