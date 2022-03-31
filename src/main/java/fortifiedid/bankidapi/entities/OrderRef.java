package fortifiedid.bankidapi.entities;

public class OrderRef
{
    private String orderRef;

    public OrderRef(String orderRef)
    {
        this.orderRef = orderRef;
    }

    @Override
    public String toString()
    {
        return orderRef;
    }
}


