package fortifiedid.bankidapi.auth;

import fortifiedid.bankidapi.entities.AutoStartToken;
import fortifiedid.bankidapi.entities.OrderRef;

public class AuthResult
{
    public final OrderRef orderRef;
    public final AutoStartToken autoStartToken;

    public AuthResult(OrderRef orderRef,AutoStartToken autoStartToken)
    {
        this.orderRef = orderRef;
        this.autoStartToken = autoStartToken;
    }
}
