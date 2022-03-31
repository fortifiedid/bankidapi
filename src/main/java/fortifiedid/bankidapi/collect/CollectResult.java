package fortifiedid.bankidapi.collect;

import fortifiedid.bankidapi.entities.CompletionData;
import fortifiedid.bankidapi.entities.HintCode;
import fortifiedid.bankidapi.entities.OrderRef;
import fortifiedid.bankidapi.entities.Status;

public class CollectResult {

    public final OrderRef orderRef;
    public final Status status;
    public final HintCode hintCode;
    public final CompletionData completionData;
    public final String rawresponse;

    public CollectResult(OrderRef orderRef, Status status, HintCode hintCode, CompletionData completionData, String rawData) {
	this.orderRef = orderRef;
	this.status = status;
	this.hintCode = hintCode;
	this.completionData = completionData;
	this.rawresponse = rawData;
    }
}
