package fortifiedid.bankidapi.entities;

public enum Status
{
    PENDING("pending"),
    FAILED("failed"),
    COMPLETE("complete"),
    UNKNOWN("unknown");

    private String status;

    Status(String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return status;
    }

    public static Status parse(String value)
    {
        if(PENDING.toString().equals(value))
            return PENDING;

        if(FAILED.toString().equals(value))
            return FAILED;

        if(COMPLETE.toString().equals(value))
            return COMPLETE;

        return UNKNOWN;
    }
}
