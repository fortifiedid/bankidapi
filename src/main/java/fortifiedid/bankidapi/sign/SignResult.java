package fortifiedid.bankidapi.sign;

import fortifiedid.bankidapi.entities.AutoStartToken;
import fortifiedid.bankidapi.entities.OrderRef;

public class SignResult
{
    public final OrderRef orderRef;
    public final AutoStartToken autoStartToken;

    public SignResult(OrderRef orderRef,AutoStartToken autoStartToken)
    {
        this.orderRef = orderRef;
        this.autoStartToken = autoStartToken;
    }
}
